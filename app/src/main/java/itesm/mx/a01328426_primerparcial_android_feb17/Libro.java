package itesm.mx.a01328426_primerparcial_android_feb17;

import java.io.Serializable;

/**
 * Created by alextrujillo on 18/02/17.
 */
public class Libro implements Serializable {

    private String isbn;
    private String titulo;
    private String cantidad;
    private String precio;
    private int idImagen;


    public Libro (String isbn,String titulo, String cantidad, String precio, int idImagen){
        this.isbn = isbn;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idImagen = idImagen;

    }

    public void setIsbn(String isbn){this.isbn = isbn;}
    public String getisbn() {return isbn;}

    public void setTitulo(String titulo){this.titulo = titulo;}
    public String getTitulo(){return titulo;}

    public void setCantidad(String  cantidad){this.cantidad = cantidad;}
    public String getCantidad(){return cantidad;}

    public void setPrecio(String  precio){this.precio = precio;}
    public String getPrecio(){return precio;}


    public void setIdImagen(int idImagen){this.idImagen = idImagen;}
    public int getIdImagen() {return idImagen; }



}