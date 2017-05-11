package TPV;

import java.sql.Date;

public class Ticket {
    private int id;
    private Date fecha;
    private float precio_total;

    public Ticket(int id, Date fecha, float precio_total) {
        this.id = id;
        this.fecha = fecha;
        this.precio_total = precio_total;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getPrecio_total() {
        return precio_total;
    }

    @Override
    public String toString() {
        return "Ticket "+id;
    }
}