 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.view.menu;

import madpa.logica.panelbasico.BarraDeHerramientas;
import madpa.logica.panelbasico.Botones;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import madpa.logica.excepcion.ErrorGestionArchivoException;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Principal extends JFrame implements ActionListener {
    
    private BarraDeHerramientas panelBarraHerramientas;
    private Botones panelTipoAccidente;
    private Etiquetas panelSaludo;
    private Etiquetas panelInf;
    private ImageIcon icono;
    
    public Principal() { initComponent(); }

    private void initComponent() {
        
        setLookAndFeel();
        
        crearIcono();
        this.setIconImage(this.icono.getImage());
        
        crearPanelInf();
        this.add(this.panelInf, BorderLayout.SOUTH);

        crearPanelBarraHerramientas();
        this.setJMenuBar(this.panelBarraHerramientas.obtenerJMenuBar());
        
        crearPanelSaludo();
        this.add(this.panelSaludo, BorderLayout.NORTH);
        
        crearPanelTipoAcc();
        this.getContentPane().add(this.panelTipoAccidente, BorderLayout.CENTER);
        
        añadirListeners();
        
        this.setTitle("Menu principal");
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(new Dimension(800, 600));
        this.setLocation(new Point(100, 100));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void crearPanelInf() {
        
        this.panelInf = new Etiquetas();
        
        String ruta = "BaseDeDatos\\No olvidar.txt";
        this.panelInf.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil = this.panelInf.obtNumEtiquetas();
        this.panelInf.generarPanel(new GridLayout(numFil, 1), Color.CYAN);
        
    }
    
    private void crearIcono() {
        
        String ruta = "BaseDeDatos\\Imagenes\\Icono menu principal.png";
        this.icono = new ImageIcon(ruta);
        
    }
    
    private void crearPanelSaludo() {
        
        this.panelSaludo = new Etiquetas();
        
        this.panelSaludo.añadirEtiqueta("Bienvenido", SwingConstants.CENTER);
        this.panelSaludo.añadirEtiqueta(
                "Por favor, seleccione un tipo de accidente"
                , SwingConstants.CENTER);
        this.panelSaludo.añadirEtiqueta(
                "Posteriormente, repita la misma accion"
                , SwingConstants.CENTER);
        
        int numFil = this.panelSaludo.obtNumEtiquetas();
        this.panelSaludo.generarPanel(new GridLayout(numFil, 1), Color.GREEN);
        
    }
    
    private void crearPanelTipoAcc() {
        
        this.panelTipoAccidente = new Botones();
        
        String ruta = "BaseDeDatos\\Componentes\\Botones\\Menu principal.txt";
        
        try {
            
            this.panelTipoAccidente.crearBotonesConURL(ruta);
            this.panelTipoAccidente.estabCursor(new Cursor(Cursor.HAND_CURSOR));
        
            this.panelTipoAccidente.generarPanel(new FlowLayout());
            
        } catch (IOException errorES) {
            
            ErrorGestionArchivoException.lanzarMensaje();
            
        }
        
        
        
    }
    
    private void crearPanelBarraHerramientas() {
        
        this.panelBarraHerramientas = new BarraDeHerramientas();
        
        this.panelBarraHerramientas.añadirMenu("Inicio");
        this.panelBarraHerramientas.añadirMenu("Consejos");
        
        this.panelBarraHerramientas.añadirItem("Que debe contener un Botiquin", "Inicio");
        this.panelBarraHerramientas.añadirItem("Sintomas de enfermedades comunes", "Inicio");
        this.panelBarraHerramientas.añadirItem("Donde se puede tomar los signos vitales", "Inicio");
        
        this.panelBarraHerramientas.añadirItem("Como evitar algunos accidentes", "Consejos");
        
        this.panelBarraHerramientas.establecerColorDeFondoBarra(Color.WHITE);
        this.panelBarraHerramientas.establecerColorDeFondoItems(Color.WHITE);
        this.panelBarraHerramientas.establecerColorDeFondoMenus(Color.WHITE);
        this.panelBarraHerramientas.establecerColorDeFondoPanel(Color.WHITE);

        this.panelBarraHerramientas.generarPanel();
    }
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoAccidente.obtCantBotones(); i++)
            this.panelTipoAccidente.obtenerBoton(i).addActionListener(this);
            
        for (int i = 0; i < this.panelBarraHerramientas.obtenerCantidadDeItems(); i++)
            this.panelBarraHerramientas.obtenerItem(i).addActionListener(this);
    }
    
    private void setLookAndFeel() {
        try {
            
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error"
                    + ", favor de cerrar y abrir nuevamente la aplicacion");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        //Botones del menu principal
        if (botonEvento.equals("Herida")) {
            
            Herida herida = new Herida(this, this.icono);
            
        }
        
        if (botonEvento.equals("Alergia")) {
            
            Alergia alergia = new Alergia(this, this.icono);

        }
        
        if (botonEvento.equals("Fractura")) {
            
            Fractura fractura = new Fractura(this, this.icono);
                
        }

        
        if (botonEvento.equals("Intoxicacion")) {
            
            Intoxicacion intox = new Intoxicacion(this, this.icono);
              
        }
        
        if (botonEvento.equals("Picadura")) {
            
            Picadura picadura = new Picadura(this, this.icono);
                
        }
        
        if (botonEvento.equals("Mordedura")) {
            
            Mordedura mordedura = new Mordedura(this, this.icono);
              
        }
        
        if (botonEvento.equals("Lesion")) {
            
            Lesion lesion = new Lesion(this, this.icono);
                
        }
        
        //Opciones de la barra de herramientas
        if (botonEvento.equals("Que debe contener un Botiquin")) {
            
            Botiquin botiquin = new Botiquin(this, this.icono);
            
        }
        
        if (botonEvento.equals("Sintomas de enfermedades comunes")) {
            
            Sintomas sint = new Sintomas(this, this.icono);
            
        }
        
        if (botonEvento.equals("Como evitar algunos accidentes")) {
            
            EvitarAccidente evitAcc = new EvitarAccidente(this, this.icono);
            
        }
        
        if (botonEvento.equals("Donde se puede tomar los signos vitales")) {
            
            SignosVitales sigVit = new SignosVitales(this, this.icono);
            
        }
        
    }
}
