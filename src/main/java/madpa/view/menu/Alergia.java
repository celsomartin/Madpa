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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.excepcion.ErrorGestionArchivoException;
import madpa.logica.panelbasico.Botones;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Alergia extends JFrame implements WindowListener, ActionListener {
    
    private Botones panelTipoAlergia;
    private Etiquetas panelSup;
    private Etiquetas panelHiedraVenenosa;
    private Etiquetas panelPasto;
    private Etiquetas panelOcular;
    private Etiquetas panelTintaPelo;
    private Etiquetas panelLatex;
    private ArrayList<Etiquetas> instAñad;
    private JFrame ventPrin;
    
    public Alergia(JFrame ventPrin) {
        this.instAñad = new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoAlergia();
        this.add(this.panelTipoAlergia, BorderLayout.NORTH);
        
        crearPanelHiedraVenenosa();
        this.panelHiedraVenenosa.setVisible(false);
        
        crearPanelOcular();
        this.panelOcular.setVisible(false);
        
        crearPanelPasto(); 
        this.panelPasto.setVisible(false);
        
        crearPanelLatex();
        this.panelLatex.setVisible(false);
        
        crearPanelTintaPelo();
        this.panelTintaPelo.setVisible(false);
        
        añadirListeners();
        
        this.setTitle("Alergia");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
        
    }
    
    private void crearPanelTintaPelo() {
        
        this.panelTintaPelo = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Alergia\\Tinta de pelo.txt";
        
        this.panelTintaPelo.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelTintaPelo.obtNumEtiquetas();
        this.panelHiedraVenenosa.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelLatex() {
        
        this.panelLatex = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Alergia\\Latex.txt";
        this.panelLatex.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelLatex.obtNumEtiquetas();
        this.panelLatex.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelPasto() {
        
        this.panelPasto = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Alergia\\Pasto.txt";
        this.panelPasto.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelPasto.obtNumEtiquetas();
        this.panelPasto.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelTipoAlergia() {
        
        this.panelTipoAlergia = new Botones();
        
        String ruta = "BaseDeDatos\\Componentes\\Botones\\Menu alergia.txt";
        
        try {
            
            this.panelTipoAlergia.crearBotonesConURL(ruta);
            int numFil = this.panelTipoAlergia.obtCantBotones();
            this.panelTipoAlergia.generarPanel(new FlowLayout());
            
        } catch (IOException errorES) {
            
            ErrorGestionArchivoException.lanzarMensaje();
            
        }
        
        
        
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoAlergia.obtCantBotones(); i++)    
            this.panelTipoAlergia.obtenerBoton(i).addActionListener(this);
        
    }
    
    private void crearPanelHiedraVenenosa() {
        
        this.panelHiedraVenenosa = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Alergia\\Hiedra venenosa.txt";
        this.panelHiedraVenenosa.crearEtiquetasConURL(
                ruta, SwingConstants.CENTER);
        
        int numFil = this.panelHiedraVenenosa.obtNumEtiquetas();
        this.panelHiedraVenenosa.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelOcular() {
        
        this.panelOcular = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Alergia\\Ocular.txt"; 
        this.panelOcular.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelOcular.obtNumEtiquetas();
        this.panelOcular.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void removerInstruccion() {
        
        for (int i = 0; i < this.getContentPane().getComponentCount(); i++) {
            
            for (int j = 0; j < this.instAñad.size(); j++) {
                
                if (this.getContentPane().getComponent(i) == this.instAñad.get(j)) {
                    this.getContentPane().getComponent(i).setVisible(false);
                    this.getContentPane().remove(this.getContentPane().getComponent(i));
                    this.instAñad.clear();
                }
                
            }
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        String botonEvento = e.getActionCommand();
        Etiquetas panelTemporal = null;
        if (!this.instAñad.isEmpty()) {
            removerInstruccion();
        }
        
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
        
        this.instAñad.add(panelTemporal);
        
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        
        if (e.getWindow() == this) 
            this.setTitle("");
            
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
