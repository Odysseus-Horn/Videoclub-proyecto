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
    

    // Importar de Peliculas
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
    
    //exportar peliculas del csv
    public void exportarPeliculas(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Pelicula pelicula : listaPeliculas) {
                writer.write(pelicula.getTitulo() + ",");
                writer.write(pelicula.getYear() + ",");
                writer.write(pelicula.getExistencias() + ",");
                writer.write(pelicula.getPrecioArriendo() + ",");
                writer.write(pelicula.getRating() + ",");
                writer.write(pelicula.getSinopsis() + ",");
                writer.write(pelicula.getGenero());
    
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    //importar clientes del csv
    public void importarClientes(String archivo)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    // Asignación de los datos del cliente
                    String nombreUsuario = parts[0];
                    double saldo = Double.parseDouble(parts[1].trim());
                    String claveUsuario = parts[2];
                    int nivelMembresia = Integer.parseInt(parts[3].trim());

                    ArrayList<Pelicula> peliculasPosecion = new ArrayList<>();
                    if(parts.length >= 5){
                        
                        for (int i = 4; i < parts.length; i++) {
                        String nombrePelicula = parts[i];
                        // Buscar la película por nombre y agregarla a la lista de películas en posesión
                        Pelicula pelicula = mapaPeliculas.get(nombrePelicula);
                        if (pelicula != null) {
                            peliculasPosecion.add(pelicula);
                        }
                    }

                    }
                    if(nivelMembresia == 0)
                    {
                        // Crear un objeto Cliente y agregarlo a la lista y al mapa
                        Cliente cliente = new Cliente(nombreUsuario, saldo,claveUsuario);
                        cliente.agregarPeliculasImportadas(peliculasPosecion);
                        listaClientes.add(cliente);
                        mapaClientes.put(nombreUsuario, cliente);
                    }
                    else{
                        //crear un Cliente prime y agregarlo a la lista y al mapa
                        ClientePrime primeCliente = new ClientePrime(nombreUsuario, claveUsuario, saldo, nivelMembresia);
                        primeCliente.agregarPeliculasImportadas(peliculasPosecion); 
                        listaClientes.add(primeCliente);
                        mapaClientes.put(nombreUsuario, primeCliente);
                    }
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }    
    }

    // Exportar CLientes


    public void exportarClientes(String archivo) {
        
        //escritor
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            //se exporta cada cliente en el bucle
            for (Cliente cliente : listaClientes) {
                writer.write(cliente.getNombreUsuario() + ",");
                writer.write(cliente.getSaldo() + ",");
                writer.write(cliente.getClave() + ",");

                //si el cliente es instancia de clientePrime, se exporta con su nivel de membresia indicado
                if(cliente instanceof ClientePrime)
                {
                    ClientePrime client = (ClientePrime) cliente;
                    writer.write(client.getNivelMembresia() + "");
                }
                else //en caso contrario se representa con un 0 que es un cliente sin suscripción
                {
                    writer.write("0");
                }

                //se obtienen los nombres de las películas arrendadas por el cliente
                ArrayList<String> pelisCliente = cliente.peliculasArrendadas();
                
                if(pelisCliente.size() > 0)
                {
                    writer.write(",");
                }

                //se escriben en la linea de texto
                for(int i = 0 ; i < pelisCliente.size() ; i++)
                {
                    writer.write(pelisCliente.get(i));

                    if(pelisCliente.size() -1  == i)
                    {
                        break;
                    }
                    writer.write(",");
                }


                writer.newLine();
            }
        } catch (IOException e) {
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
      public ArrayList<Pelicula> buscarPeliculasPorRating(double rating){

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

    //se verifica que el cliente exista dentro del videoclub y que coincida su contraseña con la ingresada 
    public Cliente iniciarSesion(String nombre, String password)
    {
        if(mapaClientes.containsKey(nombre))
        {
            Cliente client = mapaClientes.get(nombre);

            if(client.getClave().equals(password)){
                return client;
            }
        }
        return null;
    }
    //se obtiene una lista con los nombres de las peliculas del videoclub
    public ArrayList<String> obtenerNombresPeliculas()
    {
        ArrayList<String> pelis = new ArrayList<String>();
        for(Pelicula peli : listaPeliculas)
        {
            pelis.add(peli.getTitulo());
        }
        return pelis;
    }

    
    public boolean existeCliente(String nombre)
    {
        if(mapaClientes.containsKey(nombre))
        {
            return true;
        }
        else{
            return false;
        }
    }



    



}