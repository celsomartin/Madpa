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

/**
 *
 * @author Celso
 */
public class Fractura extends JFrame implements WindowListener,ActionListener{
    
    private JFrame ventPrin;
    private Botones panelTipoFracturas;
    private Etiquetas panelFracturaCompuesta;
    private Etiquetas panelFracturaBrazo;
    private Etiquetas panelFracturaCraneo;
    private Etiquetas panelFracturaNasal;
    private ArrayList<Etiquetas> instAñad;
    
    public Fractura(JFrame ventPrin, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.instAñad= new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
          crearPanelTipoFracturas();
        this.add(this.panelTipoFracturas, BorderLayout.NORTH);
        
        crearPanelFracturaBrazo();
        this.panelFracturaBrazo.setVisible(false);
        
        crearPanelFracturaCraneo();
        this.panelFracturaCraneo.setVisible(false);
        
        crearPanelFracturaNasal();
        this.panelFracturaNasal.setVisible(false);
        
        crearPanelFracturaCompuesta();
        this.panelFracturaCompuesta.setVisible(false);
        
        añadirListeners(); 
        this.setTitle("Fractura");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
    private void crearPanelFracturaCompuesta(){
        this.panelFracturaCompuesta=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Fracturas\\Compuesta.txt";
        this.panelFracturaCompuesta.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelFracturaCompuesta.obtNumEtiquetas();
        this.panelFracturaCompuesta.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelFracturaBrazo(){
        this.panelFracturaBrazo=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Fracturas\\Brazo.txt";
        this.panelFracturaBrazo.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelFracturaBrazo.obtNumEtiquetas();
        this.panelFracturaBrazo.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelFracturaCraneo(){
        this.panelFracturaCraneo=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Fracturas\\Craneo.txt";
        this.panelFracturaCraneo.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelFracturaCraneo.obtNumEtiquetas();
        this.panelFracturaCraneo.generarPanel(new GridLayout(numFil,1));
    }
     
    private void crearPanelFracturaNasal(){
        this.panelFracturaNasal=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Fracturas\\Nasal.txt";
        this.panelFracturaNasal.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelFracturaNasal.obtNumEtiquetas();
        this.panelFracturaNasal.generarPanel(new GridLayout(numFil,1));
    }
      
    private void crearPanelTipoFracturas() {
        
        this.panelTipoFracturas = new Botones();
        
        this.panelTipoFracturas.añadirBoton("Fractura compuesta");
        this.panelTipoFracturas.añadirBoton("Fractura brazo");
        this.panelTipoFracturas.añadirBoton("Fractura craneo");
        this.panelTipoFracturas.añadirBoton("Fractura nasal");   
        
        this.panelTipoFracturas.generarPanel(new FlowLayout());
        
    }
     
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoFracturas.obtCantBotones(); i++) {
            
            this.panelTipoFracturas.obtenerBoton(i).addActionListener(this);
            
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
        
        
        if (botonEvento.equals("Fractura compuesta")) {
             panelTemporal = this.panelFracturaCompuesta;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
       
        
        if (botonEvento.equals("Fractura brazo")) {
             panelTemporal = this.panelFracturaBrazo;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Fractura craneo")) {
             panelTemporal = this.panelFracturaCraneo;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Fractura nasal")) {
             panelTemporal = this.panelFracturaNasal;
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