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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JFrame;
import madpa.logica.excepcion.ErrorGestionArchivoException;

import madpa.logica.panelbasico.Botones;
import madpa.logica.panelbasico.Etiquetas;


/**
 *
 * @author Celso
 */
public class Quemadura extends JFrame implements ActionListener, WindowListener{
    
    private Botones panelTipoQuem;
    private JFrame ventPrin;
    
    public Quemadura(JFrame ventPrin) {
        this.ventPrin = ventPrin;
        initComponent();
    }

    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
                
        crearPanelTipoQuem();
        this.add(this.panelTipoQuem, BorderLayout.WEST);
        
        añadirListeners();
        
        this.setTitle("Quemadura");
        this.getContentPane().setBackground(Color.WHITE);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocation(new Point(200, 100));
        this.setVisible(true);
    }
    
    private void crearPanelTipoQuem() {
        
        this.panelTipoQuem = new Botones();
        String ruta = "BaseDeDatos\\Componentes\\Botones\\Menu quemadura.txt";
        
        try {
        
            this.panelTipoQuem.crearBotonesConURL(ruta);
            this.panelTipoQuem.setBackground(Color.WHITE);
            
            int numFil = this.panelTipoQuem.obtCantBotones();
            this.panelTipoQuem.generarPanel(new GridLayout(numFil, 1, 1, 10));
            
        } catch (IOException e) {
            
            ErrorGestionArchivoException.lanzarMensaje();

        }
        
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoQuem.obtCantBotones(); i++) {
            
            this.panelTipoQuem.obtenerBoton(i).addActionListener(this);
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("Primer Grado")) {
            
        }
        
        if (botonEvento.equals("Segundo Grado")) {
            
            
        }
        
        if (botonEvento.equals("Tercer Grado")) {
            
            
        }
        
        if (botonEvento.equals("Electrica")) {
            
            
        }
        
        if (botonEvento.equals("Por sol")) {
            
        }
        
        if (botonEvento.equals("Quimica")) {
            
            
        }
        
        if (botonEvento.equals("Congelacion")) {
            
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        
        if (e.getWindow() == this) {
            
            this.setTitle("");
            
        }
        this.ventPrin.setEnabled(true);
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
