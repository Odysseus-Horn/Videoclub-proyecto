package com.mycompany.videoclub.proyecto;
import java.util.ArrayList;

public class Cliente {
    protected String nombreUsuario;
    protected double saldo;
    protected ArrayList<Pelicula> historialPeliculas;
    protected ArrayList<Pelicula> peliculasEnPosesion;

    public Cliente(String nombreUsuario, double saldo) {
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        historialPeliculas = new ArrayList<>();
        peliculasEnPosesion = new ArrayList<>();
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

    public ArrayList<Pelicula> getHistorialPelicula(short index) {
        return historialPeliculas;
    }

    public int getSizeHistorialPelicula()
    {
        return historialPeliculas.size();
    }

    public int getSizePeliculasEnPosesion()
    {
        return peliculasEnPosesion.size();
    }

    public ArrayList<Pelicula> getPeliculasenPosesion()
    {
        return peliculasEnPosesion;
    }

    //setter
    public void setNombreUsuario(String nombre){
        nombreUsuario = nombre;
    }

    public void setSaldo(int monto)
    {
        saldo = monto;
    }

    // Método para agregar saldo a la cuenta del cliente
    public void agregarSaldo(double monto) {
        saldo += monto;
    }

     // Sobrecarga del método para agregar saldo a la cuenta del cliente usando un valor entero
     public void agregarSaldo(int monto) {
        saldo += monto;
    }


    public boolean arrendarPelicula(Pelicula peli){
        if(peli.getExistencias() == 0 || saldo - peli.getPrecioArriendo() < 0)
        {
            return false;
        }
        
        saldo -= peli.getPrecioArriendo();
        peliculasEnPosesion.add(peli);
        historialPeliculas.add(peli);
        return true;
    }

    public void mostrarPeliculasEnPosesion() {
        System.out.println("Películas que has arrendado");
        
        if (peliculasEnPosesion.isEmpty()) {
            System.out.println("No has arrendado ninguna película");
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
        }
    }
    public boolean devolverPelicula(Pelicula peli, Gestor club)
    {
        if(peliculasEnPosesion.contains(peli))
        {
            peliculasEnPosesion.remove(peli);
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
}      

