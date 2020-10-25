package main;

import java.util.ArrayList;
import java.util.List;

public class CPD {

    private List<Event> processors;
    private SyncQueue queue;
    private List<Event> listaSalidas;
    private double clock;
    private FEL fel;

    public CPD(int numProcessors, int queueSize, FEL fel) {
        processors = new ArrayList<Event>();
        for (int i = 0; i<numProcessors; i++){
            processors.add(null);
        }
        queue = new SyncQueue(queueSize);
        listaSalidas = new ArrayList();
        clock = 0;
        this.fel = fel;
    }

    public void checkFinishedEvents(){
        for (int i = 0; i<processors.size(); i++){
            Event event = processors.get(i);
            if (event != null && event.getTiempoSalida() >= clock){
                if (event.isReentrada()){
                    fel.addEvent(new Event(event.getTipo(), event.getTiempoSalida(), event.getTiempoServicio(), false));
                }
                listaSalidas.add(event);
                processors.remove(i);
                processors.add(i, null);
            }
            if (!queue.isEmpty()){
                queueToProcessor(i);
            }
        }

    }

    public void queueToProcessor(int i) {
        Event event = queue.remove();
        event.setAccepted(true);

        double lastEventTime = listaSalidas.get(listaSalidas.size()-1).getTiempoSalida();
        event.setTiempoLlegada(Math.max(event.getTiempoLlegada(), lastEventTime));

        processors.add(i, event);
    }

    public int checkEmptyProcessor(){
        int pos = -1;
        for (int i = 0; i<processors.size(); i++){
            if (processors.get(i) == null){
                pos = i;
                break;
            }
        }
        return pos;
    }

    public boolean processEvent(Event event){
        while (getNextEventEnd() < event.getTiempoLlegada()){
            updateClock(getNextEventEnd());
        }

        if (queue.isEmpty()){
            int result = checkEmptyProcessor();
            if (result >= 0){
                event.setAccepted(true);
                event.setTiempoSalida(event.getTiempoLlegada() + event.getTiempoServicio());
                processors.add(result, event);
                return true;
            }
        }
        if (queue.put(event)){
            return true;
        } else {
            event.setAccepted(false);
            event.setTiempoSalida(event.getTiempoLlegada());
            listaSalidas.add(event);
            return false;
        }
    }

    public void finishProcessing(){
        while (!isEmpty()){
            updateClock(getNextEventEnd());
        }
        for (Event event: listaSalidas){
            System.out.println(Double.toString(event.getTiempoLlegada())
                                + Double.toString(event.getTiempoServicio())
                                + " ");
            if (event.isAccepted()){
                System.out.print("0");
            } else {System.out.print("1");}
        }
    }

    public boolean isEmpty(){
        boolean finished = true;
        for (int i = 0; i<processors.size(); i++){
            if (processors.get(i) != null){finished = false;}
        }
        return finished;
    }

    public double getNextEventEnd(){
        if (isEmpty()){
            return Double.MAX_VALUE;
        }
        ArrayList<Double> salidas = new ArrayList();
        for (int i = 0; i<processors.size(); i++){
            if (processors.get(i) != null){processors.get(i).getTiempoSalida();}
        }
        double min = Double.MAX_VALUE;
        for (Double d: salidas){
            if (d < min){
                min = d;
            }
        }
        return min;
    }

    public void updateClock(double clock){
        this.clock = clock;
        checkFinishedEvents();
    }

}
