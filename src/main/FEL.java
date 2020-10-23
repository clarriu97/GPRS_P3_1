package main;

import java.util.List;

public class FEL {

    private List<Event> list;

    public FEL(List list) {
        this.list = list;
    }

    public void addEvent(Event event){
        list.add(event);
        //TODO: must sort the list, putting the first event the closest


    }

    public Event getInminentEvent(){
        return list.isEmpty()?null:list.get(0);
    }

    public void print(){
        if (!list.isEmpty()){
            for (Event event: list){
                event.print();
            }
        }
    }
}
