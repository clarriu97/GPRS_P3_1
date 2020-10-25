package main;

public class Event implements Comparable<Event> {

    private String tipo;
    private double tiempoLlegada;
    private double tiempoServicio;
    private boolean reentrada;
    private double tiempoSalida;
    private boolean accepted;

    public Event(String tipo, double tiempoLlegada, double tiempoServicio, boolean reentrada) {
        this.tipo = tipo;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoServicio = tiempoServicio;
        this.reentrada = reentrada;
        tiempoSalida = tiempoLlegada + tiempoServicio;
    }

    public void print(){
        System.out.print("Tipo: " + tipo + "\n" +
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

    public String getTipo() {
        return tipo;
    }

    public double getTiempoServicio() {
        return tiempoServicio;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isReentrada() {
        return reentrada;
    }

    @Override
    public int compareTo(Event event) {
        return Double.compare(tiempoLlegada, event.getTiempoLlegada());
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setTiempoSalida(double tiempoSalida) {
        this.tiempoSalida = tiempoSalida;
    }

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
        tiempoSalida = tiempoLlegada + tiempoServicio;
    }
}
