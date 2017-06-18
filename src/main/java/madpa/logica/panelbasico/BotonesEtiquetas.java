/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.logica.panelbasico;

import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import madpa.logica.excepcion.ErrorGestionArchivoException;
import madpa.logica.gestor.archivo.Archivo;

/**
 *
 * @author Celso
 */
public class BotonesEtiquetas {
    
    public static final int ETIQUETAS = 1;
    public static final int BOTONES = 2;
    
    private ArrayList<JButton> listaBotones;
    private ArrayList<JLabel> listaEtiquetas;

    public BotonesEtiquetas() {
        this.listaBotones = new ArrayList<>();
        this.listaEtiquetas = new ArrayList<>();
        
        initComponent();
    }

    private void initComponent() {
        
        
        
    }
    
    public void generarPanel(LayoutManager tipoDist, int primComp) {
        
        if (primComp == ETIQUETAS) {
            
            
            
        } else {
            
            if (primComp == BOTONES) {
                
                
                
            }
            
        }
        
        
    }
    
    public void crearEtiquetasConURL(String URL, int alin) {
        
        Archivo datos = new Archivo(URL);
        try {
            
            String texEtiq[] = datos.obtenerDatos().split("\n");
            
            for (int i = 0; i < texEtiq.length; i++) {
                JLabel e = new JLabel(texEtiq[i], alin);
                this.listaEtiquetas.add(e);
                
            }
            
        } catch (IOException fallo) {
            
            ErrorGestionArchivoException.lanzarMensaje();

        }
        
    }
    
    public JButton obtBoton(String nombreBoton) 
            throws NullPointerException, IllegalArgumentException{
        
        boolean botonEncontrado = false;
        
        if (nombreBoton != null && !nombreBoton.isEmpty()) {
            
            if (!this.listaBotones.isEmpty()) {
                
                for (int i = 0; i < this.listaBotones.size(); i++) {

                    if (this.listaBotones.get(i).getText().equals(nombreBoton)) {
                        
                        botonEncontrado = true;
                        return this.listaBotones.get(i);
                        
                    }

                }
                
                if (botonEncontrado == false) 
                    throw new NullPointerException();
                    
            } else
                throw new NullPointerException();
            
            
        } else
            throw new IllegalArgumentException();
        
        return null;
    }
    
    public ArrayList obtTodosLosBotones() {
        return this.listaBotones;
        
    }
    
    
    
    
    
}
