package Java.Principiantes;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    //se crean las 3 listas, donde se van a guardar los datos de los clientes, productos y ventas
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Producto> productos = new ArrayList<Producto>();
    private List<Venta> ventas = new ArrayList<Venta>();

    // aca empieza el CRUD del programa, donde se van a administrar los datos de cada cliente producto y venta.
    private Cliente agregarCliente(){
        String nombre = ingresarTexto("ingrese el nombre: ");
        String identificacion = ingresarTexto("ingrese el identificacion: ");
        for(Cliente cliente : clientes){
            if(cliente.getIdentificacion().equals(identificacion)){//se confirma que no haya un cliente con un codigo repetido
                JOptionPane.showMessageDialog(null, "El cliente ya existe");
                return null;
            }
        }
        String direccion = ingresarTexto("ingrese el direccion: ");
        String telefono = ingresarTexto("ingrese el telefono: ");
        String email = ingresarTexto("ingrese el email: ");
        Cliente cliente = new Cliente(nombre, identificacion, direccion, telefono, email);
        clientes.add(cliente);//se añade el cliente a la lista y lo retorna
        return cliente;
    }
    public void editarCliente(){
        Cliente cliente = seleccionarCliente();//esta funcion se encarga de retornar un cliente donde se pueda seleccionar entre una lista de clientes
        if(cliente == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");//revisa que la lista este llena para realizar la accion
            return;
        }
        //se usan los setter para editar los datos del cliente
        cliente.setNombre(ingresarTexto("ingrese el nombre: "));
        cliente.setIdentificacion(ingresarTexto("ingrese el identificacion: "));
        cliente.setDireccion(ingresarTexto("ingrese el direccion: "));
        cliente.setTelefono(ingresarTexto("ingrese el telefono: "));
        cliente.setEmail(ingresarTexto("ingrese el email: "));

    }
    public void mostrarCliente(){
        Cliente cliente = seleccionarCliente();//Usa la misma funcion de seleccionar un cliente para mostrar el cliente
        JOptionPane.showMessageDialog(null, cliente.clienteToString());
    }
    public void eliminarCliente() {
        Cliente cliente = seleccionarCliente();//se elimina cliente de la lista y asi ya no se puede seleccionar más
        clientes.remove(cliente);
    }

    private Producto agregarProducto(){
        String nombre = ingresarTexto("ingrese el nombre: ");
        String codigo = ingresarTexto("ingrese el codigo: ");
        for(Producto producto : productos){
            if(producto.getCodigoDeProducto().equals(codigo)){//se verifica que el codigo del producto no este en la lista de productos
                JOptionPane.showMessageDialog(null, "El producto ya existe");
                return null;
            }
        }
        float precio = ingresarFloat("ingrese el precio: ");
        String categoria = ingresarTexto("ingrese el categoria: ");
        int stock = ingresarNumero("ingrese el stock: ");
        Producto producto = new Producto(nombre, codigo, precio, categoria, stock);
        productos.add(producto);//añade el producto a la lista de productos para poder utilizarlos en el futuro
        return producto;
    }
    public void editarProducto(){
        Producto producto = seleccionarProducto();//se selecciona el producto para poder editarlo con los setters y getters
        producto.setNombre(ingresarTexto("ingrese el nombre: "));
        producto.setCodigoDeProducto(ingresarTexto("ingrese el codigo: "));
        producto.setPrecio(ingresarFloat("ingrese el precio: "));
        producto.setCategoria(ingresarTexto("ingrese el categoria: "));
        producto.setStockDisponible(ingresarNumero("ingrese el stock: "));

    }
    public void mostrarProducto(){
        Producto producto = seleccionarProducto();
        JOptionPane.showMessageDialog(null, producto.productoToString());
    }
    public void eliminarProducto(){
        Producto producto = seleccionarProducto();
        productos.remove(producto);
    }

    public void agregarVentas() {
        boolean salida = false;
        Cliente cliente = null;
        while(!salida){//aca usamos un menu de seleccion para mostrar si se debe agregar un cliente o producto, o si se debe escoger de la lista
            int opcion = ingresarNumero("ingrese 1 para registrar cliente y 2 para saleccionar un cliente: ");
            if(opcion == 1){
                cliente = agregarCliente();
                if(cliente == null){//verifica que cliente no sea igual a null
                    JOptionPane.showMessageDialog(null, "El cliente ya existe");
                    return;
                }
                salida = true;
            }else if(opcion == 2){
                if(clientes.isEmpty()){
                    JOptionPane.showMessageDialog(null, "no hay clientes");
                    return;
                }
                cliente = seleccionarCliente();
                salida = true;
            }else{
                JOptionPane.showMessageDialog(null, "Opcion no valida");
                return;
            }
        }
        Producto producto = null;
        salida = false;
        while(!salida) {
            int opcion = ingresarNumero("ingrese 1 para registrar producto y 2 para saleccionar un producto: ");
            if (opcion == 1) {
                producto = agregarProducto();
                if(producto == null){//verifica que el producto no sea igual a null
                    JOptionPane.showMessageDialog(null, "El producto ya existe");
                    return;
                }
                salida = true;
            } else if (opcion == 2) {
                if(productos.isEmpty()){
                    JOptionPane.showMessageDialog(null, "no hay productos");
                    return;
                }
                producto = seleccionarProducto();
                salida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Opcion no valida");
                return;
            }
        }
        LocalDate fecha = ingresarDate("ingrese el fecha: ");
        if (seleccionarProducto().getStockDisponible() <= 0) {
            JOptionPane.showMessageDialog(null, "El producto no tiene stock disponible");//verifica que la cantidad que pidio el cliente sea igual o menor a la cantidad en el stock
            return;
        }
        int cantidadComprada = ingresarNumero("ingrese el cantidad de comprada: ");
        if( seleccionarProducto().getStockDisponible() - cantidadComprada < 0){
            JOptionPane.showMessageDialog(null, "El producto no tiene el stock disponible para esa cantidad");
            return;
        }
        producto.setStockDisponible(producto.getStockDisponible() - cantidadComprada);
        float montoTotal = cantidadComprada * producto.getPrecio();
        Venta venta = new Venta(fecha, cliente, producto, cantidadComprada, montoTotal);
        ventas.add(venta);
    }
    public void editarVentas(){
        if (ventas.isEmpty()) {//verifica si la lista esta vacia o no
            JOptionPane.showMessageDialog(null, "No hay ventas disponibles");
            return;
        }
        Venta venta = seleccionarVenta();//selecciona una de las ventas realizadas para asi poder editar sus datos
        venta.setCliente(seleccionarCliente());
        venta.setProducto(seleccionarProducto());
        venta.setFecha(ingresarDate("ingrese el fecha: "));
        venta.setCantidadComprada(ingresarNumero("ingrese el cantidad de comprada: "));
        venta.setMontoTotal(seleccionarProducto().getPrecio()*venta.getCantidadComprada());
    }
    public void mostrarVentas(){
        if (ventas.isEmpty()) {//verifica que la funcion no este vacia y asi poder mostrar sus datos
            JOptionPane.showMessageDialog(null, "No hay ventas disponibles");
            return;
        }
        Venta venta = seleccionarVenta();
        JOptionPane.showMessageDialog(null, venta.ventaToString());//muestra los datos de la venta
    }
    public void eliminarVentas(){
        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ventas disponibles");
            return;
        }
        Venta venta = seleccionarVenta();
        ventas.remove(venta);
    }
//esta funcion se encarga de verificar la entrada de texto que no este vacia
    private String ingresarTexto(String texto){
        String mensaje = "";
        boolean salida = false;
        while(!salida){
            mensaje = JOptionPane.showInputDialog(null, texto);
            if(mensaje.isEmpty()){
                JOptionPane.showMessageDialog(null, "La salida no puede estar vacia");
            }else{
                salida = true;
            }
        }

        return mensaje;
    }
//esta funcion se encarga de verificar que lo que se ingresó sea un número, esto lo hace con la excepcion NumberFormatException
    private int ingresarNumero(String texto){
        int numero = 0;
        boolean salida = false;
        while(!salida){
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, texto));
                if(numero < 0){
                    JOptionPane.showMessageDialog(null, "El numero no puede ser negativo");
                }else{
                    salida = true;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
            }
        }
        return numero;
    }
    //est funcion es similar a la de ingresar número, solo que también permite numeros decimales
    private float ingresarFloat(String texto){
        float numero = 0;
        boolean salida = false;
        while(!salida){
            try {
                numero = Float.parseFloat(JOptionPane.showInputDialog(null, texto));
                if(numero < 0){
                    JOptionPane.showMessageDialog(null, "El numero no puede ser negativo");
                }else{
                    salida = true;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
            }
        }
        return numero;
    }
    //esta funcion se encarga de verificar que usted como usuario ingrese fechas correctas y no fechas aleatorias con numerous de días que no son posibles
    private LocalDate ingresarDate(String texto){
        LocalDate fecha = null;
        boolean salida = false;
        while (!salida) {
            try {
                int dia = ingresarNumero("Ingrese el día de la venta: ");
                int mes = ingresarNumero("Ingrese el mes de la venta: ");
                int anio = ingresarNumero("Ingrese el año de la venta: ");
                fecha = LocalDate.of(anio, mes, dia);
                salida = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha válida");
            }
        }
        return fecha;
    }
    /*
    Las tres siguientes funciones son casi que la misma funcion, pero
    para poder manejar los datos de las diferentes clases que hay en el programa
    esto se logra gracias a 2 listas que maneja la opcion de seleccionar cliente, una lista es la que contiene las clasea
    mientras que la otra lista se encarga de mostrar el nombre de la opcion para que no muestres cosas como las direcciones
    de memoria donde se encuentran almacenados los datos para que sea más legible para el usuario
     */
    private Cliente seleccionarCliente(){
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes disponibles");
            return null;
        }

        // Crear una lista de nombres de clientes
        String[] nombresClientes = new String[clientes.size()];//se crea la lista de nombres de los clientes
        for (int i = 0; i < clientes.size(); i++) {
            nombresClientes[i] = clientes.get(i).getNombre();
        }

        // Mostrar la lista de nombres en un JList
        JList<String> lista = new JList<>(nombresClientes);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(lista);
        scrollpane.setPreferredSize(new java.awt.Dimension(200, 150));

        int resultado = JOptionPane.showConfirmDialog(null, scrollpane,//para hacer una pantalla que se pueda mover para mostrar diferentes opciones
                "Seleccione un cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Obtener el cliente seleccionado
        if (resultado == JOptionPane.OK_OPTION) {
            int indiceSeleccionado = lista.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                return clientes.get(indiceSeleccionado);
            }
        }
        return null;
    }
    private Producto seleccionarProducto(){
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles");
            return null;
        }

        // Crear una lista de nombres de productos
        String[] nombresProductos = new String[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
            nombresProductos[i] = productos.get(i).getNombre();
        }

        // Mostrar la lista de nombres en un JList
        JList<String> lista = new JList<>(nombresProductos);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(lista);
        scrollpane.setPreferredSize(new java.awt.Dimension(200, 150));

        int resultado = JOptionPane.showConfirmDialog(null, scrollpane,
                "Seleccione un producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Obtener el producto seleccionado
        if (resultado == JOptionPane.OK_OPTION) {
            int indiceSeleccionado = lista.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                return productos.get(indiceSeleccionado);
            }
        }
        return null;
    }
    private Venta seleccionarVenta(){
        if (ventas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ventas disponibles");
            return null;
        }

        // Crear una lista de descripciones de ventas (fecha + nombre del cliente)
        String[] descripcionesVentas = new String[ventas.size()];
        for (int i = 0; i < ventas.size(); i++) {
            Venta venta = ventas.get(i);
            descripcionesVentas[i] = "Fecha: " + venta.getFecha().toString() + " - Cliente: " + venta.getCliente().getNombre();
        }

        // Mostrar la lista de descripciones en un JList
        JList<String> lista = new JList<>(descripcionesVentas);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(lista);
        scrollpane.setPreferredSize(new java.awt.Dimension(300, 150));

        int resultado = JOptionPane.showConfirmDialog(null, scrollpane,
                "Seleccione una venta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Obtener la venta seleccionada
        if (resultado == JOptionPane.OK_OPTION) {
            int indiceSeleccionado = lista.getSelectedIndex();
            if (indiceSeleccionado != -1) {
                return ventas.get(indiceSeleccionado);
            }
        }
        return null;
    }
}