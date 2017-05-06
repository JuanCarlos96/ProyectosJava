package TPV;

import java.util.ArrayList;

public class Ticket {
    private int id;
    private String fecha;
    private float precio_total;
    private ArrayList<Producto> productos;

    public Ticket(int id, String fecha, float precio_total, ArrayList<Producto> productos) {
        this.id = id;
        this.fecha = fecha;
        this.precio_total = precio_total;
        this.productos = productos;
    }

    @Override
    public String toString() {
        String ticket="Ticket "+id+"                  Fecha: "+fecha+"\n\n";
        for(Producto p:productos) {
            ticket+=p+"\n";
        }
        ticket+="---------------------------------------------------------";
        ticket+="\nPRECIO TOTAL: "+precio_total+"€";
        return ticket;
    }
}