package main;

public class Event implements Comparable<Event> {

    private boolean basic, reentrada, acepted;
    private double tiempoLlegada;
    private double tiempoServicio;
    private double tiempoSalida;

    public Event(boolean basic, double tiempoLlegada, double tiempoServicio, boolean reentrada) {
        this.basic = basic;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoServicio = tiempoServicio;
        this.reentrada = reentrada;
        tiempoSalida = tiempoLlegada + tiempoServicio;
        acepted = true;
    }

    public void print(){
        System.out.print("Tipo: " + basic + "\n" +
                "Tiempo de llegada: " + Double.toString(tiempoLlegada) + "\n" +
                "Tiempo de servicio: " + Double.toString(tiempoServicio) + "\n" +
                "Reentrada: " + reentrada + "\n\n");
    }

    public Double getTiempoLlegada(){
        return tiempoLlegada;
    }

    public double getTiempoSalida() {
        return tiempoSalida;
    }

    public double getTiempoServicio() {
        return tiempoServicio;
    }

    public boolean isReentrada() {
        return reentrada;
    }

    @Override
    public int compareTo(Event event) {
        return Double.compare(tiempoLlegada, event.getTiempoLlegada());
    }

    public void setAcepted(boolean acepted) {
        this.acepted = acepted;
    }

    public boolean isAcepted(){return acepted;}

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
        tiempoSalida = tiempoLlegada + tiempoServicio;
    }

}
