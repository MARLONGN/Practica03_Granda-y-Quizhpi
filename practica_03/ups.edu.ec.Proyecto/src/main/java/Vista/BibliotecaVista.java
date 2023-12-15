package Vista;


import java.util.Scanner;
import Modelo.Biblioteca;


public class BibliotecaVista {

	private Scanner entrada;

    public BibliotecaVista() {
        entrada = new Scanner(System.in);
    }
    
    public Biblioteca ingresarDatosDeBiblioteca(){
        System.out.println("------Ingreso de la nueva Biblioteca------");
        System.out.println("Ingresa el nombre de la Biblioteca");
        String nombre = entrada.next();
        System.out.println("Ingresa la direccion");
        String direccion = entrada.next();
        return new Biblioteca(nombre, direccion);
     }
    
    public String actualizarDatosDeBiblioteca() {
        System.out.println("------Actualizar Biblioteca------");
        System.out.println("Ingresa el nombre de la Biblioteca");
        String nombre = entrada.next();
        System.out.println("Ingresa la direccion");
        String direccion = entrada.next();
        return nombre;
    }

    
    public String eliminarDatosProducto(){
        System.out.println("------Eliminar Biblioteca------");
        System.out.println("Ingresa el nombre de la Biblioteca a eliminar");
        String nombre = entrada.next();
        return nombre;
    }
    
    public String buscarDatosDeBiblioteca(){
        System.out.println("------Buscar Biblioteca------");
        System.out.println("Ingresa el Nombre de la biblioteca a buscar");
        String nombre = entrada.next();
        return nombre;
    }        
    
    public void mostrarInformacionBiblioteca(String nombre,String direccion ){
        System.out.println("Datos de la BibliotecaS: \n" + nombre+ " - " + direccion );
    }
    
    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    }
    
}
	

