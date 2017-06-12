/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import madpa.gui.panelbasico.Botones;

/**
 *
 * @author Celso
 */
public class Mordedura extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoMordedura;
    
    public Mordedura() {
        
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        
        this.panelTipoMordedura = new Botones();
        
        this.panelTipoMordedura.añadirBoton("Perro");
        this.panelTipoMordedura.añadirBoton("Raton");
        this.panelTipoMordedura.añadirBoton("Serpiente");
        this.panelTipoMordedura.añadirBoton("Murcielago");
        
        this.panelTipoMordedura.generarPanel(
                new GridLayout(this.panelTipoMordedura.obtenerCantidadDeBotones(), 1, 1, 10)
        );
        
        añadirListeners();
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(100, 100));
        this.setMinimumSize(new Dimension(500, 500));
        this.setVisible(true);
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoMordedura.obtenerCantidadDeBotones(); i++) {
            
            this.panelTipoMordedura.obtenerBoton(i).addActionListener(this);
            
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
