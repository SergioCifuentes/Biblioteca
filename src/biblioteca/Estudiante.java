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
public class Estudiante implements Serializable{
    private int carnet;
    private String nombre;
    private int carrera;
    LocalDate fechaDeNacimiento;

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarrer() {
        return carrera;
    }

    public Estudiante(int carnet, String nombre, int carrer) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrer;
        this.fechaDeNacimiento=null;
    }
}
