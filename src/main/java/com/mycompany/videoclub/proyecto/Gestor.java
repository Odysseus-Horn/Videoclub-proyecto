package com.mycompany.videoclub.proyecto;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    // Agrega Pelicula al catalogo de peliculas
    public void agregarPelicula(Pelicula pelicula)
    {
        listaPeliculas.add(pelicula);
        //mapaPeliculas.put(pelicula.getTitulo(),pelicula);
        
    }

    // Importar de Peliculas y Clientes
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
                    String claveUsuario = parts[2];
                    ArrayList<Pelicula> peliculasPosecion = new ArrayList<>();
                    if(parts.length >= 3){
                        
                        for (int i = 3; i < parts.length; i++) {
                        String nombrePelicula = parts[i];
                        // Buscar la película por nombre y agregarla a la lista de películas en posesión
                        Pelicula pelicula = mapaPeliculas.get(nombrePelicula);
                        if (pelicula != null) {
                            peliculasPosecion.add(pelicula);
                        }
                    }

                    }
                    // Crear un objeto Cliente y agregarlo a la lista y al mapa
                    Cliente cliente = new Cliente(nombreUsuario, saldo,claveUsuario);
                    cliente.agregarPeliculasImportadas(peliculasPosecion);
                    listaClientes.add(cliente);
                    mapaClientes.put(nombreUsuario, cliente);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }    
    }

    // Exportar CLientes

    public void exportarClientes(String archivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))){
            for(Cliente client : listaClientes){
                writer.write(client.getNombreUsuario() + "," + client.getSaldo() + "," + client.getClave());
                if(!client.peliculasEnPosesion.isEmpty()){
                    for(Pelicula peli : client.peliculasEnPosesion){
                        writer.write("," + peli.getTitulo());
                    }
                    
                }
                writer.newLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

 


    //Funciones Propias del Gestor.
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

    public boolean agregarCliente(String nombreUsuario, double saldo,String clave) {
        Cliente cliente = new Cliente(nombreUsuario, saldo,clave);
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

      //Se Realiza una busqueda de peliculas que tenga rating mayor o igual al ingresado por el usuario y se devuelve una lista con las peliculas que cumplen con el criterio
      public ArrayList<Pelicula> buscarPeliculasPorRating(float rating){

        ArrayList<Pelicula> listaFiltrada = new ArrayList<>();

        for (Pelicula peli : listaPeliculas) {
            if(peli.getRating()>= rating){
                listaFiltrada.add(peli);
            }
        }
        if(listaFiltrada.isEmpty()){
            return null;
        }
        else{
            return listaFiltrada;
        }
    }






    



}