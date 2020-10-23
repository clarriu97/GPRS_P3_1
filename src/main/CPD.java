package main;

import java.util.ArrayList;
import java.util.List;

public class CPD {

    private List<Boolean> processors;
    private SyncQueue queue;
    private List listaSalidas;
    private double clock;
    private FEL fel;

    public CPD(int numProcessors, int queueSize, FEL fel) {
        processors = new ArrayList<Boolean>();
        for (int i = 0; i<numProcessors; i++){
            processors.add(false);
        }
        queue = new SyncQueue(queueSize);
        listaSalidas = new ArrayList();
        clock = 0;
        this.fel = fel;
    }


}
