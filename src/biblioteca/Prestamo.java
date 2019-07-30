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
public class Prestamo implements Serializable{
    private String codigoLibro;
    private int carnetEstudiante;
    private LocalDate fecha;
    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public int getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Prestamo(String codigoLibro, int carnetEstudiante, LocalDate fecha) {
        this.codigoLibro = codigoLibro;
        this.carnetEstudiante = carnetEstudiante;
        this.fecha = fecha;
    }
}
