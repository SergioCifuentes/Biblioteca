/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import static biblioteca.ManejadorDeArchivos.IDENTIFICADOR_FECHA;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sergio
 */
public class ManejadorDeErrores {

    public static int PARAMETROS_LIBRO = 4;
    public static int PARAMETROS_ESTUDIANTE = 3;
    public static int PARAMETROS_PRESTAMO = 3;
    public static String ERROR_CODIGO_INVALIDO = "Error!! Codigo invalido";
    public static String ERROR_ARCHIVO_EXISTENTE = "Error!! Ya Existente";
    public static String ERROR_LIBOR_NO_EXISTENTE = "Error!! Libro no exsite";
    public static String ERROR_ESTUDIANTE_NO_EXISTENTE = "Error!! Estudiante no registrado";
    public static String ERROR_CANTIDAD_INVALIDO = "Error!! Cantidad Invalido";
    public static String ERROR_FECHA_INVALIDO = "Error!! Fecha Invalido";
    public static String ERROR_CARNET_INVALIDO = "Error!! Carnet Invalido";
    public static String ERROR_CARNET_INSUFICIENTE = "Error!! Carnet debe tener 9 digitos";
    public static String ERROR_CARRERA_INVALIDO = "Error!! Carrera no existente";
    public static String ERROR_PARAMETRO_FALTANTE = "Error!! Parametro Faltante";

    public static String verificarErroresLibro(String[] linea) throws IOException, FileNotFoundException, ClassNotFoundException {
        String mensajeError = null;
        boolean tituloExistente = false;
        boolean autorExistenete = false;
        boolean codigoExistente = false;
        boolean cantidadExistente = false;
        boolean parametroFaltante = false;

        for (int i = 0; i < PARAMETROS_LIBRO; i++) {
            if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_TITULO)) {
                tituloExistente = true;
            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_AUTOR)) {
                cantidadExistente = true;
            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_CODIGO)) {
                if (verificarCodigo(linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CODIGO.length() + 1))) {
                    if (LectorArchivos.buscarLibro(linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CODIGO.length() + 1)) == null) {
                        codigoExistente = true;
                    } else {
                        mensajeError = ERROR_ARCHIVO_EXISTENTE;
                    }
                } else {
                    mensajeError = ERROR_CODIGO_INVALIDO;
                    break;
                }
            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_CANTIDAD)) {
                try {
                    int numero = Integer.valueOf(linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CANTIDAD.length() + 1));
                    cantidadExistente = true;
                } catch (NumberFormatException e) {
                    mensajeError = ERROR_CANTIDAD_INVALIDO;
                    break;
                }
            } else {
                parametroFaltante = true;
            }
            if (parametroFaltante) {
                if (tituloExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_TITULO;
                } else if (autorExistenete == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_AUTOR;
                } else if (codigoExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_CODIGO;
                } else if (cantidadExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_CANTIDAD;
                }
                break;
            }
        }
        return mensajeError;
    }

    public static String verificarErroresEstudiante(String[] linea) throws IOException, FileNotFoundException, ClassNotFoundException {
        String mensajeError = null;
        boolean carnetExistente = false;
        boolean nombreExistente = false;
        boolean carreraExistente = false;
        boolean parametroFaltante = false;

        for (int i = 0; i < PARAMETROS_ESTUDIANTE; i++) {
            if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_CARNET)) {
                String carnet=linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CARNET.length() + 1);
                if (verificarCarnet(carnet)==null) {
                    if (LectorArchivos.buscarEstudiante(carnet)==null) {
                        carnetExistente=true;
                    }else{
                        mensajeError=ERROR_ARCHIVO_EXISTENTE;
                    }                    
                } else {
                    mensajeError=verificarCarnet(carnet);
                    carnetExistente=true;
                }

            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_NOMBRE)) {
                nombreExistente = true;
            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_CARRERA)) {
                if (verificarCarrera(linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CARRERA.length()+1))) {
                    carnetExistente=true;
                }else{
                    mensajeError=ERROR_CARNET_INVALIDO;
                }
            }else {
                parametroFaltante = true;
            }
            if (parametroFaltante) {
                if (carnetExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_CARNET;
                } else if (nombreExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_NOMBRE;
                } else if (carreraExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_CARRERA;
                }
                break;
            }
        }
        return mensajeError;
    }

    public static String verificarErroresPrestamo(String[] linea) throws IOException, FileNotFoundException, ClassNotFoundException {
        String mensajeError = null;
        boolean codigoLibroExistente = false;
        boolean carnetExistente = false;
        boolean fechaExistente = false;
        boolean parametroFaltante = false;

        for (int i = 0; i < PARAMETROS_PRESTAMO; i++) {
            if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_CODIGO_LIBRO)) {
                if (verificarCodigo(linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CODIGO_LIBRO.length() + 1))) {
                    if (LectorArchivos.buscarLibro(linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CODIGO_LIBRO.length() + 1)) != null) {
                        codigoLibroExistente = true;
                    } else {
                        mensajeError = ERROR_LIBOR_NO_EXISTENTE;
                    }
                } else {
                    mensajeError = ERROR_CODIGO_INVALIDO;
                    break;
                }
            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_CARNET)) {
                String carnet=linea[i].substring(ManejadorDeArchivos.IDENTIFICADOR_CARNET.length() + 1);
                if (verificarCarnet(carnet)==null) {
                    if (LectorArchivos.buscarEstudiante(carnet)!=null) {
                        carnetExistente=true;
                    }else{
                        mensajeError=ERROR_ESTUDIANTE_NO_EXISTENTE;
                    }                    
                } else {
                    mensajeError=verificarCarnet(carnet);
                    carnetExistente=true;
                }
            } else if (linea[i].startsWith(ManejadorDeArchivos.IDENTIFICADOR_FECHA)) {
                try {
                    String nuevo = linea[i].substring(IDENTIFICADOR_FECHA.length()+1);
                    LocalDate fecha =LocalDate.of(Integer.valueOf(nuevo.substring(0,4)),Integer.valueOf(nuevo.substring(5,7)),Integer.valueOf(nuevo.substring(8,10)));
                    fechaExistente=true;
                } catch (NumberFormatException e) {
                    mensajeError=ERROR_FECHA_INVALIDO;
                }
            }else {
                parametroFaltante = true;
            }
            if (parametroFaltante) {
                if (codigoLibroExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_CODIGO_LIBRO;
                } else if (carnetExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_CARNET;
                } else if (fechaExistente == false) {
                    mensajeError = ERROR_PARAMETRO_FALTANTE + " " + ManejadorDeArchivos.IDENTIFICADOR_FECHA;
                }
                break;
            }
        }
        return mensajeError;
    }

    protected  static boolean verificarCodigo(String codigo) {
        int CANTIDAD_NUMEROS = 3;
        int CANTIDAD_MAYUSCULAS = 3;
        boolean correcto = true;
        if (codigo.indexOf("-") != CANTIDAD_NUMEROS) {
            correcto = false;
        } else {
            try {
                String nuevo = codigo.substring(0, CANTIDAD_NUMEROS);
                int numeros = Integer.valueOf(nuevo);
                String mayusculas = codigo.substring(CANTIDAD_NUMEROS + 1);
                if (mayusculas.length() == CANTIDAD_MAYUSCULAS) {
                    Pattern patron = Pattern.compile("[^A-Z]");
                    Matcher encaja = patron.matcher(mayusculas);
                    if (encaja.find()) {
                        correcto = false;
                    }
                } else {
                    correcto = true;
                }

            } catch (NumberFormatException e) {
                correcto = false;
            }
        }
        return correcto;
    }

    private static String verificarCarnet(String carnet) {
        String correcto = null;
        try {
            int numero = Integer.valueOf(carnet);
            if (numero > 99999999&& numero<1000000000) {
                correcto=null;
            } else {
                correcto = ERROR_CARNET_INSUFICIENTE;
            }
        } catch (NumberFormatException e) {
            correcto=ERROR_CARNET_INVALIDO;
        }
        return correcto;
    }
    protected  static boolean  verificarCarrera(String carrera) {
        boolean  correcto;
        int inicio = 1;
        int fin = 5;
        try {
            int numero = Integer.valueOf(carrera);
            if (numero >= inicio&& numero<= fin) {
                correcto=true;
            } else {
                correcto = false;
            }
        } catch (NumberFormatException e) {
            correcto=false;
        }
        return correcto;
    }    
}
