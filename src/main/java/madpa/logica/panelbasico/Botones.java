/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.logica.panelbasico;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import madpa.logica.gestor.archivo.Archivo;

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
    
    public void generarPanel(LayoutManager tipoDistribucion) throws IllegalArgumentException{
        
        if (tipoDistribucion != null) {
            
            this.setBackground(Color.WHITE);
            this.setLayout(tipoDistribucion);
            
            for (int i = 0; i < this.listaBotones.size(); i++) {
                
                if (this.tamañoBoton != null)
                    this.listaBotones.get(i).setPreferredSize(this.tamañoBoton);
                    
                this.listaBotones.get(i).setActionCommand(this.listaBotones.get(i).getText());
                this.add(this.listaBotones.get(i));
                
            }
            
        } else 
            throw new IllegalArgumentException("Layout nulo");
            
    }
    
    public JPanel obtPanel() {
        return this;
    }
    
    public void generarPanel(LayoutManager tipoDistribucion, Font fuente) {
        
        if (tipoDistribucion != null) {
            
            if (fuente != null) {
                
                this.setBackground(Color.WHITE);
                this.setLayout(tipoDistribucion);
            
                for (int i = 0; i < this.listaBotones.size(); i++) {

                    if (this.tamañoBoton != null)
                        this.listaBotones.get(i).setPreferredSize(this.tamañoBoton);
                        
                    this.listaBotones.get(i).setActionCommand(this.listaBotones.get(i).getText());
                    this.listaBotones.get(i).setFont(fuente);
                    this.add(this.listaBotones.get(i));

                }
                
            } else
                throw new IllegalArgumentException("Fuente nula");
                
        } else 
            throw new IllegalArgumentException("Tipo Distribucion nula");
            
    }
    
    public void añadirBoton() { this.listaBotones.add(new JButton()); }
    
    public void añadirBoton(String textoBoton) throws IllegalArgumentException{
        
        if (textoBoton != null && !textoBoton.isEmpty()) {
            JButton boton = new JButton(textoBoton);
            boton.setName(textoBoton);
            this.listaBotones.add(boton);
            
        } else 
            throw new IllegalArgumentException("Nombre de botón nulo o vacío");
            
    }
    
    public void añadirBoton(String textoBoton, Font fuente) {
        
        if (textoBoton != null && !textoBoton.isEmpty()) {
            
            JButton boton = new JButton(textoBoton);
            boton.setName(textoBoton);
            boton.setFont(fuente);
            this.listaBotones.add(boton);
            
        } else 
            throw new IllegalArgumentException("Texto boton nulo o vacio");
            
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
    
    public void estabColorPred(Color color) {
        
        for (JButton boton : this.listaBotones) 
            boton.setBackground(color);
            
    }
    
    public void estabBotonesConTamañoPred(int ancho, int alto){
        
        this.tamañoBoton = new Dimension(ancho, alto);
        
    }
    
    public int obtCantBotones() { return this.listaBotones.size(); }
    
    public JButton obtenerBoton(int indice) { return this.listaBotones.get(indice); }
    
    public void estabFuentePred(Font fuente) {
        
        for (JButton boton : this.listaBotones) 
            boton.setFont(fuente);
        
    }
    
    public void estabCursor(Cursor cursor) {
        
        for (JButton boton : this.listaBotones)
            boton.setCursor(cursor);
            
    }
    
    public void crearBotonesConURL(String URL) throws IOException{
        
        Archivo datos = new Archivo(URL);
        
        String botones[] = datos.obtenerDatos().split("\n");
        
        for (int i = 0; i < botones.length; i++)
            this.listaBotones.add(new JButton(botones[i]));
            
    }
}
