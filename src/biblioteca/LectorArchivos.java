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

/**
 *
 * @author sergio
 */
public class LectorArchivos {
    //Metodo devuelve un libro ya existente segun el codigo del libro
    public static Libro buscarLibro(String codigo) throws FileNotFoundException, IOException, ClassNotFoundException{
        Libro libro;
        File archivo = new File(ManejadorDeArchivos.CARPETA_LIBROS+"/"+codigo);
        if (archivo.exists()) {
            ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(archivo));
            libro = (Libro)objeto.readObject();
        }else{
            libro=null;
        }
        
        return libro;
    }
    //Devuelve el conjunto de todos los libros existentes
    protected static Libro[] cargarLibrosExistentes() throws IOException, FileNotFoundException, ClassNotFoundException{
        Libro[] libro=null;
        File carpeta = ManejadorDeArchivos.CARPETA_LIBROS;
        if (carpeta.exists()) {
            libro=new Libro[carpeta.list().length];
            for (int i = 0; i < carpeta.list().length; i++) {
                libro[i]= buscarLibro(carpeta.list()[i]); //llama el metodo de buscarLibro por cada archivo que existe
            }
        }
        return libro;
    }
        
     //Devuelve el conjunto de todos los estudiantes existentes
    protected static Estudiante[] cargarEstudianteExistentes() throws IOException, FileNotFoundException, ClassNotFoundException{
        Estudiante[] libro=null;
        File carpeta = ManejadorDeArchivos.CARPETA_ESTUDIANTES;
        if (carpeta.exists()) {
            libro=new Estudiante[carpeta.list().length];
            for (int i = 0; i < carpeta.list().length; i++) {
                libro[i]= buscarEstudiante(carpeta.list()[i]);//llama el metodo de buscarEstudiante por cada archivo que existe
            }
        }
        return libro;
    }
    //Metodo devuelve un estudiante ya existente segun el carnet del estudiante
   
    public static Estudiante buscarEstudiante(String carnet) throws FileNotFoundException, IOException, ClassNotFoundException{
        Estudiante estudiante;
        File archivo = new File(ManejadorDeArchivos.CARPETA_ESTUDIANTES+"/"+carnet);
        if (archivo.exists()) {
            ObjectInputStream objeto = new ObjectInputStream(new FileInputStream(archivo));
            estudiante = (Estudiante)objeto.readObject();
        }else{
            estudiante=null;
        }
        
        return estudiante;
    }    
}
