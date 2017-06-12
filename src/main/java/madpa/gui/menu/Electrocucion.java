/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import madpa.gui.panelbasico.Botones;
/**
 *
 * @author Celso
 */
public class Electrocucion extends JFrame implements WindowListener{
    
    

    public Electrocucion() {
        initComponent();
    }
    
    private void initComponent() {
        
        this.addWindowListener(this);
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(100, 100));
        this.setMinimumSize(new Dimension(500, 500));
        this.setVisible(true);
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
