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
    private Etiquetas panelSeñaladorAcc;
    
    public Principal() { initComponent(); }

    private void initComponent() {
        setLookAndFeel();
//        
//        crearPanelSeñaladorAcc();
//        this.add(this.panelSeñaladorAcc, BorderLayout.BEFORE_FIRST_LINE);
        
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
    
    private void crearPanelSeñaladorAcc() {
        
        this.panelSeñaladorAcc = new Etiquetas();
        
        this.panelSeñaladorAcc.añadirEtiqueta("Tipo Accidente: ");
        this.panelSeñaladorAcc.generarPanel(new FlowLayout());
        
    }
    
    private void crearPanelSaludo() {
        
        this.panelSaludo = new Etiquetas();
        
        this.panelSaludo.añadirEtiqueta("Bienvenido", SwingConstants.CENTER);
        this.panelSaludo.añadirEtiqueta(
                "Por favor, seleccione el tipo de accidente"
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
        
            int numTipoAccidente = this.panelTipoAccidente.obtCantBotones();
            this.panelTipoAccidente.generarPanel(new FlowLayout());
            
            
        } catch (IOException errorES) {
            
            ErrorGestionArchivoException.lanzarMensaje();
            
        }
        
        
        
    }
    
    private void crearPanelBarraHerramientas() {
        
        this.panelBarraHerramientas = new BarraDeHerramientas();
        
        this.panelBarraHerramientas.añadirMenu("Inicio");
        this.panelBarraHerramientas.añadirMenu("Consejos");
        
        this.panelBarraHerramientas.añadirItem("Botiquin", "Inicio");
        this.panelBarraHerramientas.añadirItem("Sintomas", "Inicio");
        this.panelBarraHerramientas.añadirItem("Recomendaciones", "Inicio");
        this.panelBarraHerramientas.añadirItem("Signos vitales", "Inicio");
        
        this.panelBarraHerramientas.añadirItem("Evitar Accidentes", "Consejos");
        this.panelBarraHerramientas.añadirItem("Tomar pulsos", "Consejos");
        
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
            
            Herida herida = new Herida(this);
            
        }
        
        if (botonEvento.equals("Alergia")) {
            
            Alergia alergia = new Alergia(this);

        }
        
        if (botonEvento.equals("Fractura")) {
            
            Fractura fractura = new Fractura(this);
                
        }
        
        if (botonEvento.equals("Quemadura")) {
            
            Quemadura quemadura = new Quemadura(this);
            
        }
        
        if (botonEvento.equals("Electrocucion")) {
            
            Electrocucion electrocucion = new Electrocucion(this);
              
        }
        
        if (botonEvento.equals("Intoxicacion")) {
            
            Intoxicacion intox = new Intoxicacion(this);
              
        }
        
        if (botonEvento.equals("Picadura")) {
            
            Picadura picadura = new Picadura(this);
                
        }
        
        if (botonEvento.equals("Mordedura")) {
            
            Mordedura mordedura = new Mordedura(this);
              
        }
        
        if (botonEvento.equals("Lesion")) {
            
            Lesion lesion = new Lesion(this);
                
        }
        
        //Opciones de la barra de herramientas
        if (botonEvento.equals("Botiquin")) {
            
            Botiquin botiquin = new Botiquin(this);
            
        }
        
        if (botonEvento.equals("Sintomas")) {
            
            
            
        }
        
    }
}
