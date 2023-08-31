package com.mycompany.videoclub.proyecto;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gestor{
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Pelicula> listaPeliculas;
    private Map<String, Cliente> mapaClientes = new HashMap<>();
    private Map<String, Pelicula> mapaPeliculas = new HashMap<>();

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

    //Métodos 

    public void agregarPelicula(Pelicula pelicula)
    {
        listaPeliculas.add(pelicula);
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

/* 
    public void importarClientes(String archivo)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(archivo))
        {
            
            while(line = reader.readLine() != null)
            {

            }
        }
    }
*/
    
    public boolean agregarCliente(Cliente cliente)
    {
         if(mapaClientes.containsKey(cliente.getNombreUsuario()))
         {
             return false;
         }
         else
         {
             mapaClientes.put(cliente.getNombreUsuario(), cliente);
             listaClientes.add(cliente);
 
             return true;
         }
    }
 
    public boolean eliminarCliente(String key) {
         Cliente clienteAEliminar = null;
     
         
         for (Cliente cliente : listaClientes) {
             if (cliente.getNombreUsuario().equals(key)) {
                 clienteAEliminar = cliente;
                 break;
             }
         }
     
         if (clienteAEliminar != null) {
             listaClientes.remove(clienteAEliminar);
             mapaClientes.remove(key);
             return true;
         } else {
             return false; 
         }
    }

    public void mostrarClientes() {
        System.out.println("Lista de clientes:");
        
        if (listaClientes.isEmpty()) {
            System.out.println("La lista de clientes está vacía.");
        } else 
        {
            for (Cliente cliente : listaClientes) {
                System.out.println("Nombre de usuario: " + cliente.getNombreUsuario());
                System.out.println("Saldo: " + cliente.getSaldo());
                System.out.println("Películas en posesión: " + cliente.getSizePeliculasEnPosesion());
                System.out.println("Total películas arrendadas" + cliente.getSizeHistorialPelicula());
                System.out.println("----------------------");
            }
        }
    }

}