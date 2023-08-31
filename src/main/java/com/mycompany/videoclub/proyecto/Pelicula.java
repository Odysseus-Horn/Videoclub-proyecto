package com.mycompany.videoclub.proyecto;
public class Pelicula {
    private String titulo;
    private int year;
    private int existencias;
    private int precioArriendo;
    private String sinopsis;
    private float rating;
    

    public Pelicula(String titulo, int year, int existencias, int precioArriendo, float rating, String sinopsis){
        this.titulo = titulo;
        this.year = year;
        this.existencias = existencias;
        this.precioArriendo = precioArriendo;
        this.rating = rating;
        this.sinopsis = sinopsis;
        //hola
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setNombrePelicula(String nombre){
      this.titulo = nombre;
    }
  

  public int getExistencias(){
    return existencias;
  }

  public void setExistencias(int existencias){
    this.existencias = existencias;
  }
  
  public int getYear(){
    return year;
  }

  public void setYear(int year){
    this.year = year;
  }

  public int getPrecioArriendo(){
    return precioArriendo;
  }

  public void setPrecioArriendo(int precioArriendo){
    this.precioArriendo = precioArriendo;
  }

  public String getSinopsis(){
    return sinopsis;
  }

  public void setSinopsis(String sinopsis){
    this.sinopsis = sinopsis;
  }

  public float getRating(){
    return rating;
  }
  public void setRating(float rating){
    this.rating = rating;
  }

  //operaciones con métodos

  public void reducirExistencias(int quant)
  {
    existencias -= quant;
  }
}