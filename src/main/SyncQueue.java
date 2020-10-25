package main;

import java.util.ArrayList;
import java.util.List;

public class SyncQueue<Event> {

    private List<main.Event> list;
    private int maxSize;

    public SyncQueue(int maxSize) {
        list = new ArrayList<main.Event>();
        this.maxSize = maxSize;
    }

    synchronized public int size() {
        return list.size();
    }

    synchronized public boolean isEmpty() {
        return size()==0;
    }

    synchronized public void clear() {
        list.clear();
    }

    synchronized public boolean put(main.Event e) {
        if (list.size()<=maxSize){
            list.add(e);
            return true;
        }
        return false;
    }

    public main.Event remove() {
        if (isEmpty()){
            return null;
        }
        main.Event event = list.get(0);
        list.remove(0);
        return event;
    }

}
