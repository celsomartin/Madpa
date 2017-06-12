/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.panelbasico;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Celso
 */
public class Etiquetas extends JPanel{
    
    private ArrayList<JLabel> listaEtiquetas;
    private Font tipoFuente;
    
    public Etiquetas() { initComponent(); }
    
    private void initComponent() {
        
        this.listaEtiquetas = new ArrayList();
        
    }
    
    public void generarPanel(LayoutManager tipoDistribucion) {
        
        if (tipoDistribucion != null) {
            
            this.setBackground(Color.WHITE);
            this.setLayout(tipoDistribucion);

            for (JLabel etiqueta : this.listaEtiquetas) {

                this.add(etiqueta);

            }
            
        } else {
            
            throw new IllegalArgumentException("Tipo distribucion nula");
            
        }
        
    }
    
    public void generarPanel(LayoutManager tipoDistribucion, Font fuente) {
        
        if (tipoDistribucion != null) {
            
            if (fuente != null) {
                
                this.setBackground(Color.WHITE);
                this.setLayout(tipoDistribucion);
                
                for (JLabel etiqueta : this.listaEtiquetas) {
                    
                    etiqueta.setFont(fuente);
                    this.add(etiqueta);
                    
                }
                
            } else {
                
                throw new IllegalArgumentException("");
                
            }
            
        } else {
            
            throw new IllegalArgumentException("");
            
        }
        
    }
    
    public void añadirEtiqueta(String texto, Font fuente) {
        
        if (texto != null) {
            
            if (!texto.isEmpty()) {
                
                if (fuente != null) {
                    
                    this.listaEtiquetas.add(new JLabel(texto));
                    this.listaEtiquetas.get(this.listaEtiquetas.size() - 1).setFont(fuente);
                    
                } else {
                    
                    throw new IllegalArgumentException("Fuente nula");
                    
                }
                
            } else {
                
                throw new IllegalArgumentException("Texto sin valor asociado");
                
            }
            
        } else {
            
            throw new IllegalArgumentException("Texto nulo");
            
        }
        
    }
    
    public void añadirEtiqueta(String texto) {
        this.listaEtiquetas.add(new JLabel(texto));
        
    }
    
    public void añadirEtiquetaImagen(Icon imagen) {
        this.listaEtiquetas.add(new JLabel(imagen));
    }
    
    
    public void establecerColorDeFondo(Color colorFondo) {
        
        this.setBackground(colorFondo);
        
    }
    
    public int obtenerNumEtiquetas() {
        
        return this.listaEtiquetas.size();
        
    }
    
    public void removerComponentes() {
        
        this.removeAll();
        
    }
    
    
    public void crearEtiquetasConURL(String URL) {
        
        FileReader datos;
        BufferedReader lector;
        String linea;
        
        try {

            datos = new FileReader(URL);
            lector = new BufferedReader(datos);

            linea = lector.readLine();
            this.listaEtiquetas.add(new JLabel(linea));
            
            while (linea != null) {    
                
                linea = lector.readLine();
                this.listaEtiquetas.add(new JLabel(linea));

            }
            
            try {
                
                datos.close();
                lector.close();
                
            } catch (IOException errorEntradaSalida) {
                
                JOptionPane.showMessageDialog(null
                        , "Error al intentar cerrar archivo");
                
            }

        } catch (IOException fallo) {

            JOptionPane.showMessageDialog(
                    null, "Ha ocurrido un error al leer datos"
                            + ", favor ingrese nuevamente");

        }
        
    }
    
    public void vaciarEtiquetas() {
        
        if (!this.listaEtiquetas.isEmpty()) {
            
            this.listaEtiquetas.clear();
            
        }
        
    }
    
    public boolean hayEtiquetas() {
        
        return !this.listaEtiquetas.isEmpty();
        
    }

}
