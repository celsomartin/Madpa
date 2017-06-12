/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import madpa.gui.panelbasico.Botones;

/**
 *
 * @author Celso
 */
public class Intoxicacion extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoIntoxicacion;
    private BorderLayout distEspacial;

    public Intoxicacion() {
        
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        this.setLayout(this.distEspacial);
        
        this.panelTipoIntoxicacion = new Botones();
        
        this.panelTipoIntoxicacion.añadirBoton("Alcohol");
        this.panelTipoIntoxicacion.añadirBoton("Alimetos");
        this.panelTipoIntoxicacion.añadirBoton("Monoxido de Carbono(CO)");
        this.panelTipoIntoxicacion.añadirBoton("Hongo o setas");
        this.panelTipoIntoxicacion.añadirBoton("Insecticidas");
        this.panelTipoIntoxicacion.añadirBoton("Sobre dosis de droga");
        
        this.panelTipoIntoxicacion.generarPanel(new BoxLayout(this.panelTipoIntoxicacion.obtenerPanel(), BoxLayout.Y_AXIS));
        
        añadirListeners();
        
        this.add(this.panelTipoIntoxicacion, BorderLayout.EAST);
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(100, 100));
        this.setMinimumSize(new Dimension(500, 500));
        this.setVisible(true);
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoIntoxicacion.obtenerCantidadDeBotones(); i++) {
            
            this.panelTipoIntoxicacion.obtenerBoton(i).addActionListener(this);
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("Alcohol")) {
            
        }
        
        if (botonEvento.equals("Alimentos")) {
            
        }
        
        if (botonEvento.equals("Monoxido de Carbono(CO)")) {
            
        }
        
        if (botonEvento.equals("Hongo o setas")) {
            
        }
        
        if (botonEvento.equals("Insecticidas")) {
            
        }
        
        if (botonEvento.equals("Sobre dosis de droga")) {
            
        }
        
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getWindow() == this) {
            Principal p = new Principal();
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
