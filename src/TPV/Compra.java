package TPV;

public class Compra {
    private String nombre_producto;
    private float precio,subtotal;
    private int cantidad;

    public Compra(String nombre_producto, float precio, int cantidad, float subtotal) {
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }
}