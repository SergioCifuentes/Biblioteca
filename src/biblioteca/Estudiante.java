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
public class Estudiante {
    private int carnet;
    private String nombre;
    private int carrer;

    public int getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarrer() {
        return carrer;
    }

    public Estudiante(int carnet, String nombre, int carrer) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrer = carrer;
    }
}
