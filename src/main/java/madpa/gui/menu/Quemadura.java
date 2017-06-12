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
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

import madpa.gui.panelbasico.Botones;
import madpa.gui.panelbasico.Etiquetas;
import madpa.gui.especificacion.accidente.QuemaduraPrimerGrado;
import madpa.gui.especificacion.accidente.QuemaduraElectrica;
import madpa.gui.especificacion.accidente.QuemaduraPorFrio;
import madpa.gui.especificacion.accidente.QuemaduraPorSol;
import madpa.gui.especificacion.accidente.QuemaduraQuimica;
import madpa.gui.especificacion.accidente.QuemaduraSegundoGrado;
import madpa.gui.especificacion.accidente.QuemaduraTercerGrado;


/**
 *
 * @author Celso
 */
public class Quemadura extends JFrame implements ActionListener, WindowListener{
    
    private Botones panelTipoQuemadura;
    private Etiquetas panelDescripcionQuemadura;
    private FlowLayout distHorizontal;
    
    
    public Quemadura() {
        
        initComponent();
    }

    private void initComponent() {
        
        this.addWindowListener(this);
                
        this.panelTipoQuemadura = new Botones();
        this.panelDescripcionQuemadura = new Etiquetas();
        
        this.panelTipoQuemadura.añadirBoton("Primer Grado");
        this.panelTipoQuemadura.añadirBoton("Segundo Grado");
        this.panelTipoQuemadura.añadirBoton("Tercer Grado");
        this.panelTipoQuemadura.añadirBoton("Electrica");
        this.panelTipoQuemadura.añadirBoton("Por sol");
        this.panelTipoQuemadura.añadirBoton("Quimica");
        this.panelTipoQuemadura.añadirBoton("Congelacion");
        
        this.panelTipoQuemadura.establecerBotonesConTamañoPredeterminado(200, 50);
        
        this.panelTipoQuemadura.establecerColorDeFondo(Color.WHITE);
        
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        this.panelDescripcionQuemadura.añadirEtiqueta("Quemadura primer grado");
        
        this.panelDescripcionQuemadura.establecerColorDeFondo(Color.WHITE);
        
        this.panelDescripcionQuemadura.generarPanel(new GridLayout(this.panelTipoQuemadura.obtenerCantidadDeBotones(), 1, 1, 50));
        
        this.panelTipoQuemadura.generarPanel(new GridLayout(this.panelTipoQuemadura.obtenerCantidadDeBotones(), 1, 1, 10));
        
        this.distHorizontal = new FlowLayout();
        
        this.setLayout(this.distHorizontal);
        
        this.add(this.panelTipoQuemadura, BorderLayout.EAST);
        this.add(this.panelDescripcionQuemadura, BorderLayout.WEST);
        
        añadirListeners();
        
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(new Dimension(500, 500));
        this.setLocation(new Point(100, 100));
        this.setVisible(true);
    }
    
    private void añadirListeners() {
        for (int i = 0; i < this.panelTipoQuemadura.obtenerCantidadDeBotones(); i++) {
            
            this.panelTipoQuemadura.obtenerBoton(i).addActionListener(this);
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String botonEvento = e.getActionCommand();
        
        if (botonEvento.equals("Primer Grado")) {
            this.dispose();
            QuemaduraPrimerGrado primerGrado = new QuemaduraPrimerGrado();
        }
        
        if (botonEvento.equals("Segundo Grado")) {
            
            QuemaduraSegundoGrado segundoGrado = new QuemaduraSegundoGrado();
            
        }
        
        if (botonEvento.equals("Tercer Grado")) {
            
            QuemaduraTercerGrado tercerGrado = new QuemaduraTercerGrado();
            
        }
        
        if (botonEvento.equals("Electrica")) {
            
            QuemaduraElectrica electrica = new QuemaduraElectrica();
            
        }
        
        if (botonEvento.equals("Por sol")) {
            
            QuemaduraPorSol solar = new QuemaduraPorSol();
            
        }
        
        if (botonEvento.equals("Quimica")) {
            
            QuemaduraQuimica quimica = new QuemaduraQuimica();
            
        }
        
        if (botonEvento.equals("Congelacion")) {
            
            QuemaduraPorFrio porFrio = new QuemaduraPorFrio();
            
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
