package com.mycompany.videoclub.proyecto;
import java.util.ArrayList;

public class Cliente {
    private String nombreUsuario;
    private double saldo;
    private ArrayList<Pelicula> historialPeliculas;
    private ArrayList<Pelicula> peliculasEnPosesion;

    public Cliente(String nombreUsuario, double saldo) {
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        historialPeliculas = new ArrayList<>();
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

    public boolean arrendarPelicula(Pelicula peli){
        if(peli.getExistencias() == 0)
        {
            System.out.println("no quedan existencias, por favor espere a que alguien retorne la película");
            return false;
        }
        
        peliculasEnPosesion.add(peli);
        historialPeliculas.add(peli);
        return true;
    }

    
}       