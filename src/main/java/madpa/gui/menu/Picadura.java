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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import madpa.gui.panelbasico.Botones;

/**
 *
 * @author Celso
 */
public class Picadura extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoPicadura;
    
    public Picadura() { initComponent(); }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        
        this.panelTipoPicadura = new Botones();
        
        this.panelTipoPicadura.añadirBoton("Alacran");
        this.panelTipoPicadura.añadirBoton("Zancudo");
        this.panelTipoPicadura.añadirBoton("Araña de rincon");
        this.panelTipoPicadura.añadirBoton("Abeja");
        this.panelTipoPicadura.añadirBoton("Medusa");
        this.panelTipoPicadura.añadirBoton("Garrapata");
        
        this.panelTipoPicadura.establecerColorDeFondo(Color.WHITE);
        this.panelTipoPicadura.generarPanel(
                new GridLayout(this.panelTipoPicadura.obtenerCantidadDeBotones(), 1, 1, 10), new Font(Font.SERIF, Font.BOLD, 20)
        );
        
        this.add(this.panelTipoPicadura, BorderLayout.WEST);
        
        añadirListeners();
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(100, 100));
        this.setMinimumSize(new Dimension(500, 500));
        this.setVisible(true);
    }
    
    private void añadirListeners() {
        
        for(int i = 0; i < this.panelTipoPicadura.obtenerCantidadDeBotones(); i++) {
            
            this.panelTipoPicadura.obtenerBoton(i).addActionListener(this);
            
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
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("")) {
            
        }
        
        if (botonEvento.equals("")) {
            
        }
        
        if (botonEvento.equals("")) {
            
        }
        
        if (botonEvento.equals("")) {
            
        }
        
        if (botonEvento.equals("")) {
            
        }
        
        if (botonEvento.equals("")) {
            
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
