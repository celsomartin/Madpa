/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.view.menu;

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
import madpa.logica.panelbasico.Botones;

/**
 *
 * @author Celso
 */
public class Intoxicacion extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoIntox;
    private JFrame ventPrin;

    public Intoxicacion(JFrame ventPrin) {
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoIntox();
        this.add(this.panelTipoIntox, BorderLayout.CENTER);
        
        añadirListeners();
        
        
        
        this.setTitle("Intoxicacion");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
    private void crearPanelTipoIntox() {
        
        this.panelTipoIntox = new Botones();
        
        this.panelTipoIntox.añadirBoton("Alcohol");
        this.panelTipoIntox.añadirBoton("Alimetos");
        this.panelTipoIntox.añadirBoton("Monoxido de Carbono(CO)");
        this.panelTipoIntox.añadirBoton("Hongo o setas");
        this.panelTipoIntox.añadirBoton("Insecticidas");
        this.panelTipoIntox.añadirBoton("Sobre dosis de droga");
        
        int numFil = this.panelTipoIntox.obtCantBotones();
        this.panelTipoIntox.generarPanel(new FlowLayout());
        
    }
            
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoIntox.obtCantBotones(); i++) {
            
            this.panelTipoIntox.obtenerBoton(i).addActionListener(this);
            
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
            this.setTitle("");
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
