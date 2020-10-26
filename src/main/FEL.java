package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FEL {

    private List<Event> list;

    public FEL() {
        list = new ArrayList<>();
    }

    public void addEvent(Event event){
        list.add(event);
        Collections.sort(list);
    }

    public boolean hasEvent(){
        return !list.isEmpty();
    }

    public Event getInminentEvent(){
        Event event = list.get(0);
        list.remove(0);
        return event;
    }

    public void print(){
        if (!list.isEmpty()){
            for (Event event: list){
                event.print();
            }
        }
    }
}
