package main;

import java.util.ArrayList;
import java.util.List;

public class CPD {

    private Event[] processors;
    private SyncQueue queue;
    private Salida salida;
    private double clock;
    private FEL fel;

    public CPD(int numProcessors, int queueSize, FEL fel) {
        processors = new Event[numProcessors];
        for (int i = 0; i<numProcessors; i++){
            processors[i] = null;
        }
        queue = new SyncQueue(queueSize);
        salida = new Salida();
        clock = 0.000000;
        this.fel = fel;
    }

    public void process(){
        while (!fel.isEmpty() && !queue.isEmpty() && !processorsAreEmpty()){

            //Si ha terminado algun evento de algun procesador, lo proceso
            for (int i = 0; i<processors.length; i++){
                if (processors[i] != null){
                    if (processors[i].getTiempoSalida() >= clock){
                        processProcessorEvent(processors[i], i);
                    }
                }
            }

            //Si hay algun evento en la cola, miro a ver si hay algun procesador libre
            //si hay algun procesador libre, proceso el evento de la cola
            if (!queue.isEmpty()){
                if (!processorsAreFull()){
                    processQueueEvent(queue.get());
                }
            }

            //Si hay algun evento de la FEL que toque procesar, lo procesamos


            clock += 0.000001;
        }
    }

    private void processFELEvent(Event event){
        if (!processorsAreFull()){
            processors[getFreeProcessor()] = event;
        } else if (!queue.isFull()){
            queue.put(event);
        } else {
            event.setAcepted(false);
            salida.add(event);
        }
    }

    private void processQueueEvent(Event event){
        processors[getFreeProcessor()] = event;
    }

    private void processProcessorEvent(Event event, int freePos){
        salida.add(event);
        processors[freePos] = null;
    }

    private boolean processorsAreEmpty(){
        boolean empty = true;
        for (int i = 0; i<processors.length; i++){
            if (processors[i] != null){
                empty = false;
            }
        }
        return empty;
    }

    private boolean processorsAreFull(){
        boolean full = true;
        for (int i = 0; i<processors.length; i++){
            if (processors[i] == null){
                full = false;
            }
        }
        return full;
    }

    private int getFreeProcessor(){
        int freeProcessor = -1;
        for (int i = 0; i<processors.length; i++){
            if (processors[i] != null){
                freeProcessor = i;
                break;
            }
        }
        return freeProcessor;
    }

}
