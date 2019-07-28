/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.time.LocalDateTime;

/**
 *
 * @author sergio
 */
public class Prestamo {
    private String codigoLibro;
    private int carnetEstudiante;
    private LocalDateTime fecha;

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public int getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Prestamo(String codigoLibro, int carnetEstudiante, LocalDateTime fecha) {
        this.codigoLibro = codigoLibro;
        this.carnetEstudiante = carnetEstudiante;
        this.fecha = fecha;
    }
}
