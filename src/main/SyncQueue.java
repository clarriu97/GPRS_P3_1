package main;

import java.util.ArrayList;
import java.util.List;

public class SyncQueue<Event> {

    private List<Event> list;
    private int maxSize;

    public SyncQueue(int maxSize) {
        list = new ArrayList<Event>();
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

    synchronized public boolean put(Event e) {
        if (list.size()<=maxSize){
            list.add(e);
            return true;
        }
        return false;
    }

    synchronized public Event remove() {
        return isEmpty()?null:list.remove(0);
    }

}
