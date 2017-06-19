/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.logica.panelbasico;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import madpa.logica.excepcion.ErrorGestionArchivoException;
import madpa.logica.gestor.archivo.Archivo;

/**
 *
 * @author Celso
 */
public class Etiquetas extends JPanel{
    
    private ArrayList<JLabel> listaEtiquetas;
    
    public Etiquetas() { initComponent(); }
    
    private void initComponent() {
        
        this.listaEtiquetas = new ArrayList();
        
    }
    
    public void generarPanel(LayoutManager tipoDist) throws IllegalArgumentException{
        
        if (tipoDist != null) {
            
            this.setBackground(Color.WHITE);
            this.setLayout(tipoDist);

            for (JLabel etiqueta : this.listaEtiquetas) 
                this.add(etiqueta);
            
        } else
            throw new IllegalArgumentException();
            
    }
    
    public void generarPanel(LayoutManager tipoDist, Font fuente) throws IllegalArgumentException{
        
        if (tipoDist != null) {
            
            if (fuente != null) {
                
                this.setBackground(Color.WHITE);
                this.setLayout(tipoDist);
                
                for (JLabel etiqueta : this.listaEtiquetas) {
                    etiqueta.setFont(fuente);
                    this.add(etiqueta);
                    
                }
                
            } else 
                throw new IllegalArgumentException();
                
        } else
            throw new IllegalArgumentException();
            
    }
    
    public void generarPanel(LayoutManager tipoDist, Color colorFondo) throws IllegalArgumentException{
        
        if (tipoDist != null) {
            
            if (colorFondo != null) {
                
                this.setBackground(colorFondo);
                this.setLayout(tipoDist);
                
                for (JLabel etiqueta : this.listaEtiquetas) {
                    this.add(etiqueta);
                    
                }
                
            } else 
                throw new IllegalArgumentException();
                
        } else
            throw new IllegalArgumentException();
        
    }
    
    public void añadirEtiqueta(String texto, Font fuente, int alin) throws IllegalArgumentException{
        
        if (texto != null) {
            
            if (!texto.isEmpty()) {
                
                if (fuente != null) {
                    
                    JLabel e = new JLabel(texto, alin);
                    e.setName(texto);
                    this.listaEtiquetas.add(e);
                    e.setFont(fuente);
                    this.listaEtiquetas.add(e);
                    
                } else
                    throw new IllegalArgumentException("Fuente nula");
                   
            } else 
                throw new IllegalArgumentException("Texto sin valor asociado");
                
        } else
            throw new IllegalArgumentException("Texto nulo");
            
    }
    
    public void añadirEtiqueta(String texto) {
        
        JLabel e = new JLabel(texto);
        e.setName(texto);
        this.listaEtiquetas.add(e);
        
    }
    
    public void añadirEtiqueta(String texto, int alin) {
        JLabel e = new JLabel(texto, alin);
        e.setName(texto);
        this.listaEtiquetas.add(e);
    }
    
    public void añadirEtiquetaImagen(Icon imagen) {
        this.listaEtiquetas.add(new JLabel(imagen));
    }
    
    public int obtNumEtiquetas() {
        
        return this.listaEtiquetas.size();
        
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
    
    public void vaciarEtiquetas() {
        
        if (!this.listaEtiquetas.isEmpty())
            this.listaEtiquetas.clear();
            
    }
    
    public boolean hayEtiquetas() {
        
        return !this.listaEtiquetas.isEmpty();
        
    }
    
    public JPanel obtPanel() {
        
        return this;
        
    }

}
