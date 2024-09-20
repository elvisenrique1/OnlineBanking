/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioonlinebanking;

import java.util.Scanner;

/**
 *
 * @author elvis
 */
public class EjercicioOnlineBanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        /*
        Crear una aplicación que valide el ingreso a una plataforma Online Banking a través de una clave Token.
        
        Se debe tener en cuenta lo siguiente:
        
        * La Clave Token debe ser un número aleatorio de 6 dígitos.
        * El cliente debe ingresar los campos Usuario, Contraseña y Clave Token (todos obligatorios).
        * El campo Usuario no distingue minúsculas o mayúsculas.
        * El campo Contraseña es sensible a las minúsculas y mayúsculas.
        La clave Token aleatoria se le informa al usuario al pedirle que ingrese las credenciales.        
        * El cliente solo posee 3 intentos de logueo. 
	* Si alcanza los 3 intentos fallidos de forma consecutiva, la aplicación deberá informar al
        usuario que debe dirigirse a la sucursal del banco más cercana para poder desbloquear sus credenciales.
        * Por cada intento fallido, la aplicación debe preguntar al cliente si desea continuar
        colocando las credenciales de manera correcta.
        * Si el cliente coloca las credenciales de forma correcta, deberá informar que ha ingresado
        correctamente al Online Banking.
        */
        
        System.out.println("*** Aplicación ONLINE BANKING ***");
        
        Scanner teclado = new Scanner(System.in);
        
        boolean permitirAcceso = false;
        int intentosPermitidos = 3;
        int intentos = 0;
        String nombreValido = "Elvis";
        String contrasenaValida = "Passw0rd";
        String nombre, contrasena,claveToken;
        
        // ******   ***   Ingresar Clave Token   ***   ******
        
        System.out.print("\nIngrese su Clave Token (Max. 6 dígitos): ");
        claveToken = teclado.nextLine(); 
        // *** Validar Clave Token ***
        while(claveToken.length() != 6) {        
        // *** Clave Token Incorrecta ***
            System.out.println("Error...! \nLa Clave Token debe ser un número aleatorio de 6 dígitos.");                      System.out.print("\nIngrese su Clave Token (Max. 6 dígitos): ");
            claveToken = teclado.nextLine();
        }
        // *** Mesanje Clave Token Correcta ***
        System.out.println("\n*.- La Clave Token es válida -.*\n\n *** B I E N V E N I D O ***");
        System.out.println("\nIngrese las credenciales para acceder al Online Banking");
        
        // ******   ***   Proceso de Login   ***   ******

        while(!permitirAcceso && intentos < intentosPermitidos){
            System.out.print("\n*.- Ingrese su Usuario: ");
            nombre = teclado.nextLine();
              
            System.out.print("*.- Ingrese su Contraseña: ");
            contrasena = teclado.nextLine(); 
                    
            System.out.println("*.- Su clave Token es: " + claveToken);
            
        // ******   ***   Validar Credenciales    
        
        if (nombre.equalsIgnoreCase(nombreValido) && contrasena.equals(contrasenaValida) && claveToken.equals(claveToken)) {
            // *** Credenciales Correctas ***
            permitirAcceso = true;
            System.out.println("\n¡Ha ingresado correctamente al Online Banking!");
         } else {
            // *** Credenciales Incorrectas ***
                intentos++;
                System.out.println("\nCredenciales incorrectas. Intentos restantes: " + (3 - intentos));
                if (intentos < 3) {
                    System.out.print("\n¿Desea continuar colocando las credenciales de manera correcta.? \nPresione (S/s) para continuar, cualquier otra tecla para salir!: ");
                    String continuar = teclado.nextLine().toLowerCase();
                    if (!continuar.equalsIgnoreCase("s")) {
                        System.out.println("\n*** Saliendo de la Plataforma ONLINE BANKING. *** \nHasta pronto..!\n");
                        break;
                    }
                } else {
                    System.out.println("Ha alcanzado el límite de intentos fallidos. Diríjase a la sucursal del banco más cercana para desbloquear sus credenciales.");
                }        
            }
            
        }
    }
}
