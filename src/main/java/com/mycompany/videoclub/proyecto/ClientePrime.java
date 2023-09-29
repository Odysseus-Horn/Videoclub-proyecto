package com.mycompany.videoclub.proyecto;

public class ClientePrime extends Cliente{
    private int nivelMembresia;

    public ClientePrime(String nombreUsuario,String contrasena, double saldo, int nivel){
        super(nombreUsuario, saldo, contrasena);
        nivelMembresia = nivel;
    }

    //setters
    public void setNivelMembresia(int n)
    {
        nivelMembresia = n;
    }
    //getters 
    public int getNivelMembresia()
    {
        return nivelMembresia;
    }

    //sobreescritura de método agregarSaldo
    @Override
    public void agregarSaldo(double monto){
        switch(nivelMembresia){
            case 0: 
                saldo += monto;
            case 1:
                saldo += monto + (monto*0.1);
                break;
            case 2:
                saldo += monto + (monto*0.2);
                break;
            case 3:
                saldo += monto + (monto*0.3);
                break;
        }
    }

    //sobreescritura de devolverPelicula
    @Override
    public boolean devolverPelicula(Gestor club, String nombrePeli)
    {
        Pelicula peli = club.buscarPeliculaPorNombre(nombrePeli);

        if(peliculasEnPosesion.contains(peli))
        {
            peliculasEnPosesion.remove(peli);
            peli.aumentarExistencias(1);
            //se hace un cashback de 100 créditos
            saldo += 100;
            return true;
        }
        else
        {
            System.out.println("No ha arrendado esa película, inténtelo de nuevo");
            return false;
        }
    }
}
