package Java.Principiantes;

public class Producto {
    //Se crean los atributos de la clase
    private String nombre;
    private String codigoDeProducto;
    private float precio;
    private String categoria;
    private int stockDisponible;

    //Se crea el contructor de la clase
    public Producto(String nombre, String codigoDeProducto, float precio, String categoria, int stockDisponible) {
        this.nombre = nombre;
        this.codigoDeProducto = codigoDeProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.stockDisponible = stockDisponible;
    }
    //Los metodos setters getter y toString de la clase
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigoDeProducto() {
        return codigoDeProducto;
    }
    public void setCodigoDeProducto(String codigoDeProducto) {
        this.codigoDeProducto = codigoDeProducto;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getStockDisponible() {
        return stockDisponible;
    }
    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
    public String productoToString() {
        return "Nombre: "+nombre+"\nCodigo: "+codigoDeProducto+"\nPrecio: "+precio+"\nCategoria: "+categoria+"\nStock: "+stockDisponible;
    }


}
