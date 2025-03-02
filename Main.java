package Java.Principiantes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        String opciones[] = {"Agregar Venta", "Editar cliente","Mostrar cliente","Eliminar cliente","Editar producto",
        "Mostrar producto", "Eliminar producto", "Editar venta", "Mostrar Venta", "Eliminar ventas", "Salir"};
        boolean salir = false;
        while(!salir) {//se crea el ciclo para que sin importar si se termina una accion siga mostrando el menu hasta que de la opcion salir
            int seleccion = JOptionPane.showOptionDialog(//crea la ventana que nos va a mostrar las opciones que tendremos a elegir
                    null,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            switch(seleccion){//la funcion de JOptionPane.showOptionDialog retorna
                // un número, lo que hace este switch es que
                // según el número que selecciono se va a elegir una opcion
                case 0:
                    tienda.agregarVentas();
                    break;
                case 1:
                    tienda.editarCliente();
                    break;
                case 2:
                    tienda.mostrarCliente();
                    break;
                case 3:
                    tienda.eliminarCliente();
                    break;
                case 4:
                    tienda.editarProducto();
                    break;
                case 5:
                    tienda.mostrarProducto();
                    break;
                case 6:
                    tienda.eliminarProducto();
                    break;
                case 7:
                    tienda.editarVentas();
                    break;
                case 8:
                    tienda.mostrarVentas();
                    break;
                case 9:
                    tienda.eliminarVentas();
                    break;
                case 10:
                    salir = true;
                    break;
            }
        }
    }
}