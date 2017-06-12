/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import madpa.gui.panelbasico.Botones;
import madpa.gui.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Alergia extends JFrame implements WindowListener, ActionListener {
    
    private Botones panelTipoAlergia;
    private Etiquetas panelHiedraVenenosa;
    private Etiquetas panelPasto;
    private Etiquetas panelOcular;
    private Etiquetas panelTintaPelo;
    private Etiquetas panelLatex;
    private boolean instruccionAñadida;
    
    public Alergia() {
        
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.instruccionAñadida = false;
        this.addWindowListener(this);
        
        crearPanelTipoAlergia();
        this.add(this.panelTipoAlergia, BorderLayout.WEST);
        
        crearPanelHiedraVenenosa();
        this.panelHiedraVenenosa.setVisible(false);
        
        crearPanelOcular();
        this.panelOcular.setVisible(false);
        
        crearPanelPasto(); 
        this.panelPasto.setVisible(false);
        
        
        añadirListeners();
        
        this.setTitle("Alergia");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(700, 400));
        this.setVisible(true);
        
    }
    
    private void crearPanelPasto() {
        
        this.panelPasto = new Etiquetas();
        
        this.panelPasto.crearEtiquetasConURL("BaseDeDatos\\Alergia\\Pasto.txt");
        
        int numEtiquetas = this.panelPasto.obtenerNumEtiquetas();
        this.panelPasto.generarPanel(new GridLayout(numEtiquetas, 1));
        
    }
    
    private void crearPanelTipoAlergia() {
        
        this.panelTipoAlergia = new Botones();
        
        this.panelTipoAlergia.añadirBoton("Hiedra venenosa");
        this.panelTipoAlergia.añadirBoton("Latex");
        this.panelTipoAlergia.añadirBoton("Tinta de pelo");
        this.panelTipoAlergia.añadirBoton("Alimento");
        this.panelTipoAlergia.añadirBoton("Ocular");
        this.panelTipoAlergia.añadirBoton("Pasto");
        this.panelTipoAlergia.añadirBoton("Animales");
        
        int numTipoAlergia = this.panelTipoAlergia.obtenerCantidadDeBotones();
        this.panelTipoAlergia.generarPanel(
                new GridLayout(numTipoAlergia, 1, 1, 10));
        
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoAlergia.obtenerCantidadDeBotones(); i++)    
            this.panelTipoAlergia.obtenerBoton(i).addActionListener(this);
        
    }
    
    private void crearPanelHiedraVenenosa() {
        
        this.panelHiedraVenenosa = new Etiquetas();
        
        this.panelHiedraVenenosa.
                crearEtiquetasConURL("BaseDeDatos\\Alergia\\Hiedra venenosa.txt");
        
        int numEtiquetas = this.panelHiedraVenenosa.obtenerNumEtiquetas();
        this.panelHiedraVenenosa.generarPanel(new GridLayout(numEtiquetas, 1));
        
    }
    
    private void crearPanelOcular() {
        
        this.panelOcular = new Etiquetas();
        
        this.panelOcular.crearEtiquetasConURL(
                "BaseDeDatos\\Alergia\\Ocular.txt");
        
        int numInstruccionesOcular = this.panelOcular.obtenerNumEtiquetas();
        this.panelOcular.generarPanel(
                new GridLayout(numInstruccionesOcular, 1));
        
    }
    
    private void removerInstrucciones() {
        
        for (int i = 0; i < this.getComponentCount(); i++) {
            
            
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        String botonEvento = e.getActionCommand();
        Etiquetas panelTemporal = null;
        
        if (botonEvento.equals("Hiedra venenosa")) {
            
            panelTemporal = this.panelHiedraVenenosa;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Latex")) {
            
            panelTemporal = this.panelLatex;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Tinta de pelo")) {
            
            panelTemporal = this.panelTintaPelo;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Alimentos")) {
            
        }
        
        if (botonEvento.equals("Ocular")) {
            
            panelTemporal = this.panelOcular;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Pasto")) {
            
            panelTemporal = this.panelPasto;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Animales")) {
            
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
