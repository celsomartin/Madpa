/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import madpa.gui.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Botiquin extends JFrame implements WindowListener {
    
    private Etiquetas panelInformacion;
    
    public Botiquin() {
        
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        
        this.panelInformacion = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra Herramientas\\Botiquin.txt";
        this.panelInformacion.crearEtiquetasConURL(ruta);
        
        int numEtiquetas = this.panelInformacion.obtenerNumEtiquetas();
        this.panelInformacion.generarPanel(new GridLayout(numEtiquetas, 1));
        
        this.add(this.panelInformacion);

        this.setTitle("Botiquin");
        this.getContentPane().setBackground(Color.WHITE);
        this.pack();
        this.setResizable(false);
        this.setLocation(new Point(200, 100));
        this.setVisible(true);
        
    }
    
  

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        
        if (e.getWindow() == this) {
        
            this.setTitle("");
            
        }
        
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
}
