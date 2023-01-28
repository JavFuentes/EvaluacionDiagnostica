import java.util.ArrayList;
import java.util.Scanner;

public class EvaluacionDiagnostica {
		
	//Matriz de Datos de Usuario
	private static ArrayList<String[]> usuarios = new ArrayList<>();
		
	//Arreglo que contiene los datos de cada usuario
	private static String[] datos = new String[10];
		
	//Variables de usuario
	private static String perfil = "";
	private static String nombre = "";
	private static String fechaNacimiento = "";
	private static String rut = "";
				
	//Cliente
	private static String direccion = "";
	private static String telefono = "";
	private static String cantidadEmpleados = "";
				
	//Profesional
	private static String anhiosExperiencia = "";
	private static String departamento = "";
				
	//Administrativo
	private static String funcion = "";
	private static String nombreSuperior = "";
			
	private static Scanner sc = new Scanner(System.in);		
		
	public static void main(String[] args) {
		
		String opcion = "";
				
		//Se imprime el menu		
		System.out.println("-------------------------------");
		System.out.println("   Menu Principal");
		System.out.println("-------------------------------");
		System.out.println("1. Registrar Usuario.");
		System.out.println("2. Mostrar Usuarios.");
		System.out.println("3. Contar Usuarios por Categoria.");
		System.out.println("4. Modificar Usuario.");
		System.out.println("5. Eliminar Usuario.");
		System.out.println("6. Salir.");
		System.out.println("-------------------------------");
		
		opcion = sc.nextLine();
		
			switch(opcion) {
				case "1":
					registrarUsuario();
					break;
				case "2":
					mostrarUsuarios();
					break;
				case "3":
					contarUsuariosPorCategoria();
					break;
				case "4":
					modificarUsuario();
					break;
				case "5":
					eliminarUsuario();
					break;
				case "6":
					salir();
					break;
			}
		sc.close();
	}
	
	public static void registrarUsuario() {	
		
		//Se pide ingresar el tipo de perfil
		System.out.println("Ingrese el numero correspondiente al perfil del usuario que se ingresara: ");
		System.out.println("1. Cliente");
		System.out.println("2. Profesional");
		System.out.println("3. Administrativo");
		perfil = sc.nextLine();
		
		//Se valida que el usuario ingrese solamente un 1, 2 ó 3
	    while (!perfil.matches("[1-3]{1}")) {
	    	System.out.println("Opcion invalida. Ingrese el numero correspondiente al perfil de usuario.");
	    	System.out.println("1. Cliente");
	 		System.out.println("2. Profesional");
	 		System.out.println("3. Administrativo");
	    	perfil = sc.nextLine();   	    	   
	    }	 
	    
	    switch(perfil) {
    		case "1":
    			ingresarCliente();	    		
    			break;
    		
    		case "2":
    			ingresarProfesional();    		
    			break;
    		
    		case "3":
    			ingresarAdministrativo();     		
    			break;	    
	    }			
	}
	
	public static void mostrarUsuarios() {	
		
	}
	
	public static void contarUsuariosPorCategoria() {	
		
	}
	
	public static void modificarUsuario() {	
		
	}
	
	public static void eliminarUsuario() {	
		
	}
	
	public static void salir() {	
		System.exit(0);
	}
	
	private static void ingresarCliente() {
		System.out.println("Nombre: ");
	    nombre = sc.nextLine();
	    
	    System.out.println("Fecha de nacimiento: " );
	    fechaNacimiento = sc.nextLine();
	    
	    System.out.println("Ingrese su Rut: ");
	    rut = sc.nextLine();
	      
	    System.out.println("Ingrese su direccion: ");
	    direccion = sc.nextLine();
	      
	    System.out.println("Ingrese su telefono: ");
	    telefono = sc.nextLine();
	      
	    System.out.println("Ingrese la cantidad de empleados: ");
	    cantidadEmpleados = sc.nextLine(); 
	}
	
	private static void ingresarProfesional() {
		System.out.println("Nombre: ");
	    nombre = sc.nextLine();
	    
	    System.out.println("Fecha de nacimiento: " );
	    fechaNacimiento = sc.nextLine();
	    
	    System.out.println("Ingrese su Rut: ");
	    rut = sc.nextLine();
	      
	    System.out.println("Indique cuantos años de experiencia tiene en el campo: ");
	    anhiosExperiencia = sc.nextLine();
	    
	    System.out.println("Departamento: ");
	    departamento = sc.nextLine();
	}
	
	private static void ingresarAdministrativo() {
		System.out.println("Nombre: ");
	    nombre = sc.nextLine();
	    
	    System.out.println("Fecha de nacimiento: " );
	    fechaNacimiento = sc.nextLine();
	    
	    System.out.println("Ingrese su Rut: ");
	    rut = sc.nextLine();
	    	    	      
	    System.out.println("Funcion: ");
	    funcion = sc.nextLine();
	       
	    System.out.println("Indique el nombre de su superior: ");
	    nombreSuperior =sc.nextLine();		
	}
}
