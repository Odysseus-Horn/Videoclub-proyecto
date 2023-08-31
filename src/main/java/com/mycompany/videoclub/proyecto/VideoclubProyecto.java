/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videoclub.proyecto;
import java.nio.file.Paths;

/**
 *
 * @author ulyss
 */
public class VideoclubProyecto {

   public static void main(String[] args)
   {  

      String currentFolder = Paths.get("").toAbsolutePath().toString();

      String csvPeliculas = currentFolder + "/src/main/java/com/mycompany/videoclub/proyecto/datos/Peliculas.csv";

        Gestor videoclub = new Gestor();
        videoclub.importarPeliculas(csvPeliculas);

        videoclub.mostrarPeliculas();

   }
}
