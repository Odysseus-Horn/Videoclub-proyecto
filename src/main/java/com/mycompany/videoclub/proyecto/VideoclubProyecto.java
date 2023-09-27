/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videoclub.proyecto;

import java.nio.file.Paths;
import java.util.ArrayList;
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

      //directorios para las peliculas
      String csvPeliculas = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Peliculas.csv";
      String csvClientes = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Clientes.csv";


      Gestor videoclub = new Gestor();

      //se importan clientes y peliculas del texto
      videoclub.importarPeliculas(csvPeliculas);
      videoclub.importarClientes(csvClientes);
      
      //opcion de registro o inicio de sesión
      int option;
      System.out.println("1) Iniciar Sesión");
      System.out.println("2) Registrarse");
      option = Integer.parseInt(lector.readLine());

      String cliente;
      String contra;
      Cliente client = new Cliente("default", 0, "claveDefault");
      int money;
      int level;
      boolean ends = true;

      while(ends)
      {
         switch(option)
         {
            case 1:
               System.out.println("ingrese nombre usuario");
               cliente = lector.readLine();
               System.out.println("ingrese su contraseña:");
               contra = lector.readLine();

               client = videoclub.iniciarSesion(cliente, contra);
               while(client == null)
               {
                  System.out.println("nombre o contraseña incorrecta, intente de nuevo");
                  System.out.println("ingrese nombre usuario");
                  cliente = lector.readLine();
                  System.out.println("ingrese su contraseña:");
                  contra = lector.readLine();

                  client = videoclub.iniciarSesion(cliente, contra);
               }
               ends = false;
               break;
            case 2:
               do{
                  System.out.println("ingrese nombre usuario");
                  cliente = lector.readLine();

                  if(videoclub.existeCliente(cliente)){
                  System.out.println("el cliente ya existe inténtelo de nuevo");
                  }
               } while(videoclub.existeCliente(cliente));

               System.out.println("ingrese su contraseña:");
               contra = lector.readLine();
               
               System.out.println("Ingrese su saldo inicial");
               money = Integer.parseInt(lector.readLine());
               
               System.out.println(("tiene membresia tier 1,2,3? si no tiene ninguna ingrese 0"));
               level = Integer.parseInt(lector.readLine());

               if(level == 0)
               {
                  client = new Cliente(cliente, money, contra);
               }
               else
               {
                  client = new ClientePrime(cliente, contra, money, level);
               }

               videoclub.agregarCliente(client);
               ends = false;
               break;
            default:
               System.out.println("opción no válida");
               break;
         }
      }

      System.out.println("Bienvenido " + client.getNombreUsuario());
      if(client instanceof ClientePrime)
      {
         ClientePrime prime = (ClientePrime) client;
         System.out.println("membresia tier " + prime.getNivelMembresia());
      }

      videoclub.agregarCliente(client);
      // Menu del usuario
      while(true) {

         //crearCliente(lector, videoclub);
        
         System.out.println("Selecciona una opción:");
         System.out.println("1. Mostrar Catálogo");
         System.out.println("2. Arrendar Película");
         System.out.println("3. Devolver Película");
         System.out.println("4. Salir");
         System.out.println("5. Buscar Pelicula por Rating");
         System.out.println("6. Mostrar Peliculas Arrendadas");
         
         
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
               else{
                  System.out.println("No tienes peliculas en posesion");
               }
               break;
            case 4:
               System.out.println("Saliendo del programa.");
               videoclub.exportarClientes(csvClientes);
               videoclub.exportarPeliculas(csvPeliculas);
               lector.close();
               System.exit(0);
               break;

            case 5: 
               System.out.println("Ingrese el rating de la pelicula que desea buscar");
               float rating = Float.parseFloat(lector.readLine());
               
               ArrayList<Pelicula> peliculas = videoclub.buscarPeliculasPorRating(rating);

               if(peliculas.isEmpty()){
                  System.out.println("No se encontraron peliculas con ese rating");
               } 
               else{
                  for (Pelicula peli : peliculas) {
                     System.out.println("----------------------");
                     System.out.println("Título: " + peli.getTitulo());
                     System.out.println("Año: " + peli.getYear());
                     System.out.println("Existencias: " + peli.getExistencias());
                     System.out.println("Valor Arriendo:" + peli.getPrecioArriendo());
                     System.out.println("Rating: " + peli.getRating());
                     System.out.println("Sinopsis: " + peli.getSinopsis());
                     System.out.println("genero: " + peli.getGenero());
                     System.out.println("----------------------");
                  }
               }
               break;

            case 6:
               client.mostrarPeliculasEnPosesion();
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
