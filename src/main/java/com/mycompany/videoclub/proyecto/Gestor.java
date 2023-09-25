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
        listaClientes = new ArrayList<>();
        listaPeliculas = new ArrayList<>();
    }

    //Métodos 

    public void agregarPelicula(Pelicula pelicula)
    {
        listaPeliculas.add(pelicula);
    }


    public void importarPeliculas(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    // Asignación de los datos
                    String titulo = parts[0];
                    int year = Integer.parseInt(parts[1].trim());
                    int existencias = Integer.parseInt(parts[2].trim());
                    int precioArriendo = Integer.parseInt(parts[3].trim());
                    float rating = Float.parseFloat(parts[4].trim());
                    String sinopsis = parts[5];
                    String genero = parts[6];
    
                    Pelicula peli = new Pelicula(titulo, year, existencias, precioArriendo, rating, sinopsis, genero);
                    listaPeliculas.add(peli); // Agregar a la lista
    
                    mapaPeliculas.put(titulo, peli); // Agregar al mapa
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


    public void importarClientes(String archivo)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    // Asignación de los datos del cliente
                    String nombreUsuario = parts[0];
                    double saldo = Double.parseDouble(parts[1].trim());

                    // Crear un objeto Cliente y agregarlo a la lista y al mapa
                    Cliente cliente = new Cliente(nombreUsuario, saldo);
                    agregarCliente(cliente);
                    listaClientes.add(cliente);
                    mapaClientes.put(nombreUsuario, cliente);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }    
    }

    
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

    public boolean agregarCliente(String nombreUsuario, double saldo) {
        Cliente cliente = new Cliente(nombreUsuario, saldo);
        return agregarCliente(cliente);
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
                System.out.println("----------------------");
            }
        }
    }

    public boolean mostrarPeliculas() {
        System.out.println("Catálogo de películas del videoclub:");
        
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas por el momento.");
            return false;
        } else 
        {
            for (Pelicula peli : listaPeliculas) {
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
            return true;
        }
    }
   
    public Pelicula buscarPeliculaPorNombre(String nombre) {
        

        String nombreFormateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        
        Pelicula peli = mapaPeliculas.get(nombreFormateado);
        if(peli != null){
            if (peli.getTitulo().equalsIgnoreCase(nombreFormateado)) {
                return peli;
            }
        }
        return null;
    }
    



}