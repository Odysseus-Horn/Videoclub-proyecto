/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.videoclub.proyecto;

/**
 *
 * @author ulyss
 */
public class VideoclubProyecto {

   public static void main(String[] args)
   {
        Gestor videoclub = new Gestor();
        videoclub.importarPeliculas("datos/Peliculas.csv");

        

   }
}
