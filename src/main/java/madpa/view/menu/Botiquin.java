/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.view.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Botiquin extends JFrame implements WindowListener {
    
    private Etiquetas panelInformacion;
    private JFrame venPrin;
    
    public Botiquin(JFrame venPrin) {
        this.venPrin = venPrin;
        this.venPrin.setEnabled(false);
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        
        this.panelInformacion = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas\\Botiquin.txt";
        this.panelInformacion.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelInformacion.obtNumEtiquetas();
        this.panelInformacion.generarPanel(new GridLayout(numFil, 1));
        
        this.add(this.panelInformacion);

        this.setTitle("Botiquin");
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(new Dimension(800, 600));
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
        this.venPrin.setEnabled(true);
        
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
