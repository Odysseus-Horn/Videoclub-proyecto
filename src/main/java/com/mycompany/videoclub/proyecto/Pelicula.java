package com.mycompany.videoclub.proyecto;
public class Pelicula {
    private String titulo;
    private int year;
    private int existencias;
    private int precioArriendo;
    private String sinopsis;
    private float rating;
    private String genero;

    public Pelicula(String titulo, int year, int existencias, int precioArriendo, float rating, String sinopsis, String genero){
        this.titulo = titulo;
        this.year = year;
        this.existencias = existencias;
        this.precioArriendo = precioArriendo;
        this.rating = rating;
        this.sinopsis = sinopsis;
        this.genero = genero;
        
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

    public void setGenero(String genero){
    this.genero = genero;
  }

  public String getGenero(){
    return genero;
  }

  //operaciones con métodos

  public void reducirExistencias(int quant)
  {
    existencias -= quant;
  }

  public void aumentarExistencias(int quant)
  {
    existencias += quant;
  }

  

}