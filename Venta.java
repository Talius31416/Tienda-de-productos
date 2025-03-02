package Java.Principiantes;
import java.time.LocalDate;//se importa la libreria para manejar fechas
import java.time.format.DateTimeFormatter;


public class Venta {
    //Se crean los atributos de la clase;
    private LocalDate fecha;//el tipo de dato que se usa para definir una fecha
    private Cliente cliente;
    private Producto producto;
    private int cantidadComprada;
    private float montoTotal;
    //Se crea el constructor de la clase para poder instanciarla
    public Venta(LocalDate fecha, Cliente cliente, Producto producto, int cantidadComprada, float montoTotal) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidadComprada = cantidadComprada;
        this.montoTotal = montoTotal;
    }
    //EN esta seccion se encuentran los setters y getter de la clase
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getCantidadComprada() {
        return cantidadComprada;
    }
    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }
    public float getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
    //Al ser fecha una clase, se le crea su propio toString, lo mismo para la venta
    public String fechaToString() {
        return fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    public String ventaToString() {
        return "Cliente: "+cliente.getNombre()+"\nProducto: "+producto.getNombre()+"\nFecha: "+fechaToString()+"\nCantidad Comprada: "+cantidadComprada+"\nMonto Total: "+montoTotal;
    }

}
