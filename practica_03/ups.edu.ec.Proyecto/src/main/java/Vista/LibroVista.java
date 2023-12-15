package Vista;

import java.util.Scanner;

import Modelo.Libro;


public class LibroVista {
	Scanner entrada = new Scanner(System.in);
	
	public Libro ingresarDatosLibro(){
        System.out.println("------Ingreso de Nuevo Producto------");
        System.out.println("Ingresa el nombre del libro");
        String nombre = entrada.next();
        System.out.println("Ingresa el nombre del Autor");
        String autor = entrada.next();
        System.out.println("Ingresa el anio de lanzamiento");
        int anio = entrada.nextInt();
        
        return new Libro(nombre, autor, anio);
    }
    
    public Libro actualizarDatosLibro(){
    	System.out.println("Ingresa el nombre del libro");
        String nombre = entrada.next();
        System.out.println("Ingresa el nombre del Autor");
        String autor = entrada.next();
        System.out.println("Ingresa el anio de lanzamiento");
        int anio = entrada.nextInt();
        
        return new Libro(nombre, autor, anio);                
    }
    
    public String eliminarDatosLibro(){
        System.out.println("------Eliminar Libro------");
        System.out.println("Ingresa el nombre del libro a eliminar");
        String nombre = entrada.next();
        return nombre;
    }
    
    public String buscarDatosLibro(){
        System.out.println("------Buscar Producto------");
        System.out.println("Ingresa el id del producto a buscar");
        String nombre = entrada.next();
        return nombre;
    }        
    
    public void mostrarInformacionProducto(String nombre, String autor, int anio){
        System.out.println("Datos del Libro: \n" + nombre + " - " + autor + " - " + anio);
    }
    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    }
	
}
