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
public class Ordenaciones {
    public static final String IDENTFICADOR_DE_ORDEN_CODIGO = "Codigo";
    public static final String IDENTFICADOR_DE_ORDEN_TITULO = "Titulo";
    public static final String IDENTFICADOR_DE_ORDEN_AUTOR = "Autor";
    public static final String IDENTFICADOR_DE_ORDEN_CARNET = "Carnet";
    public static final String IDENTFICADOR_DE_ORDEN_NOMBRE = "Nombre";
    public static final String IDENTFICADOR_DE_ORDEN_CARRERA = "Carrera";
    
    protected static Libro[] ordenarLibros(Libro[] librosAOrdenar,String identificador){
       Libro[] librosOrdenados = new Libro[librosAOrdenar.length];
       librosOrdenados=librosAOrdenar;
        int auxiliar;
        for (int i = 1; i < librosAOrdenar.length; i++) {
            auxiliar = i;            
            Libro libroMayor = librosAOrdenar[i];
            switch (identificador) {
                case IDENTFICADOR_DE_ORDEN_CODIGO://Por Puntos estado
                    while (auxiliar > 0 && libroMayor.getCodigo().compareTo(librosOrdenados[auxiliar-1].getCodigo())<0) {
                        librosOrdenados[auxiliar] = librosOrdenados[auxiliar - 1];
                        auxiliar--;
                    }
                    break;
                case IDENTFICADOR_DE_ORDEN_TITULO://Por Orden Alfabetico
                    while (auxiliar > 0 && libroMayor.getTitulo().compareToIgnoreCase(librosOrdenados[auxiliar - 1].getTitulo()) < 0) {
                        librosOrdenados[auxiliar] = librosOrdenados[auxiliar - 1];
                        auxiliar--;
                    }
                    break;
                case IDENTFICADOR_DE_ORDEN_AUTOR://Por Fecha EnemigosDestruidos
                    while (auxiliar > 0 && libroMayor.getAutor().compareTo(librosOrdenados[auxiliar-1].getAutor())<0) {
                        librosOrdenados[auxiliar] = librosOrdenados[auxiliar - 1];
                        auxiliar--;
                    }
                    break;                 
            }
            librosOrdenados[auxiliar] = libroMayor;
        }
       return librosOrdenados;    
    }
 protected static Estudiante[] ordenarEstudiantes(Estudiante[] estudiantesAOrdenar,String identificador){
       Estudiante[] estudiantesOrdenados = new Estudiante[estudiantesAOrdenar.length];
       estudiantesOrdenados=estudiantesAOrdenar;
        int auxiliar;
        for (int i = 1; i < estudiantesAOrdenar.length; i++) {
            auxiliar = i;            
            Estudiante estudianteMayor = estudiantesAOrdenar[i];
            switch (identificador) {
                case IDENTFICADOR_DE_ORDEN_CARNET://Por Puntos estado
                    while (auxiliar > 0 && estudianteMayor.getCarnet()<estudiantesOrdenados[auxiliar-1].getCarnet()) {
                        estudiantesOrdenados[auxiliar] = estudiantesOrdenados[auxiliar - 1];
                        auxiliar--;
                    }
                    break;
                case IDENTFICADOR_DE_ORDEN_NOMBRE://Por Orden Alfabetico
                    while (auxiliar > 0 && estudianteMayor.getNombre().compareToIgnoreCase(estudiantesOrdenados[auxiliar - 1].getNombre()) < 0) {
                        estudiantesOrdenados[auxiliar] = estudiantesOrdenados[auxiliar - 1];
                        auxiliar--;
                    }
                    break;
                case IDENTFICADOR_DE_ORDEN_CARRERA://Por Fecha EnemigosDestruidos
                    while (auxiliar > 0 && estudianteMayor.getCarrer()<estudiantesOrdenados[auxiliar-1].getCarrer()) {
                        estudiantesOrdenados[auxiliar] = estudiantesOrdenados[auxiliar - 1];
                        auxiliar--;
                    }
                    break;                 
            }
            estudiantesOrdenados[auxiliar] = estudianteMayor;
        }
       return estudiantesOrdenados;    
    }
}
