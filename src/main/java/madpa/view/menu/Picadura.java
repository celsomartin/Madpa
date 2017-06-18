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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import madpa.logica.panelbasico.Botones;

/**
 *
 * @author Celso
 */
public class Picadura extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoPic;
    private JFrame ventPrin;
    
    public Picadura(JFrame ventPrin) { 
        this.ventPrin = ventPrin;
        initComponent(); 
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoPic();
        this.add(this.panelTipoPic, BorderLayout.WEST);
        
        añadirListeners();
        
        this.setTitle("Picadura");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setMinimumSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
    private void crearPanelTipoPic() {
        
        this.panelTipoPic = new Botones();
        
        this.panelTipoPic.añadirBoton("Alacran");
        this.panelTipoPic.añadirBoton("Zancudo");
        this.panelTipoPic.añadirBoton("Araña de rincon");
        this.panelTipoPic.añadirBoton("Abeja");
        this.panelTipoPic.añadirBoton("Medusa");
        this.panelTipoPic.añadirBoton("Garrapata");
        
        this.panelTipoPic.setBackground(Color.WHITE);
        
        int numFil = this.panelTipoPic.obtCantBotones();
        this.panelTipoPic.generarPanel(new GridLayout(numFil, 1, 1, 10));
    }
    
    private void añadirListeners() {
        
        for(int i = 0; i < this.panelTipoPic.obtCantBotones(); i++) {
            
            this.panelTipoPic.obtenerBoton(i).addActionListener(this);
            
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
