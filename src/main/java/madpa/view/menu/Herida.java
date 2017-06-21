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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.panelbasico.Etiquetas;
/**
 *
 * @author Celso
 */
public class Herida extends JFrame implements ActionListener, WindowListener{
    
    private Botones panelTipoHerida;
    private JFrame ventPrin;
    private Etiquetas panelAbrasivas;
    private Etiquetas panelBala;
    private Etiquetas panelContusas;
    private Etiquetas panelCortante;
    private Etiquetas panelPunzante;
    private ArrayList<Etiquetas> instAñad;
    
    public Herida(JFrame ventana, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.instAñad=new ArrayList<>();
        this.ventPrin = ventana;
        //this.ventPrin.setEnabled(false);
        initComponent();
    }
    
    private void initComponent() {

        this.addWindowListener(this);
        
        crearPanelPunzante();
        this.panelPunzante.setVisible(false);
        
        crearPanelCortante();
        this.panelCortante.setVisible(false);
        
        crearPanelContusas();
        this.panelContusas.setVisible(false);
        
        crearPanelBala();
        this.panelBala.setVisible(false);
        
        crearPanelAbrasivas();
        this.panelAbrasivas.setVisible(false);
                
        crearPanelTipoHerida();
        this.add(this.panelTipoHerida, BorderLayout.NORTH);
        
        añadirListeners();
        
        this.setTitle("Herida");
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(new Dimension(800, 600));
        this.setLocation(new Point(200, 100));
        this.setVisible(true);
    }
    
    private void crearPanelTipoHerida() {
        
        this.panelTipoHerida = new Botones();       
        this.panelTipoHerida.añadirBoton("Abrasivas");
        this.panelTipoHerida.añadirBoton("Bala");
        this.panelTipoHerida.añadirBoton("Contusas");
        this.panelTipoHerida.añadirBoton("Cortante");
        this.panelTipoHerida.añadirBoton("Punzante");
            
        
        int numTipoHerida = this.panelTipoHerida.obtCantBotones();
        this.panelTipoHerida.generarPanel(new FlowLayout());
        
    }
    
     private void crearPanelAbrasivas(){
        this.panelAbrasivas=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Herida\\Abrasivas.txt";
        this.panelAbrasivas.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelAbrasivas.obtNumEtiquetas();
        this.panelAbrasivas.generarPanel(new GridLayout(numFil,1));
    }
    
     private void crearPanelContusas(){
        this.panelContusas=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Herida\\Contusas.txt";
        this.panelContusas.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelContusas.obtNumEtiquetas();
        this.panelContusas.generarPanel(new GridLayout(numFil,1));
    }
    
     private void crearPanelBala(){
        this.panelBala=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Herida\\Bala.txt";
        this.panelBala.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelBala.obtNumEtiquetas();
        this.panelBala.generarPanel(new GridLayout(numFil,1));
    }
    
     private void crearPanelCortante(){
        this.panelCortante=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Herida\\Cortante.txt";
        this.panelCortante.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelCortante.obtNumEtiquetas();
        this.panelCortante.generarPanel(new GridLayout(numFil,1));
    }
    
     private void crearPanelPunzante(){
        this.panelPunzante=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Herida\\Punzante.txt";
        this.panelPunzante.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelPunzante.obtNumEtiquetas();
        this.panelPunzante.generarPanel(new GridLayout(numFil,1));
    }
    
    
    private void añadirListeners() {
        
        int numTipoHeridas = this.panelTipoHerida.obtCantBotones();
        
        for (int i = 0; i < numTipoHeridas; i++) {
            
            this.panelTipoHerida.obtenerBoton(i).addActionListener(this);
            
        }
        
        
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
         
        if (botonEvento.equals("Abrasivas")) {
            panelTemporal = this.panelAbrasivas;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);           
        }
        
        if (botonEvento.equals("Bala")) {
            panelTemporal = this.panelBala;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);           
        }
        
        if (botonEvento.equals("Contusas")) {
            panelTemporal = this.panelContusas;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);           
        }
        if (botonEvento.equals("Cortante")) {
            panelTemporal = this.panelCortante;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);           
        }
        if (botonEvento.equals("Punzante")) {
            panelTemporal = this.panelPunzante;
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