/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.view.menu;

import java.awt.Dimension;
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
public class Sintomas extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTiposSintomas;
    
    public Sintomas() {
        
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        
        this.panelTiposSintomas = new Botones();
        
        this.panelTiposSintomas.añadirBoton("Zika");
        
        this.setSize(new Dimension(500, 500));
        this.setLocation(new Point(100, 100));
        this.setVisible(true);
        
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
    
        if (e.getWindow() == this) {
            
            Principal principal = new Principal();
            
        }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        
        
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
