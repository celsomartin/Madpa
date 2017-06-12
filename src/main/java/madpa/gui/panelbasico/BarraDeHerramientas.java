/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.panelbasico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Celso
 */
public class BarraDeHerramientas extends JPanel{
    
    private JMenuBar barra;
    private ArrayList<JMenu> listaMenus;
    private ArrayList<JMenuItem> listaItems;
    private Color colorDeFondoItems;
    private Color colorDeFondoMenus;
    private Color colorDeFondoBarra;
    
    public BarraDeHerramientas() { initComponent(); }

    private void initComponent() {
        
        this.colorDeFondoBarra = null;
        this.colorDeFondoItems = null;
        this.colorDeFondoMenus = null;
        this.barra = new JMenuBar();
        this.listaMenus = new ArrayList<>();
        this.listaItems = new ArrayList<>();
        
    }
    
    public void establecerColorDeFondoPanel(Color colorFondo) { 
 
        this.setBackground(colorFondo);      
        
    }
    
    public JMenuBar obtenerJMenuBar() {
        
        return this.barra;
        
    }
    
    public void añadirMenu(String nombreMenu) {
        
        if (nombreMenu != null && !nombreMenu.isEmpty()) {
            
            this.listaMenus.add(new JMenu(nombreMenu));

        } else {
            
            throw new IllegalArgumentException("Nombre de menu nulo o sin valor");
            
        }
        
    }
    
    public void añadirItem(String nombreItem, String menuDestino) {
        
        if (nombreItem != null && !nombreItem.isEmpty()) {
            
            if (menuDestino != null && !menuDestino.isEmpty()) {
                
                if (!this.listaMenus.isEmpty()) {

                    this.listaItems.add(new JMenuItem(nombreItem));
                    
                    int indiceUltimoItem = this.listaItems.size() - 1;
                    
                    this.listaItems.get(indiceUltimoItem).setActionCommand(nombreItem);
                    //Busca el menu e inserta el item                    }

                    for (int i = 0; i < this.listaMenus.size(); i++) {

                        if (this.listaMenus.get(i).getText().equals(menuDestino))    
                            this.listaMenus.get(i).add(this.listaItems.get(indiceUltimoItem));
                            
                    }
                    
                } else {

                    throw new NullPointerException("No existe el menu de destino señalado");

                }
                
            } else {
                
                throw new IllegalArgumentException("Menu Destino nulo o vacio");
            
            }
            
        } else {
            
            throw new IllegalArgumentException("Nombre Item nulo o vacio");
            
        }
        
    }
    
    public void generarPanel() {
        
        BoxLayout distHorizontal = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(distHorizontal);
        
        for (int i = 0; i < this.listaMenus.size(); i++) {
            
            this.barra.add(this.listaMenus.get(i));
            this.barra.setBackground(this.colorDeFondoBarra);
        }
        
        for (int i = 0; i < this.barra.getMenuCount(); i++) {
            
            if (this.colorDeFondoMenus != null)
                this.barra.getMenu(i).setBackground(this.colorDeFondoMenus);
            
            for (int j = 0; j < this.barra.getMenu(i).getItemCount(); j++) {
                
                if (this.colorDeFondoItems != null)
                    this.barra.getMenu(i).getItem(j).setBackground(this.colorDeFondoItems);
                    
            }
            
        }
        
        this.add(this.barra, BorderLayout.LINE_START);    
    }
    
    public JMenuItem obtenerItem(int indice) {
        
        String nombreItem = this.listaItems.get(indice).getText(); 
        boolean itemEncontrado = false;
        
        for (int i = 0; i < this.barra.getMenuCount(); i++) {
            
            for (int j = 0; j < this.barra.getMenu(i).getItemCount(); j++) {
                
                if (this.barra.getMenu(i).getItem(j).getText().equals(nombreItem)) {
                    
                    itemEncontrado = true;
                    return this.barra.getMenu(i).getItem(j);
                    
                }
                
            }
            
        }
        
        if (!itemEncontrado) {
            
            throw new NullPointerException("No se econtró el item del indice señalado");
            
        }
        
        return null;
        
    }
    
    public int obtenerCantidadDeItems() { return this.listaItems.size(); }
    
    public int obtenerCantidadDeMenus() { return this.listaMenus.size(); }
    
    public JMenu obtenerMenu(String nombreMenu) {
        
        JMenu menuTemporal = null;
        
        if (nombreMenu != null) {
            
            if (!this.listaMenus.isEmpty()) {
                
                for (int i = 0; i < this.listaMenus.size(); i++) {

                    if (this.listaMenus.get(i).getText().equals(nombreMenu)) {
                        
                        menuTemporal = this.listaMenus.get(i);
                        
                    }

                } 
                
                if (menuTemporal != null) {
                    
                    return menuTemporal;
                    
                } else {
                    
                    throw new NullPointerException("No se encontró el menu señalado");
                    
                }
                
            } else {
                
                throw new NullPointerException("No existe el menu señalado");
                
            }
            
        } else {
            
            throw new IllegalArgumentException("Nombre de menu nulo");
            
        }
    }
    
    public void establecerColorDeFondoBarra(Color colorDeFondo) {
        
        this.colorDeFondoBarra = colorDeFondo;
        
    }
    
    public void establecerColorDeFondoMenus(Color colorDeFondo) {
        
        this.colorDeFondoMenus = colorDeFondo;
        
    }
    
    public void establecerColorDeFondoItems(Color colorDeFondo) {
        
        this.colorDeFondoItems = colorDeFondo;
        
    }
    
    public void establecerFuentePredeterminada(Font fuente) {
        
         for (int i = 0; i < this.barra.getMenuCount(); i++) {
            
            for (int j = 0; j < this.barra.getMenu(i).getItemCount(); j++) {
                
                this.barra.getMenu(i).setFont(fuente);
                this.barra.getMenu(i).getItem(j).setFont(fuente);
                
            }
            
        }
        
    }
}
