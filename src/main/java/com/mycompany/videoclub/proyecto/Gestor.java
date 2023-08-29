package com.mycompany.videoclub.proyecto;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gestor{
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Pelicula> listaPeliculas;

    public Gestor()
    {
        listaClientes = new ArrayList<  >();
        listaPeliculas = new ArrayList<>();
    }

    //getters
    public Cliente getListaClientes(short index){   
        return listaClientes.get(index);
    }

    public Pelicula getListaPeliculas(short index)
    {
        return listaPeliculas.get(index);
    }

    //setters

    public void setListaPeliculas(Pelicula pelicula)
    {
        listaPeliculas.add(pelicula);
    }

    public void setListaClientes(Cliente cliente)
    {
        listaClientes.add(cliente);
    }

    public void importarPeliculas(String archivo){
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))){
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if(parts.length >= 7){
                    
                    //asignación de los datos
                    String titulo = parts[0];
                    int year = Integer.parseInt(parts[1].trim());
                    int existencias = Integer.parseInt(parts[2].trim());
                    int precioArriendo = Integer.parseInt(parts[3].trim());
                    float rating = Float.parseFloat(parts[4].trim());
                    String sinopsis = parts[5];

                    System.out.println("Título: " + titulo);
                    System.out.println("Año: " + year);
                    System.out.println("Existencias: " + existencias);
                    System.out.println("Precio de arriendo: " + precioArriendo);
                    System.out.println("Rating: " + rating);
                    System.out.println("Sinopsis: " + sinopsis);

                    Pelicula peli = new Pelicula(titulo, year, existencias, precioArriendo, rating, sinopsis);
                    listaPeliculas.add(peli);
                }
                
                
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}