/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class LectorArchivos {

    //Metodo devuelve un libro ya existente segun el codigo del libro
    public static Libro buscarLibro(String codigo) throws FileNotFoundException, IOException, ClassNotFoundException {
        Libro libro;
        File archivo = new File(ManejadorDeArchivos.CARPETA_LIBROS + "/" + codigo);
        if (archivo.exists()) {
            ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(archivo));
            libro = (Libro) objeto.readObject();
        } else {
            libro = null;
        }

        return libro;
    }

    //Devuelve el conjunto de todos los libros existentes
    protected static Libro[] cargarLibrosExistentes() throws IOException, FileNotFoundException, ClassNotFoundException {
        Libro[] libro = null;
        File carpeta = ManejadorDeArchivos.CARPETA_LIBROS;
        if (carpeta.exists()) {
            libro = new Libro[carpeta.list().length];
            for (int i = 0; i < carpeta.list().length; i++) {
                libro[i] = buscarLibro(carpeta.list()[i]); //llama el metodo de buscarLibro por cada archivo que existe
            }
        }
        return libro;
    }
    //Devuelve el conjunto de todos los estudiantes existentes

    protected static Estudiante[] cargarEstudianteExistentes() throws IOException, FileNotFoundException, ClassNotFoundException {
        Estudiante[] libro = null;
        File carpeta = ManejadorDeArchivos.CARPETA_ESTUDIANTES;
        if (carpeta.exists()) {
            libro = new Estudiante[carpeta.list().length];
            for (int i = 0; i < carpeta.list().length; i++) {
                libro[i] = buscarEstudiante(carpeta.list()[i]);//llama el metodo de buscarEstudiante por cada archivo que existe
            }
        }
        return libro;
    }
    //Metodo devuelve un estudiante ya existente segun el carnet del estudiante

    public static Estudiante buscarEstudiante(String carnet) throws FileNotFoundException, IOException, ClassNotFoundException {
        Estudiante estudiante;
        File archivo = new File(ManejadorDeArchivos.CARPETA_ESTUDIANTES + "/" + carnet);
        if (archivo.exists()) {
            ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(archivo));
            estudiante = (Estudiante) objeto.readObject();
        } else {
            estudiante = null;
        }

        return estudiante;
    }
    
    public static boolean existenciaEstudiante(String carnet){
        try {
            if(buscarEstudiante(carnet) != null)
                return true;
        } catch (IOException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean existenciaLibro(String codigo){
        try {
            if(buscarLibro(codigo) != null){
                return true;
            }           
            
        } catch (IOException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean estudianteEstadoCarnet(String carnet){
        try {
            return buscarEstudiante(carnet).isEstadoCarnet();
        } catch (IOException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Metodo devuelve un prestamos ya existente segun el carnet del estudiante
    protected static Prestamo[] cargarPrestamosExistentes() throws IOException, FileNotFoundException, ClassNotFoundException {
        Prestamo[] prestamo = null;
        File carpeta = ManejadorDeArchivos.CARPETA_PRESTAMO;
        if (carpeta.exists()) {
            prestamo = new Prestamo[carpeta.list().length];
            for (int i = 0; i < carpeta.list().length; i++) {
                File archivo = new File(ManejadorDeArchivos.CARPETA_PRESTAMO + "/" + carpeta.list()[i]);
                ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(archivo));
                prestamo[i] = (Prestamo) objeto.readObject();
            }
        }
        return prestamo;
    }
//Metodo que devuelve el conjunto de prestamos dependiendo de la carrera
    protected static ArrayList<Prestamo> buscarPrestamosPorCarrera(int carrera) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Prestamo> prestamos = new ArrayList();
        Prestamo[] prestamosTodos = cargarPrestamosExistentes();
        if (prestamosTodos != null) {
            for (int i = 0; i < prestamosTodos.length; i++) {
                if (buscarEstudiante(String.valueOf(prestamosTodos[i].getCarnetEstudiante())).getCarrer() == carrera) {
                    prestamos.add(prestamosTodos[i]);
                }
            }
        }
        if (prestamos.isEmpty()) {
            prestamos=null;
        }

        return prestamos;
    }
    
//Metodo que devuelve el conjunto de prestamos dependiendo de la carnet
    protected static ArrayList<Prestamo> buscarPrestamosPorCarnet(int carnet) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Prestamo> prestamos = new ArrayList();
        Prestamo[] prestamosTodos = cargarPrestamosExistentes();
        if (prestamosTodos != null) {
            for (int i = 0; i < prestamosTodos.length; i++) {
                if (buscarEstudiante(String.valueOf(prestamosTodos[i].getCarnetEstudiante())).getCarnet() == carnet) {
                    prestamos.add(prestamosTodos[i]);
                }
            }

        }
        if (prestamos.isEmpty()) {
            prestamos=null;
        }

        return prestamos;
    }

}
