package Java.Principiantes;

public class Cliente {
    //se crean loa tributos de la clase
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;
    //se crea el constructor de la clase
    public Cliente(String nombre, String identificacion, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;

    }
    //Setters y getters de la clase cliente
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String clienteToString() {
        return "Nombre: "+nombre+"\nIdentificacion: "+identificacion+"\nDireccion: "+direccion+"\nTelefono: "+telefono+"\nEmail: "+email;
    }

}
