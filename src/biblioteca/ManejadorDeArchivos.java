/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergio
 */
public class ManejadorDeArchivos {
    
    protected static void cargarArchivo(File file) throws FileNotFoundException, IOException{
        int numeroLineas=0;
        ArrayList<String> lines =new ArrayList<>();
        File input = new File(file.getPath());
        Scanner scannerTexto = new Scanner(input);
        BufferedReader br = new BufferedReader (new FileReader (file.getPath()));
        String line1; 
            
        while((line1=br.readLine())!=null){
        lines.add(line1);           
        }
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
            
        }
               
    }
}
