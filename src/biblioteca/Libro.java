/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author sergio
 */
public class Libro {
    private String titulo;
    private String autor;
    private String codigo;
    private int cantidad;
    public Libro(String titulo,String autor,String codigo, int cantidad){
        this.autor=autor;
        this.cantidad=cantidad;
        this.codigo=codigo;
        this.titulo=titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }
}
