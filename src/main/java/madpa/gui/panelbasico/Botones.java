/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.panelbasico;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Celso
 */
public class Botones extends JPanel{
    
    private ArrayList<JButton> listaBotones;
    private Dimension tamañoBoton;
    
    public Botones() {
        initComponent();
    }

    private void initComponent() {
        
        this.tamañoBoton = null;
        this.listaBotones = new ArrayList<>();
    }
    
    public void establecerColorDeFondo(Color colorFondo) {
        
        this.setBackground(colorFondo);
        
    }
    
    public void generarPanel(LayoutManager tipoDistribucion) throws IllegalArgumentException{
        
        if (tipoDistribucion != null) {
            
            this.setBackground(Color.WHITE);
            this.setLayout(tipoDistribucion);
            
            for (int i = 0; i < this.listaBotones.size(); i++) {
                
                if (this.tamañoBoton != null) {
                    
                    this.listaBotones.get(i).setPreferredSize(this.tamañoBoton);
                    
                }
                
                this.listaBotones.get(i).setActionCommand(this.listaBotones.get(i).getText());
                this.add(this.listaBotones.get(i));
                
            }
            
        } else {
            
            throw new IllegalArgumentException("Layout nulo");
            
        }
        
    }
    
    public JPanel obtenerPanel() {
        
        return this;
        
    }
    
    public void generarPanel(LayoutManager tipoDistribucion, Font fuente) {
        
        if (tipoDistribucion != null) {
            
            if (fuente != null) {
                
                this.setBackground(Color.WHITE);
                this.setLayout(tipoDistribucion);
            
                for (int i = 0; i < this.listaBotones.size(); i++) {

                    if (this.tamañoBoton != null) {
                        
                        this.listaBotones.get(i).setPreferredSize(this.tamañoBoton);
                        
                    }
                    
                    this.listaBotones.get(i).setActionCommand(this.listaBotones.get(i).getText());
                    this.listaBotones.get(i).setFont(fuente);
                    this.add(this.listaBotones.get(i));

                }
                
            } else{
                
                throw new IllegalArgumentException("Fuente nula");
                
            }
            
        } else {
            
            throw new IllegalArgumentException("Tipo Distribucion nula");
            
        }
        
    }
    
    public void añadirBoton() { this.listaBotones.add(new JButton()); }
    
    public void añadirBoton(String textoBoton) throws IllegalArgumentException{
        
        if (textoBoton != null && !textoBoton.isEmpty()) {
            
            this.listaBotones.add(new JButton(textoBoton));
            
        } else {
            
            throw new IllegalArgumentException("Nombre de botón nulo o vacío");
            
        }
        
    }
    
    public void añadirBoton(String textoBoton, Font fuente) {
        
        if (textoBoton != null && !textoBoton.isEmpty()) {
            
            this.listaBotones.add(new JButton(textoBoton));
            this.listaBotones.get(this.listaBotones.size() - 1).setFont(fuente);
            
        } else {
            
            throw new IllegalArgumentException("Texto boton nulo o vacio");
            
        }
        
        
    }
    
    public JButton obtenerBoton(String nombreBoton) throws NullPointerException, IllegalArgumentException{
        
        boolean botonEncontrado = false;
        
        if (nombreBoton != null && !nombreBoton.isEmpty()) {
            
            if (!this.listaBotones.isEmpty()) {
                
                for (int i = 0; i < this.listaBotones.size(); i++) {

                    if (this.listaBotones.get(i).getText().equals(nombreBoton)) {
                        
                        botonEncontrado = true;
                        return this.listaBotones.get(i);
                        
                    }

                }
                
                if (botonEncontrado == false) {
                    
                    throw new NullPointerException("No se encontró el botón");
                    
                }
                
            } else {
                
                throw new NullPointerException("No se ha encontrado ningun botón");
                
            }
            
        } else {
            
            throw new IllegalArgumentException("Nombre de botón nulo o vacío");
            
        }
        
        return null;
    }
    
    public ArrayList obtenerBotonesTodos() {
        
        return this.listaBotones;
        
    }
    
    public void establecerColorParaUnBoton(Color color, String nombreBoton) {
        
        for (JButton boton : this.listaBotones) {
            
            if (boton.getText().equals(nombreBoton)) {
                boton.setBackground(color);
            }
            
        }
        
    }
    
    public void establecerColorPredeterminado(Color color) {
        
        for (JButton boton : this.listaBotones) {
            
            boton.setBackground(color);
            
        }
        
    }
    
    public void establecerBotonesConTamañoPredeterminado(int ancho, int alto) {
        
        this.tamañoBoton = new Dimension(ancho, alto);
        
    }
    
    public int obtenerCantidadDeBotones() { return this.listaBotones.size(); }
    
    public JButton obtenerBoton(int indice) { return this.listaBotones.get(indice); }
    
    public void establecerFuentePredeterminada(Font fuente) {
        
        for (JButton boton : this.listaBotones) {
            boton.setFont(fuente);
        }
        
    }
    
    public void establecerCursor(Cursor cursor) {
        
        for (JButton boton : this.listaBotones) {
            
            boton.setCursor(cursor);
            
        }
        
    }
}
