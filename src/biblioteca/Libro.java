/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author sergio
 */
public class Libro implements Serializable{
    private String titulo;
    private String autor;
    private String codigo;
    private int cantidad;
    private LocalDate fechaPublicacion;
    private String editorial;

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFehcaPublicacion(LocalDate fehcaPublicacion) {
        this.fechaPublicacion = fehcaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String Editorial) {
        this.editorial = Editorial;
    }
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
    
    public void quitarUnaCopia(){
        this.cantidad -= 1;
    }
    
    public void agregarUnaCopia(){
        this.cantidad += 1;
    }
}
