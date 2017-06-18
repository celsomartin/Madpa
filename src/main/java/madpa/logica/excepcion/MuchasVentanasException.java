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
public class MuchasVentanasException extends Exception{
    
    private String mensaje;
    
    public MuchasVentanasException() {}
    
    public static void lanzarMensaje() {
        
        JOptionPane.showMessageDialog(null
                , "Esta ventana ya se encuentra abierta"
                , "Atencion"
                , JOptionPane.WARNING_MESSAGE);
        
    }
    
}
