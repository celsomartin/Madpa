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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.panelbasico.Botones;
import madpa.logica.panelbasico.Etiquetas;


public class EvitarAccidente extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelEvitarAccidente;
    private JFrame ventPrin;
    private Etiquetas panelTransito;
    private Etiquetas panelAhogamientoAdulto;
    private Etiquetas panelAhogamientoNiño;
    private Etiquetas panelAlergiaPolen;
    private Etiquetas panelArañaRincon;
    private Etiquetas panelFracturas;
    private Etiquetas panelHeridaCorte;
    private Etiquetas panelInfarto;  
    private ArrayList<Etiquetas> instAñad;
    
    
    public EvitarAccidente(JFrame ventPrin, ImageIcon icono){
        this.setIconImage(icono.getImage());
        this.instAñad= new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelEvitarAccidente();
        this.add(this.panelEvitarAccidente, BorderLayout.NORTH);
        
        crearPanelTransito();
        this.panelTransito.setVisible(false);
        
        crearPanelAhogamientoAdulto();
        this.panelAhogamientoAdulto.setVisible(false);
        
        crearPanelAhogamientoNiño();
        this.panelAhogamientoNiño.setVisible(false);
        
        crearPanelAlergiaPolen();
        this.panelAlergiaPolen.setVisible(false);
        
        crearPanelArañaRincon();
        this.panelArañaRincon.setVisible(false);
        
        crearPanelFracturas();
        this.panelFracturas.setVisible(false);
        
        crearPanelHeridaCorte();
        this.panelHeridaCorte.setVisible(false);
        
        crearPanelInfarto();
        this.panelInfarto.setVisible(false);
        
        añadirListeners();     
        
        this.setTitle("Evitar Accidente");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
    
    
    
       private void crearPanelTransito(){
        this.panelTransito=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Accidente de transito.txt";
        this.panelTransito.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelTransito.obtNumEtiquetas();
        this.panelTransito.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelAhogamientoAdulto(){
        this.panelAhogamientoAdulto=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Ahogamiento adulto.txt";
        this.panelAhogamientoAdulto.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelAhogamientoAdulto.obtNumEtiquetas();
        this.panelAhogamientoAdulto.generarPanel(new GridLayout(numFil,1));
    }   
    
    private void crearPanelAhogamientoNiño() {
        this.panelAhogamientoNiño=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Ahogamiento niño.txt";
        this.panelAhogamientoNiño.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelAhogamientoNiño.obtNumEtiquetas();
        this.panelAhogamientoNiño.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelAlergiaPolen(){
        this.panelAlergiaPolen=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Barra de herramientas\\Consejos\\evitar accidentes\\Alergia al polen.txt";
        this.panelAlergiaPolen.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelTransito.obtNumEtiquetas();
        this.panelAlergiaPolen.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelArañaRincon(){
        this.panelArañaRincon=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Araña de rincon.txt";
        this.panelArañaRincon.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelArañaRincon.obtNumEtiquetas();
        this.panelArañaRincon.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelFracturas(){
        this.panelFracturas=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Fracturas.txt";
        this.panelFracturas.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelFracturas.obtNumEtiquetas();
        this.panelFracturas.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelHeridaCorte(){
        this.panelHeridaCorte=new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Heridas corte.txt";
        this.panelHeridaCorte.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil= this.panelHeridaCorte.obtNumEtiquetas();
        this.panelHeridaCorte.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelInfarto(){
        this.panelInfarto=new Etiquetas();
        
        String ruta = "BaseDeDatos\\Barra de herramientas\\Consejos\\Evitar accidentes\\Infarto.txt";
        this.panelInfarto.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelInfarto.obtNumEtiquetas();
        this.panelInfarto.generarPanel(new GridLayout(numFil,1));
    }
    
     private void crearPanelEvitarAccidente() {
        
        this.panelEvitarAccidente = new Botones();
        
        this.panelEvitarAccidente.añadirBoton("Accidente transito");
        this.panelEvitarAccidente.añadirBoton("Ahogamiento adulto");
        this.panelEvitarAccidente.añadirBoton("Ahogamiento niño");
        this.panelEvitarAccidente.añadirBoton("Alergia polen");
        this.panelEvitarAccidente.añadirBoton("Araña rincon");
        this.panelEvitarAccidente.añadirBoton("Fracturas");
        
        this.panelEvitarAccidente.añadirBoton("Heridas corte");
        this.panelEvitarAccidente.añadirBoton("Infarto");
        
        this.panelEvitarAccidente.generarPanel(new FlowLayout());
        
    }
     
    private void añadirListeners() {

        for (int i = 0; i < this.panelEvitarAccidente.obtCantBotones(); i++)
            this.panelEvitarAccidente.obtenerBoton(i).addActionListener(this);

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
        Etiquetas panelTemporal=null;
        if(!this.instAñad.isEmpty()){
            removerInstruccion();
        }
        
        
        if (botonEvento.equals("Accidente transito")) {
             panelTemporal = this.panelTransito;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
       
        
        if (botonEvento.equals("Ahogamiento adulto")) {
             panelTemporal = this.panelAhogamientoAdulto;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Ahogamiento niño")) {
             panelTemporal = this.panelAhogamientoNiño;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Alergia polen")) {
             panelTemporal = this.panelAlergiaPolen;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Araña rincon")) {
             panelTemporal = this.panelArañaRincon;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Fracturas")) {
             panelTemporal = this.panelFracturas;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
       
        
        if (botonEvento.equals("Heridas corte")) {
             panelTemporal = this.panelAhogamientoAdulto;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Infarto")) {
             panelTemporal = this.panelInfarto;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        this.instAñad.add(panelTemporal);
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