package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class ManejadorDeArchivos {
    public final static File CARPETA_LIBROS= new File("Libros");
    public static String IDENTIFICADOR_LIBRO = "LIBRO";
    public final static File CARPETA_ESTUDIANTES= new File("Estudiantes");
    public static String IDENTIFICADOR_ESTUDIANTE = "ESTUDIANTE";
    public final static File CARPETA_PRESTAMO= new File("Prestamos");
    public static String IDENTIFICADOR_PRESTAMO = "PRESTAMO";
    

    protected static void cargarArchivo(File file) throws FileNotFoundException, IOException {
        int numeroLineas = 0;
        ArrayList<String> lines = new ArrayList<>();
        File input = new File(file.getPath());
        Scanner scannerTexto = new Scanner(input);
        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        String line1;

        while ((line1 = br.readLine()) != null) {
            lines.add(line1);
        }
        if (lines.get(numeroLineas).equals(IDENTIFICADOR_LIBRO)) {
            boolean elementosFaltantes=false;
            String[] parametrosLibros = new String[4];
            for (int i = 1; i <= 4; i++) {
                if (lines.get(i+numeroLineas).equals(IDENTIFICADOR_ESTUDIANTE) || lines.get(i+numeroLineas).equals(IDENTIFICADOR_LIBRO)|| lines.get(i+numeroLineas).equals(IDENTIFICADOR_PRESTAMO)) {
                      elementosFaltantes=true;
                }else{
                    parametrosLibros[i-1]=lines.get(i+numeroLineas);
                }                
            }
            if (elementosFaltantes) {
                
            }else{
                if (ManejadorDeErrores.verificarErroresLibro(parametrosLibros)) {
                
            }
            }
            
        }else if (lines.get(numeroLineas).equals(IDENTIFICADOR_LIBRO)) {
            
        }
        
    }

    protected static void crearArchivoLibro(Libro libroAGuardar) throws FileNotFoundException, IOException {
        if(CARPETA_LIBROS.exists()==false){
            CARPETA_LIBROS.mkdir();
            CARPETA_LIBROS.mkdirs();
        }        
        ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(CARPETA_LIBROS.getAbsolutePath()+"/"+libroAGuardar.getCodigo()));
        guardar.writeObject(libroAGuardar);         
    }
    protected static void crearArchivoEstudiantes(Estudiante estudianteAGuardar) throws FileNotFoundException, IOException {
        if(CARPETA_ESTUDIANTES.exists()==false){
            CARPETA_ESTUDIANTES.mkdir();
            CARPETA_ESTUDIANTES.mkdirs();
        }
        ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(CARPETA_ESTUDIANTES.getAbsolutePath()+"/"+estudianteAGuardar.getCarnet()));
        guardar.writeObject(estudianteAGuardar); 
    }
    protected static void crearArchivoPrestamo(Prestamo prestamoAGuardar) throws FileNotFoundException, IOException {
        if(CARPETA_PRESTAMO.exists()==false){
            CARPETA_PRESTAMO.mkdir();
            CARPETA_PRESTAMO.mkdirs();
        }
        int numeroDePrestamo = CARPETA_PRESTAMO.list().length+1;
                ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(CARPETA_ESTUDIANTES.getAbsolutePath()+"/"+numeroDePrestamo));
        guardar.writeObject(prestamoAGuardar); 
    }
    
}
