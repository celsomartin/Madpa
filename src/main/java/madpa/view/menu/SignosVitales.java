/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class SignosVitales extends JFrame implements WindowListener{
    
    private JFrame ventPrin;
    private Etiquetas panelInf;
    
    public SignosVitales(JFrame ventPrin, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelInf();
        this.add(this.panelInf, BorderLayout.CENTER);
        
        this.setTitle("Donde se puede tomar los signos vitales");
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
        
    }
    
    private void crearPanelInf() {
        
        this.panelInf = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Signos vitales.txt";
        this.panelInf.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelInf.obtNumEtiquetas();
        this.panelInf.generarPanel(new GridLayout(numFil, 1));
        
    }
    

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
    
        if (e.getWindow() == this) {
            this.ventPrin.setEnabled(true);
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
