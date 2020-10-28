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

    public void makeFile(){

    }

}
