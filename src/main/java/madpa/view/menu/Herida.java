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
import madpa.logica.panelbasico.Botones;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
/**
 *
 * @author Celso
 */
public class Herida extends JFrame implements ActionListener, WindowListener{
    
    private Botones panelTipoHerida;
    private JFrame ventPrin;
    
    public Herida(JFrame ventana) {
        this.ventPrin = ventana;
        this.ventPrin.setEnabled(false);
        initComponent();
    }
    
    private void initComponent() {

        this.addWindowListener(this);
                
        crearPanelTipoHerida();
        this.add(this.panelTipoHerida, BorderLayout.NORTH);
        
        añadirListeners();
        
        this.setTitle("Herida");
        this.getContentPane().setBackground(Color.WHITE);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocation(new Point(200, 100));
        this.setVisible(true);
    }
    
    private void crearPanelTipoHerida() {
        
        this.panelTipoHerida = new Botones();
        
        this.panelTipoHerida.añadirBoton("La herida ha cortado la piel");
        this.panelTipoHerida.añadirBoton("La herida no ha cortado la piel");
        
        int numTipoHerida = this.panelTipoHerida.obtCantBotones();
        this.panelTipoHerida.generarPanel(new FlowLayout());
        
    }
    
    private void añadirListeners() {
        
        int numTipoHeridas = this.panelTipoHerida.obtCantBotones();
        
        for (int i = 0; i < numTipoHeridas; i++) {
            
            this.panelTipoHerida.obtenerBoton(i).addActionListener(this);
            
        }
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("La herida ha cortado la piel")) {
            
            
        }
        
        if (botonEvento.equals("La herida no ha cortado la piel")) {
            
            
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
