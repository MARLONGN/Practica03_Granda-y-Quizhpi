package Vista;

import java.util.Scanner;
import Modelo.Usuario;



public class UsuarioVista {
	
	Scanner entrada = new Scanner(System.in);
	
	public Usuario ingresarDatosUsuario(){
        System.out.println("------Ingreso Del Nuevo Usuario------");
        System.out.println("Ingresa el nombre de Usuario");
        String nombre = entrada.next();
        System.out.println("Ingresa la identificacion del Usuario");
        int identificaccion = entrada.nextInt();
        System.out.println("Ingresa el Corrrero electronico del usuario");
        String correo = entrada.next();
        
        return new Usuario(nombre, identificaccion, correo);
	}
	
	
	public Usuario actualizarDatosUsuario(){
        System.out.println("------Actualizar Cliente------");
        System.out.println("Ingresa el nombre de Usuario");
        String nombre = entrada.next();
        System.out.println("Ingresa la identificacion del Usuario");
        int identificaccion = entrada.nextInt();
        System.out.println("Ingresa el Corrrero electronico del usuario");
        String correo = entrada.next();
        
        return new Usuario(nombre, identificaccion, correo);
    }
    
    public int eliminarDatosUsuario(){
        System.out.println("------Eliminar Cliente------");
        System.out.println("Ingresa la identificacion del Usuario a eliminar");
        int identificacion = entrada.nextInt();
        return identificacion;
    }
    
    public int buscarDatosUsuario(){
        System.out.println("------Buscar Cliente------");
        System.out.println("Ingresa la identificacion del cliente a buscar");
        int identificacion = entrada.nextInt();
        return identificacion;
    }        
    
    public void mostrarInformacionUsuario(int identificacion, String nombre, String correo){
        System.out.println("Datos del Usuario: \n" + identificacion + " - " + nombre + " - " + correo);
    }

    public void mostrarAlertas(String mensaje){
        System.out.println(mensaje);
    }

}
