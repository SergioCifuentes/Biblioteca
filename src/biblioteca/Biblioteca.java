/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author sergio
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        MenuPrincipal nuevo = new MenuPrincipal();
        nuevo.setVisible(true);
    }
    
}
