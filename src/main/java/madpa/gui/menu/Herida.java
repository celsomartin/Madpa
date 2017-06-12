/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import java.awt.Color;
import madpa.gui.panelbasico.Botones;
import madpa.gui.panelbasico.Etiquetas;
import java.awt.FlowLayout;
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
    
    private Etiquetas etiquetaInformacion;
    private Botones panelTipoHerida;
    
    public Herida() {
        initComponent();
    }
    
    private void initComponent() {
        
        this.setLayout(new FlowLayout());
        
        this.addWindowListener(this);
                
        crearPanelTipoHerida();
        this.add(this.panelTipoHerida);
        
        añadirListeners();
        
        this.setTitle("Herida");
        this.getContentPane().setBackground(Color.WHITE);
        this.pack();
        this.setLocation(new Point(200, 100));
        this.setVisible(true);
    }
    
    private void crearPanelTipoHerida() {
        
        this.panelTipoHerida = new Botones();
        
        this.panelTipoHerida.añadirBoton("La herida ha cortado la piel");
        this.panelTipoHerida.añadirBoton("La herida no ha cortado la piel");
        
        int numTipoHerida = this.panelTipoHerida.obtenerCantidadDeBotones();
        this.panelTipoHerida.generarPanel(new GridLayout(numTipoHerida, 1));
        
    }
    
    private void añadirListeners() {
        
        int numTipoHeridas = this.panelTipoHerida.obtenerCantidadDeBotones();
        
        for (int i = 0; i < numTipoHeridas; i++) {
            
            this.panelTipoHerida.obtenerBoton(i).addActionListener(this);
            
        }
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("La herida ha cortado la piel")) {
            
            System.out.println("La herida ha cortado la piel");
            
        }
        
        if (botonEvento.equals("La herida no ha cortado la piel")) {
            
            System.out.println("La herida no ha cortado la piel");
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        
        if (e.getWindow() == this)
            this.setTitle("");

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
