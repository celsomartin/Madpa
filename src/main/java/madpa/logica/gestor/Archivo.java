/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.logica.gestor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Celso
 */
public class Archivo {
    
    private File archivo;
    
    
    public Archivo(String ruta) {
        
        this.archivo = new File(ruta);
        
    }
    
    public String obtenerDatos() throws FileNotFoundException, IOException {
        
        String datos = "";
        FileReader lecSec = new FileReader(this.archivo);
        BufferedReader lecLin = new BufferedReader(lecSec);
        
        String linea = lecLin.readLine();
        
        while (linea != null) {            
            
            datos += linea+ "\n";
            linea = lecLin.readLine();
            
        }
        
        lecLin.close();
        lecSec.close();
        
        return datos;
        
    }
    
}
