package main;

import java.util.ArrayList;
import java.util.List;

public class CPD {

    private Event[] processors;
    private SyncQueue queue;
    private List<Event> listaSalidas;
    private double clock;
    private FEL fel;

    public CPD(int numProcessors, int queueSize, FEL fel) {
        processors = new Event[numProcessors];
        for (int i = 0; i<numProcessors; i++){
            processors[i] = null;
        }
        queue = new SyncQueue(queueSize);
        listaSalidas = new ArrayList();
        clock = 0;
        this.fel = fel;
    }

    public void process(){

    }

}
