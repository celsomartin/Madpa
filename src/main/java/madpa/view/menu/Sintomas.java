/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.excepcion.ErrorGestionArchivoException;
import madpa.logica.panelbasico.Botones;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Sintomas extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoSint;
    private JFrame ventPrin;
    private Etiquetas panelSup;
    private Etiquetas panelColera;
    private Etiquetas panelDengue;
    private Etiquetas panelHanta;
    private Etiquetas panelNeumonia;
    private Etiquetas panelRabia;
    private Etiquetas panelSida;
    private Etiquetas panelZika;
    private ArrayList<Etiquetas> instAñad;
    
    public Sintomas(JFrame ventPrin, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.instAñad = new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoSint();
        this.add(this.panelTipoSint, BorderLayout.NORTH);
        
        
        crearPanelColera();
        this.panelColera.setVisible(false);
        
        crearPanelDengue();
        this.panelDengue.setVisible(false);
        
        crearPanelHanta();
        this.panelHanta.setVisible(false);
        
        crearPanelNeumonia();
        this.panelNeumonia.setVisible(false);
        
        crearPanelRabia();
        this.panelRabia.setVisible(false);
        
        crearPanelSida();
        this.panelRabia.setVisible(false);
        
        crearPanelZika();
        this.panelZika.setVisible(false);
        
        añadirListeners();
        
        this.setTitle("Sintomas de enfermedades comunes");
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(new Dimension(800, 600));
        this.setLocation(new Point(200, 100));
        this.setVisible(true);
        
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoSint.obtCantBotones(); i++)
            this.panelTipoSint.obtenerBoton(i).addActionListener(this);
            
    }
    
    private void crearPanelColera() {
        
        this.panelColera = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Colera.txt";
        this.panelColera.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelColera.obtNumEtiquetas();
        this.panelColera.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelDengue() {
        
        this.panelDengue = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Dengue.txt";
        this.panelDengue.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelDengue.obtNumEtiquetas();
        this.panelDengue.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelHanta() {
        
        this.panelHanta = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Hanta.txt";
        this.panelHanta.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelHanta.obtNumEtiquetas();
        this.panelHanta.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelNeumonia() {
        
        this.panelNeumonia = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Neumonia.txt";
        this.panelNeumonia.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelNeumonia.obtNumEtiquetas();
        this.panelNeumonia.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelRabia() {
        
        this.panelRabia = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Rabia.txt";
        this.panelRabia.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelRabia.obtNumEtiquetas();
        this.panelRabia.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelSida() {
        
        this.panelSida = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Sida.txt";
        this.panelSida.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelSida.obtNumEtiquetas();
        this.panelSida.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelZika() {
        
        this.panelZika = new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas"
                + "\\Inicio\\Sintomas\\Zika.txt";
        this.panelZika.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelZika.obtNumEtiquetas();
        this.panelZika.generarPanel(new GridLayout(numFil, 1));
        
    }
    
    private void crearPanelSup() {
        
        this.panelSup = new Etiquetas();
        
        this.panelSup.añadirEtiqueta(
                "Por favor, seleccione un tipo de sintoma: ");
        
        this.panelSup.generarPanel(new FlowLayout(), Color.GREEN);
        
    }
    
    private void crearPanelTipoSint() {
        
        this.panelTipoSint = new Botones();
        
        String ruta = "BaseDeDatos\\Componentes\\Botones\\Sintomas.txt";
        
        try {
            
            this.panelTipoSint.crearBotonesConURL(ruta);
            
            this.panelTipoSint.generarPanel(new FlowLayout());
            
        } catch (IOException errorES) {
            
            ErrorGestionArchivoException.lanzarMensaje();
            
        }
        
    }
    
    private void removerInst() {
        
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
        Etiquetas panelTemp = null;
        if (!this.instAñad.isEmpty()) {
            removerInst();
        }
        
        if (botonEvento.equals("Colera")) {
            
            panelTemp = this.panelColera;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
        }
        
        if (botonEvento.equals("Dengue")) {
            
            panelTemp = this.panelDengue;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
            
        }
        
        if (botonEvento.equals("Hanta")) {
            panelTemp = this.panelHanta;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
            
        }
        
        if (botonEvento.equals("Neumonia")) {
            
            panelTemp = this.panelNeumonia;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
            
        }
        
        if (botonEvento.equals("Rabia")) {
            
            panelTemp = this.panelRabia;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
            
        }
        
        if (botonEvento.equals("Sida")) {
            
            panelTemp = this.panelSida;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
            
        }
        
        if (botonEvento.equals("Zika")) {
            
            panelTemp = this.panelZika;
            this.add(panelTemp, BorderLayout.CENTER);
            panelTemp.setVisible(true);
            
        }
        
        this.instAñad.add(panelTemp);
        
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
    
        if (e.getWindow() == this) {
            
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
