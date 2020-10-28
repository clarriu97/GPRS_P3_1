package main;

import java.util.ArrayList;
import java.util.List;

public class Salida {

    private List<Event> listaSalidas;

    public Salida(){
        listaSalidas = new ArrayList<>();
    }

    public void add(Event event){
        listaSalidas.add(event);
    }

    public void finishProcesing() {
        for (Event event: listaSalidas){
            System.out.println(event.getTiempoLlegada() + " " + event.getTiempoServicio() + " ");
            if (event.isAcepted()){
                System.out.print("0");
            } else {System.out.print("1");}
        }
    }
}
