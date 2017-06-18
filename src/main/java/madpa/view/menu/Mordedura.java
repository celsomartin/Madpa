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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import madpa.logica.panelbasico.Botones;

/**
 *
 * @author Celso
 */
public class Mordedura extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoMor;
    private JFrame ventPrin;
    
    public Mordedura(JFrame ventPrin) {
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        this.panelTipoMor = new Botones();
        
        this.panelTipoMor.añadirBoton("Perro");
        this.panelTipoMor.añadirBoton("Raton");
        this.panelTipoMor.añadirBoton("Serpiente");
        this.panelTipoMor.añadirBoton("Murcielago");
        
        int numFil = this.panelTipoMor.obtCantBotones();
        this.panelTipoMor.generarPanel(new GridLayout(numFil, 1, 1, 10));
        
        añadirListeners();
        
        this.setTitle("Mordedura");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoMor.obtCantBotones(); i++) {
            
            this.panelTipoMor.obtenerBoton(i).addActionListener(this);
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("Perro")) {
            
        }
        
        if (botonEvento.equals("Raton")) {
            
        }
        
        if (botonEvento.equals("Serpiente")) {
            
        }
        
        if (botonEvento.equals("Murcielago")) {
            
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
