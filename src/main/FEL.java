package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FEL {

    private List<Event> eventList;

    public FEL() {
        eventList = new ArrayList<>();
    }

    public void addEvent(Event event){
        eventList.add(event);
        Collections.sort(eventList);
    }

    public boolean hasEvent(){
        return !eventList.isEmpty();
    }

    public Event getInminentEvent(){
        Event event = eventList.get(0);
        eventList.remove(0);
        return event;
    }

    public void print(){
        if (!eventList.isEmpty()){
            for (Event event: eventList){
                event.print();
            }
        }
    }
}
