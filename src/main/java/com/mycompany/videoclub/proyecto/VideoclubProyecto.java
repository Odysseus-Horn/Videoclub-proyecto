/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videoclub.proyecto;

import ventanas.Portada;
import java.nio.file.Paths;
import java.io.*;

/**
 *
 * @author ulyss TheVillegas 
 */


public class VideoclubProyecto {

   public static void main(String[] args) throws IOException 
   {  
      //se inicializa el lector y se guarda el path hacia el proyecto
      String currentFolder = Paths.get("").toAbsolutePath().toString();
      
      //directorios para las peliculas
      String csvPeliculas = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Peliculas.csv";
      String csvClientes = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Clientes.csv";
      
      
      Gestor videoclub = new Gestor();
      
      
      
      //se importan clientes y peliculas del texto
      videoclub.importarPeliculas(csvPeliculas);
      videoclub.importarClientes(csvClientes);
      
       Cliente client = new Cliente("default", 0, "claveDefault");

      Portada inicio = new Portada(videoclub,client);
      inicio.setVisible(true);
      inicio.setLocationRelativeTo(null);
      
      
      
   }
}

