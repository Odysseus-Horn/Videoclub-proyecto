package com.mycompany.videoclub.proyecto;

public class ClientePrime extends Cliente{
    private int nivelMembresia;

    public ClientePrime(String nombreUsuario, double saldo, int nivel){
        super(nombreUsuario, saldo);
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

}
