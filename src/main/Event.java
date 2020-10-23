package main;

public class Event implements Comparable<Event> {

    private String tipo;
    private double tiempoLlegada;
    private double tiempoServicio;
    private boolean reentrada;

    public Event(String tipo, double tiempoLlegada, double tiempoServicio, boolean reentrada) {
        this.tipo = tipo;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoServicio = tiempoServicio;
        this.reentrada = reentrada;
    }

    public void print(){
        System.out.print("Tipo: " + tipo + "\n" +
                "Tiempo de llegada: " + Double.toString(tiempoLlegada) + "\n" +
                "Tiempo de servicio: " + Double.toString(tiempoServicio) + "\n" +
                "Reentrada: " + reentrada);
    }

    public Double getTiempoLlegada(){
        return tiempoLlegada;
    }

    @Override
    public int compareTo(Event event) {
        return Double.compare(tiempoLlegada, event.getTiempoLlegada());
    }
}
