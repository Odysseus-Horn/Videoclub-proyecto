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
               videoclub.mostrarPeliculas();
               System.out.println("Qué pelicula desea arrendar?");
               String nombreABuscar = lector.readLine();
               
               arrendar(videoclub, nombreABuscar,client);
               break;
            case 3:
               client.mostrarPeliculasEnPosesion();
               if(!client.getPeliculasenPosesion().isEmpty())
               {
                  System.out.println("qué pelicula del listado desea eliminar?");
                  String nombreAEliminar = lector.readLine();
                  devolver(videoclub, nombreAEliminar,client);
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


   private static void arrendar(Gestor videoCLub,String nombre,Cliente client) throws IOException {

      Pelicula pelicula = videoCLub.buscarPeliculaPorNombre(nombre);
      
      
      if(pelicula == null){
          System.out.println("Pelicula no encontrada o no está en posesión del cliente.");
          return;
          
      }
      
      boolean arrendado = client.arrendarPelicula(pelicula);
      if(arrendado)
      {
         pelicula.reducirExistencias(1);
         System.out.println("Película agregada con éxito");
      }
      else
      {
         System.out.println("la película no tiene existencias o usted no tiene saldo suficiente");
      }
   }
   

   private static void devolver(Gestor videoClub, String nombrePelicula, Cliente client) {

      Pelicula pelicula = videoClub.buscarPeliculaPorNombre(nombrePelicula);
  
      if (pelicula != null && client.getPeliculasenPosesion().contains(pelicula)) {
          boolean devuelto = client.devolverPelicula(pelicula, videoClub);
  
          if (devuelto) {
               pelicula.aumentarExistencias(1);
              System.out.println("Pelicula devuelta con éxito.");
          } else {
              System.out.println("Error al devolver la película.");
          }
      } else {
          System.out.println("Pelicula no encontrada o no está en posesión del cliente.");
      }
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
