/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videoclub.proyecto;

import java.nio.file.Paths;
import java.io.*;

/**
 *
 * @author ulyss TheVillegas 
 */


public class VideoclubProyecto {

   public static void main(String[] args) throws IOException {  

      //se inicializa el lector y se guarda el path hacia el proyecto
      String currentFolder = Paths.get("").toAbsolutePath().toString();
      BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

      int opcion; // inicializamos la variable opcion para las distintas funciones disponibles para el usuario

      String csvPeliculas = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Peliculas.csv";
      String csvClientes = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Peliculas.csv";


      Gestor videoclub = new Gestor();
      


      videoclub.importarPeliculas(csvPeliculas);
      
      
      String nombre = "Mauricio";

      Double saldo = 500.0;
      Cliente client = new Cliente(nombre, saldo);
      videoclub.agregarCliente(client);
      // Menu del usuario
      while(true) {

         //crearCliente(lector, videoclub);
        
         System.out.println("Selecciona una opción:");
         System.out.println("1. Mostrar Catálogo");
         System.out.println("2. Arrendar Película");
         System.out.println("3. Devolver Película");
         System.out.println("4. Salir");
         
         opcion = Integer.parseInt(lector.readLine());

         switch(opcion) {
            case 1:
               videoclub.mostrarPeliculas();
               break;
            case 2:
               if(videoclub.mostrarPeliculas()){
                  System.out.println("Qué pelicula desea arrendar?");
                  String nombreABuscar = lector.readLine();
                  client.arrendarPelicula(videoclub, formatearNombre(nombreABuscar));
               }
               break;
            case 3:
               if(client.mostrarPeliculasEnPosesion()){
                  System.out.println("qué pelicula del listado desea eliminar?");
                  String nombreAEliminar = lector.readLine();
                  client.devolverPelicula(videoclub, formatearNombre(nombreAEliminar));
               }
               break;
            case 4:
               System.out.println("Saliendo del programa.");
               lector.close();
               System.exit(0);
               break;
            default:
               System.out.println("Opción inválida. Inténtalo de nuevo.");
         }
      }
   }


 
   

   private static String formatearNombre(String nombre) {
      // Convierte la primera letra a mayúscula y el resto a minúscula
      return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
   }




   
   /* FUNCION HECHA PARA OPTIMIZACION
   private static void crearCliente(BufferedReader lector, Gestor videoClub) throws IOException {

      
      String nombre = lector.readLine();
      Double saldo = Double.parseDouble(lector.readLine());

      Cliente client = new Cliente(nombre, saldo);

      videoClub.agregarCliente(client);
      
   IMPORTAR CLIENTE
   DEVOLVER PELICULA - SACARSELA DE LA LISTA CLIENTE - AGREGAR UNA EXISTENCIA AL PELICULAS EXISTENTE
   }
   */
}
