package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class ManejadorDeArchivos {

    public final static File CARPETA_LIBROS = new File("Libros");
    public static String IDENTIFICADOR_LIBRO = "LIBRO";
    public static String IDENTIFICADOR_TITULO = "TITULO";
    public static String IDENTIFICADOR_AUTOR = "AUTOR";
    public static String IDENTIFICADOR_CODIGO = "CODIGO";
    public static String IDENTIFICADOR_CANTIDAD = "CANTIDAD";
    public final static File CARPETA_ESTUDIANTES = new File("Estudiantes");
    public static String IDENTIFICADOR_ESTUDIANTE = "ESTUDIANTE";
    public static String IDENTIFICADOR_CARNET = "CARNET";
    public static String IDENTIFICADOR_NOMBRE = "NOMBRE";
    public static String IDENTIFICADOR_CARRERA = "CARRERA";
    public final static File CARPETA_PRESTAMO = new File("Prestamos");
    public static String IDENTIFICADOR_PRESTAMO = "PRESTAMO";
    public static String IDENTIFICADOR_CODIGO_LIBRO = "CODIGOLIBRO";
    public static String IDENTIFICADOR_FECHA = "FECHA";

    public static String PALABRA_COMPLETADO = "Completado!!!";
    public static String PALABRA_INVALIDO = "Identificador Invalido!";

    protected static ArrayList<String> cargarArchivo(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();
        File input = new File(file.getPath());
        Scanner scannerTexto = new Scanner(input);
        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        String line1;
        while ((line1 = br.readLine()) != null) {
            lines.add(line1);
        }
        for (int i = 0; i < lines.size(); i++) {
            //En caso de libro
            if (lines.get(i).equals(IDENTIFICADOR_LIBRO)) {
                String[] parametrosLibros = new String[ManejadorDeErrores.PARAMETROS_LIBRO];
                for (int j = 0; j < parametrosLibros.length; j++) {
                    parametrosLibros[j] = lines.get(j + i + 1);
                }
                String mensajeErrorPosible = ManejadorDeErrores.verificarErroresLibro(parametrosLibros);
                if (mensajeErrorPosible == null) {
                    Libro libroNuevo = crearObjetoLibro(parametrosLibros);
                    crearArchivoLibro(libroNuevo);
                    resultado.add(IDENTIFICADOR_LIBRO + " " + libroNuevo.getCodigo() + " " + PALABRA_COMPLETADO);
                    i = i + ManejadorDeErrores.PARAMETROS_LIBRO;
                } else {
                    resultado.add(IDENTIFICADOR_LIBRO+" "+mensajeErrorPosible);
                }
                //En caso de estudiante
            } else if (lines.get(i).equals(IDENTIFICADOR_ESTUDIANTE)) {
                String[] parametrosEstudiante = new String[ManejadorDeErrores.PARAMETROS_ESTUDIANTE];
                for (int j = 0; j < parametrosEstudiante.length; j++) {
                    parametrosEstudiante[j] = lines.get(j + i + 1);
                }
                String mensajeErrorPosible = ManejadorDeErrores.verificarErroresEstudiante(parametrosEstudiante);
                if (mensajeErrorPosible == null) {
                    Estudiante estudianteNuevo = crearObjetoEstudiante(parametrosEstudiante);
                    crearArchivoEstudiantes(estudianteNuevo);
                    resultado.add(IDENTIFICADOR_ESTUDIANTE + " " + estudianteNuevo.getCarnet() + " " + PALABRA_COMPLETADO);
                    i = i + ManejadorDeErrores.PARAMETROS_ESTUDIANTE;
                } else {
                    resultado.add(mensajeErrorPosible);
                }
                //En caso De Pestamo
            } else if (lines.get(i).equals(IDENTIFICADOR_PRESTAMO)) {
                String[] parametrosPrestamo = new String[ManejadorDeErrores.PARAMETROS_PRESTAMO];
                for (int j = 0; j < parametrosPrestamo.length; j++) {
                    parametrosPrestamo[j] = lines.get(j + i + 1);
                }
                String mensajeErrorPosible = ManejadorDeErrores.verificarErroresPrestamo(parametrosPrestamo);
                if (mensajeErrorPosible == null) {
                    Prestamo prestamoNuevo = crearObjetoPrestamo(parametrosPrestamo);
                    crearArchivoPrestamo(prestamoNuevo);
                    resultado.add(IDENTIFICADOR_PRESTAMO + " " + prestamoNuevo.getCodigoLibro() + " - " + prestamoNuevo.getCarnetEstudiante() + " " + PALABRA_COMPLETADO);
                    i = i + ManejadorDeErrores.PARAMETROS_PRESTAMO;
                } else {
                    resultado.add(mensajeErrorPosible);
                }
                //Palabra Invalida
            }else if(!lines.get(i).startsWith(IDENTIFICADOR_AUTOR)&&!lines.get(i).startsWith(IDENTIFICADOR_CANTIDAD)&&!lines.get(i).startsWith(IDENTIFICADOR_CARNET)&&!lines.get(i).startsWith(IDENTIFICADOR_NOMBRE)
            &&!lines.get(i).startsWith(IDENTIFICADOR_CARRERA)&&!lines.get(i).startsWith(IDENTIFICADOR_CODIGO)&&!lines.get(i).startsWith(IDENTIFICADOR_CODIGO_LIBRO)&&!lines.get(i).startsWith(IDENTIFICADOR_FECHA)&&!lines.get(i).startsWith(IDENTIFICADOR_TITULO)&&!lines.get(i).startsWith(" ")){
                 resultado.add(lines.get(i)+" "+PALABRA_INVALIDO);
            }
        }
        return resultado;
    }

    protected static void crearArchivoLibro(Libro libroAGuardar) throws FileNotFoundException, IOException {
        if (CARPETA_LIBROS.exists() == false) {
            CARPETA_LIBROS.mkdir();
            CARPETA_LIBROS.mkdirs();
        }
        ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(CARPETA_LIBROS.getAbsolutePath() + "/" + libroAGuardar.getCodigo()));
        guardar.writeObject(libroAGuardar);
    }

    protected static void crearArchivoEstudiantes(Estudiante estudianteAGuardar) throws FileNotFoundException, IOException {
        if (CARPETA_ESTUDIANTES.exists() == false) {
            CARPETA_ESTUDIANTES.mkdir();
            CARPETA_ESTUDIANTES.mkdirs();
        }
        ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(CARPETA_ESTUDIANTES.getAbsolutePath() + "/" + estudianteAGuardar.getCarnet()));
        guardar.writeObject(estudianteAGuardar);
    }

    protected static void crearArchivoPrestamo(Prestamo prestamoAGuardar) throws FileNotFoundException, IOException {
        if (CARPETA_PRESTAMO.exists() == false) {
            CARPETA_PRESTAMO.mkdir();
            CARPETA_PRESTAMO.mkdirs();
        }
        int numeroDePrestamo = CARPETA_PRESTAMO.list().length + 1;
        ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream(CARPETA_PRESTAMO.getAbsolutePath() + "/" + numeroDePrestamo));
        guardar.writeObject(prestamoAGuardar);
    }

    private static Libro crearObjetoLibro(String[] parametros) {
        String titulo = null;
        String autor = null;
        String codigo = null;
        int cantidad = 0;
        //algoritmo para que no afecte el orden de los parameros ingresados
        for (int i = 0; i < ManejadorDeErrores.PARAMETROS_LIBRO; i++) {
            if (parametros[i].startsWith(IDENTIFICADOR_TITULO)) {
                titulo = parametros[i].substring(IDENTIFICADOR_TITULO.length() + 1);
            } else if (parametros[i].startsWith(IDENTIFICADOR_AUTOR)) {
                autor = parametros[i].substring(IDENTIFICADOR_AUTOR.length() + 1);
            } else if (parametros[i].startsWith(IDENTIFICADOR_CODIGO)) {
                codigo = parametros[i].substring(IDENTIFICADOR_CODIGO.length() + 1);
            } else {
                cantidad = Integer.valueOf(parametros[i].substring(IDENTIFICADOR_CANTIDAD.length() + 1));
            }
        }
        return new Libro(titulo, autor, codigo, cantidad);
    }

    private static Estudiante crearObjetoEstudiante(String[] parametros) {
        int carnet = 0;
        String nombre = null;
        int carrera = 0;
        //algoritmo para que no afecte el orden de los parameros ingresados
        for (int i = 0; i < ManejadorDeErrores.PARAMETROS_ESTUDIANTE; i++) {
            if (parametros[i].startsWith(IDENTIFICADOR_CARNET)) {
                carnet = Integer.valueOf(parametros[i].substring(IDENTIFICADOR_CARNET.length() + 1));
            } else if (parametros[i].startsWith(IDENTIFICADOR_NOMBRE)) {
                nombre = parametros[i].substring(IDENTIFICADOR_NOMBRE.length() + 1);
            } else {
                carrera = Integer.valueOf(parametros[i].substring(IDENTIFICADOR_CARRERA.length() + 1));
            }
        }
        return new Estudiante(carnet, nombre, carrera);
    }

    private static Prestamo crearObjetoPrestamo(String[] parametros) {
        String codigoLibro = null;
        int carnetEstudiante = 0;
        LocalDate fecha = null;
        //algoritmo para que no afecte el orden de los parameros ingresados
        for (int i = 0; i < ManejadorDeErrores.PARAMETROS_PRESTAMO; i++) {
            if (parametros[i].startsWith(IDENTIFICADOR_CODIGO_LIBRO)) {
                codigoLibro = parametros[i].substring(IDENTIFICADOR_CODIGO_LIBRO.length() + 1);
            } else if (parametros[i].startsWith(IDENTIFICADOR_CARNET)) {
                carnetEstudiante = Integer.valueOf(parametros[i].substring(IDENTIFICADOR_CARNET.length() + 1));
            } else {               
                String nuevo = parametros[i].substring(IDENTIFICADOR_FECHA.length()+1);
                fecha =LocalDate.of(Integer.valueOf(nuevo.substring(0,4)),Integer.valueOf(nuevo.substring(5,7)),Integer.valueOf(nuevo.substring(8,10)));
            }
        }
        return new Prestamo(codigoLibro, carnetEstudiante, fecha);
    }
}
