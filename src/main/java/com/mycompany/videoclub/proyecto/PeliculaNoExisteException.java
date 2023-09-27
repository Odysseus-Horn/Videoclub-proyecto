package com.mycompany.videoclub.proyecto;

public class PeliculaNoExisteException extends Exception {
    public PeliculaNoExisteException(String mensaje) {
        super(mensaje);
    }
    
}
