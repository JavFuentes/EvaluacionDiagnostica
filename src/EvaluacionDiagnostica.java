import java.util.ArrayList;
import java.util.Scanner;
/**
*
* @author Javier Fuentes Espinosa
*/
public class EvaluacionDiagnostica {
		
	//Matriz de Datos de Usuario
	private static ArrayList<String[]> usuarios = new ArrayList<>();
		
	//Arreglo que contiene los datos de cada usuario
	private static String[] datos = new String[11];
		
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
	
	//Contadores de tipos de usuarios	
	private static int cantidadClientes = 0;
	private static int cantidadProfesionales = 0;
	private static int cantidadAdministrativos = 0;
			
	private static Scanner sc = new Scanner(System.in);		
		
	public static void main(String[] args) {
		System.out.println("Bienvenido/a!");
		System.out.println("Para acceder al menu principal, "
				+ "debe ingresar un usuario de cada perfil. ");
		
		System.out.println("[Ingrese a nuestro primer cliente]");		
		ingresarCliente();
		
		System.out.println("[Ingrese a nuestro primer profesional]");
		ingresarProfesional(); 
		
		System.out.println("[Ingrese a nuestro primer administrativo]");
		ingresarAdministrativo(); 
		
		System.out.println("[Sistema configurado correctamente]");
		
		mostrarMenu();
		
		sc.close();
	}
	
	public static void mostrarMenu() {
		String opcion = "";
						
		System.out.println("----------------------------------");
		System.out.println("   Menu Principal");
		System.out.println("----------------------------------");
		System.out.println("1. Registrar Usuario.");
		System.out.println("2. Mostrar Usuarios.");
		System.out.println("3. Contar Usuarios por Categoria.");
		System.out.println("4. Modificar Usuario.");
		System.out.println("5. Eliminar Usuario.");
		System.out.println("6. Salir.");
		System.out.println("----------------------------------");
		System.out.println("Escoja una opcion: ");
		
		opcion = sc.nextLine();
		while(!opcion.matches("[1-6]{1}")) {
			System.out.println("[Opcion Incorrecta]");
			System.out.println("Escoja una opcion: ");
			opcion = sc.nextLine();
		}
		
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
	}
	
	public static void registrarUsuario() {			
		//Se pide ingresar el tipo de perfil
		System.out.println("Ingrese el numero correspondiente al perfil de usuario que se ingresara: ");
		System.out.println("1. Cliente");
		System.out.println("2. Profesional");
		System.out.println("3. Administrativo");
		perfil = sc.nextLine();		
		//Se valida que el usuario ingrese solamente un 1, 2 ó 3
	    while (!perfil.matches("[1-3]{1}")) {
	    	System.out.println("[Opcion invalida]\nIngrese el numero correspondiente al perfil de usuario:");
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
	    mostrarMenu();
	}
	
	public static void mostrarUsuarios() {	
		for (String[] usuario : usuarios) {
		    for (String dato : usuario) {
		    	if(dato.equals("")) {
		    		//System.out.print(" [ ] ");
		    	}else {
		    		System.out.print(" [" + dato + "] ");
		    	}		    
		    }
		    System.out.println();
		}
		mostrarMenu();
	}
	
	public static void contarUsuariosPorCategoria() {	
		for (String[] usuario : usuarios) {
			if(usuario[10].equals("1")) {
				cantidadClientes++;
			}else if(usuario[10].equals("2")) {
				cantidadProfesionales++;
			}else if(usuario[10].equals("3")){
				cantidadAdministrativos++;
			}			    
		}		
		
		System.out.println("Total Clientes: " + cantidadClientes);
		System.out.println("Total Profesionales: " + cantidadProfesionales);
		System.out.println("Total Administrativos: " + cantidadAdministrativos);	
		System.out.println();
		
		//Luego de imprimir se limpian los contadores
		cantidadClientes = 0;
		cantidadProfesionales = 0;
		cantidadAdministrativos = 0;
		
		mostrarMenu();
	}
	
	public static void modificarUsuario() {	
		System.out.println("Ingrese el RUT del usuario que desea modificar: ");
		rut = sc.nextLine();
		
		for (String[] usuario : usuarios) {
			if(usuario[2].equals(rut)) {
				System.out.println("Ingrese su nombre: ");
			    nombre = sc.nextLine();
			    //Se valida que el usuario no deje el campo vacío
		  		while(nombre.equals("")){
		  			System.out.println("Campo obligatorio. Ingrese su nombre: ");
		  			nombre = sc.nextLine();
		  		}				    
			    System.out.println("Fecha de nacimiento: " );
			    fechaNacimiento = sc.nextLine();
			    
			    if(usuario[10].equals("1")) {
			    	 System.out.println("Ingrese su direccion: ");
			 	    direccion = sc.nextLine();
			 	    //Se valida que el largo de la cadena no exceda el limite estblecido
			 		while(direccion.equals("")){
			 			System.out.println("Campo obligatorio. ");
			 			direccion = sc.nextLine();
			 		}		
			 	      
			 	    System.out.println("Ingrese su telefono: ");
			 	    telefono = sc.nextLine();
			 	    //Se valida el largo de la cadena
			 		while(!telefono.matches("[0-9]{6,15}")){
			 			System.out.println("[Telefono invalido]\nIngrese su telefono: ");
			 			telefono = sc.nextLine();
			 		}
			 	      
			 	    System.out.println("Ingrese la cantidad de empleados: ");
			 	    cantidadEmpleados = sc.nextLine(); 
			 	    
			 	    usuario[0] = nombre;
					usuario[1] = fechaNacimiento;
					usuario[2] = rut;
					usuario[3] = direccion;
					usuario[4] = telefono;
					usuario[5] = cantidadEmpleados;
					usuario[6] = anhiosExperiencia;
					usuario[7] = departamento;
					usuario[8] = funcion;
					usuario[9] = nombreSuperior;									
					
			 	    System.out.println("[Usuario Modificado]");
			 	    mostrarMenu();
			    }else if (usuario[10].equals("2")) {
			    	 System.out.println("Indique cuantos años de experiencia tiene en el campo: ");
			 	    anhiosExperiencia = sc.nextLine();
			 	    
			 	    System.out.println("Departamento: ");
			 	    departamento = sc.nextLine();
			 	    //Se valida que el campo no esté vacío
			 	  	while(departamento.equals("")){
			 	  		System.out.println("Campo obligatorio. ");
			 	  		departamento = sc.nextLine();
			 	 	}	
			 	  	
			 	    usuario[0] = nombre;
					usuario[1] = fechaNacimiento;
					usuario[2] = rut;
					usuario[3] = direccion;
					usuario[4] = telefono;
					usuario[5] = cantidadEmpleados;
					usuario[6] = anhiosExperiencia;
					usuario[7] = departamento;
					usuario[8] = funcion;
					usuario[9] = nombreSuperior;
					
			 	    System.out.println("[Usuario Modificado]");
			 	  	mostrarMenu();
			    }else if(usuario[10].equals("3")) {
			    	System.out.println("Funcion: ");
				    funcion = sc.nextLine();
				    //Se valida que el campo no esté vacío
				  	while(funcion.equals("")){
				  		System.out.println("Campo obligatorio.");
				  		funcion = sc.nextLine();
				 	}	
				       
				    System.out.println("Indique el nombre de su superior: ");
				    nombreSuperior = sc.nextLine();	
				    
				    usuario[0] = nombre;
					usuario[1] = fechaNacimiento;
					usuario[2] = rut;
					usuario[3] = direccion;
					usuario[4] = telefono;
					usuario[5] = cantidadEmpleados;
					usuario[6] = anhiosExperiencia;
					usuario[7] = departamento;
					usuario[8] = funcion;
					usuario[9] = nombreSuperior;					
					
				    System.out.println("[Usuario Modificado]");
				    mostrarMenu();
			    }
			} 
		}
		System.out.println("[RUT no encontrado]");
		mostrarMenu();
	}
	
	public static void eliminarUsuario() {	
		System.out.println("Ingrese el RUT del usuario que desea eliminar: ");
		rut = sc.nextLine();
		
		for (String[] usuario : usuarios) {
			if(usuario[2].equals(rut)) {
				usuarios.remove(usuario);
				System.out.println("[Usuario Eliminado]");
				mostrarMenu();
			}
		}
		System.out.println("[Rut No tiene coincidencias]");
		mostrarMenu();
	}
	
	public static void salir() {
		String confirmacion = "";
		System.out.println("[Si cierra el programa se perderan todos los datos]");
		System.out.println("Escriba OFF confirma que desea salir: ");
		confirmacion = sc.nextLine();
		
		if(confirmacion.equals("OFF") || confirmacion.equals("off")) {
			System.out.println("[Sistema OFF]");
			System.exit(0);
		} else {
			mostrarMenu();
		}		
	}
	
	//Función que retorna el digito verificador de un rut
	public static String obtenerDV(String rut) {			
		int suma = 0;
		int factor = 2;
				 
		for (int i = rut.length() - 1; i >= 0; i--) {			 
			suma += Integer.valueOf(String.valueOf(rut.charAt(i))) * factor;		       
				if(factor < 7) {
					factor++;		        	
				}
				else {
					factor = 2;
				}
		}
		int dv = 11 - (suma % 11);
		return (dv == 11) ? "0" : (dv == 10) ? "K" : String.valueOf(dv);			
	}	
			
	public static void ingresarCliente() {
		perfil = "1";
		ingresarUsuario();
		
	    System.out.println("Ingrese su direccion: ");
	    direccion = sc.nextLine();
	    //Se valida que el largo de la cadena no exceda el limite estblecido
		while(direccion.equals("")){
			System.out.println("Campo obligatorio. ");
			direccion = sc.nextLine();
		}		
	      
	    System.out.println("Ingrese su telefono: ");
	    telefono = sc.nextLine();
	    //Se valida el largo de la cadena
		while(!telefono.matches("[0-9]{6,15}")){
			System.out.println("[Telefono invalido]\nIngrese su telefono: ");
			telefono = sc.nextLine();
		}
	      
	    System.out.println("Ingrese la cantidad de empleados: ");
	    cantidadEmpleados = sc.nextLine(); 
	    
	    guardarDatos();
	}
	
	public static void ingresarProfesional() {
		perfil = "2";
		ingresarUsuario();
	     
	    System.out.println("Indique cuantos años de experiencia tiene en el campo: ");
	    anhiosExperiencia = sc.nextLine();
	    
	    System.out.println("Departamento: ");
	    departamento = sc.nextLine();
	    //Se valida que el campo no esté vacío
	  	while(departamento.equals("")){
	  		System.out.println("Campo obligatorio. ");
	  		departamento = sc.nextLine();
	 	}	
	  	guardarDatos();
	}
	
	public static void ingresarAdministrativo() {
		perfil = "3";
		ingresarUsuario();
		
	    System.out.println("Funcion: ");
	    funcion = sc.nextLine();
	    //Se valida que el campo no esté vacío
	  	while(funcion.equals("")){
	  		System.out.println("Campo obligatorio.");
	  		funcion = sc.nextLine();
	 	}	
	       
	    System.out.println("Indique el nombre de su superior: ");
	    nombreSuperior =sc.nextLine();	
	    
	    guardarDatos();
	}
	
	public static void ingresarUsuario() {
		System.out.println("Ingrese su nombre: ");
	    nombre = sc.nextLine();
	    //Se valida que el usuario no deje el campo vacío
  		while(nombre.equals("")){
  			System.out.println("Campo obligatorio. Ingrese su nombre: ");
  			nombre = sc.nextLine();
  		}	
	    
	    System.out.println("Fecha de nacimiento: " );
	    fechaNacimiento = sc.nextLine();
	    
	    System.out.println("Ingrese su RUT, sin puntos, ni guion, ni digito verificador: ");
	    rut = sc.nextLine();
	    //Se valida que el rut sea verídico	  
	  	while(!rut.matches("[0-9]{6,8}")){			
	  			System.out.println("Rut Invalido. Ingrese su RUT, sin puntos, ni guion, ni digito verificador: ");		
	  			rut = sc.nextLine();  			
	  	}
	  	rut = rut + "-" + obtenerDV(rut);
	}
	
	public static void guardarDatos() {		
		usuarios.add(new String[]{nombre, fechaNacimiento, rut, direccion, telefono, cantidadEmpleados, 
				anhiosExperiencia, departamento, funcion, nombreSuperior, perfil});
		
		//Se limpian las variables		
		perfil = "";
		nombre = "";
		fechaNacimiento = "";
		rut = "";		
		direccion = "";
		telefono = "";
		cantidadEmpleados = "";		
		anhiosExperiencia = "";
		departamento = "";		
		funcion = "";
		nombreSuperior = "";		
	}	
}
