package com.mycompany.videoclub.proyecto;

import java.io.IOException;
import java.util.ArrayList;


public class Cliente {
    protected String nombreUsuario;
    protected String clave;
    protected double saldo;
    protected ArrayList<Pelicula> peliculasEnPosesion;

    public Cliente(String nombreUsuario, double saldo,String clave){
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        this.clave = clave;
        peliculasEnPosesion = new ArrayList<>();
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //getter
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public int getSizePeliculasEnPosesion()
    {
        return peliculasEnPosesion.size();
    }
    public String getClave(){
        return clave;
    }

    //setter
    public void setNombreUsuario(String nombre){
        nombreUsuario = nombre;
    }

    public void setSaldo(int monto)
    {
        saldo = monto;
    }
    public void setClave(String clave){
        this.clave = clave;
    }

    // Método para agregar saldo a la cuenta del cliente
    public void agregarSaldo(double monto) {
        saldo += monto;
    }

     // Sobrecarga del método para agregar saldo a la cuenta del cliente usando un valor entero
    public void agregarSaldo(int monto) {
        saldo += monto;
    }
    
    //metodo para arrendar una pelicula
    public boolean arrendarPelicula(Gestor club, String nombre) {
        Pelicula peli = club.buscarPeliculaPorNombre(nombre);
    
        try {
            if (peli == null) {
                throw new PeliculaNoExisteException("La película no existe en el catálogo");
            }
    
            if (peli.getExistencias() == 0) {
                throw new SinExistenciasExcepcion("Lo sentimos, no quedan existencias de la película");
            }
    
            if (saldo - peli.getPrecioArriendo() < 0) {
                throw new SaldoInsuficienteException("Lo sentimos, tu saldo es insuficiente");
            }
    
            saldo -= peli.getPrecioArriendo();
            peli.reducirExistencias(1);
            peliculasEnPosesion.add(peli);
            return true;
        } catch (PeliculaNoExisteException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (SinExistenciasExcepcion e) {
            System.out.println(e.getMessage());
            return false;
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    //se muestra los datos de las peliculas que tiene el cliente
    public boolean mostrarPeliculasEnPosesion() {
        System.out.println("Películas que has arrendado");
        
        if (peliculasEnPosesion.isEmpty()) {
            System.out.println("No has arrendado ninguna película");
            return false;
        } else 
        {
            for (Pelicula peli : peliculasEnPosesion) {
                System.out.println("----------------------");
                System.out.println("Título: " + peli.getTitulo());
                System.out.println("Año: " + peli.getYear());
                System.out.println("Valor Arriendo:" + peli.getPrecioArriendo());
                System.out.println("Rating: " + peli.getRating());
                System.out.println("Sinopsis: " + peli.getSinopsis());
                System.out.println("----------------------");
            }
            return true;
        }
    }

    //metodo para devolver una pelicula
    public boolean devolverPelicula(Gestor club, String nombrePeli)
    {
        Pelicula peli = club.buscarPeliculaPorNombre(nombrePeli);

        if(peliculasEnPosesion.contains(peli))
        {
            peliculasEnPosesion.remove(peli);
            peli.aumentarExistencias(1);
            return true;
        }
        else
        {
            System.out.println("No ha arrendado esa película, inténtelo de nuevo");
            return false;
        }
    }

    public void mostrarSaldo()
    {
        System.out.println("Tu saldo: $" + saldo);
    }
    
    public void agregarPeliculasImportadas(ArrayList<Pelicula> lista){

        //verificamos que la lista de peliculas del cliente tenga peliculas arrendadas
        if(lista.isEmpty()){
            return;
        }

        //recorremos la lista de peliculas del cliente
        for(int i = 0; i < lista.size(); i++){
            Pelicula peli = lista.get(i);
            peliculasEnPosesion.add(peli);
        }
    }

    //Devuelve la lista de los nombres de las peliculas arrendadas del usuario.
    public ArrayList<String> peliculasArrendadas()
    {   
        ArrayList<String> nombresPeliculas = new ArrayList<String>();

        for(int i = 0 ; i < peliculasEnPosesion.size() ; i++)
        {
            nombresPeliculas.add(peliculasEnPosesion.get(i).getTitulo());
        }


        return nombresPeliculas;
    }

}      

