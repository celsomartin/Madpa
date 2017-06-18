/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.logica.excepcion;

import javax.swing.JOptionPane;

/**
 *
 * @author Celso
 */
public class ErrorGestionArchivoException extends Exception {

    private String mensaje;
    
    public ErrorGestionArchivoException(String mensaje) {
        
        this.mensaje = mensaje;
        
    }
    
    public static void lanzarMensaje() {
        
        JOptionPane.showMessageDialog(
                null, "Ha ocurrido un error al procesar datos "
                + ", favor intente nuevamente", "Error", 
                JOptionPane.ERROR_MESSAGE);
        
    }
    
    
    
    
}
