package madpa.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.panelbasico.Botones;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Intoxicacion extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoIntox;
    private JFrame ventPrin;
    private Etiquetas panelAlcoholica;
    private Etiquetas panelHongos;
    private Etiquetas panelInsecticida;
    private Etiquetas panelDrogas;
    private Etiquetas panelMonoxidoCarbono;
    private ArrayList<Etiquetas> instAñad;
    

    public Intoxicacion(JFrame ventPrin, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.instAñad= new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoIntox();
        this.add(this.panelTipoIntox, BorderLayout.NORTH);
        
        crearPanelAlcoholica();
        this.panelAlcoholica.setVisible(false);
        
        crearPanelHongos();
        this.panelHongos.setVisible(false);
        
        crearPanelInsecticida();
        this.panelInsecticida.setVisible(false);
        
        crearPanelDrogas();
        this.panelDrogas.setVisible(false);
        
        crearPanelMonoxidoCarbono();
        this.panelMonoxidoCarbono.setVisible(false);
        
        añadirListeners();     
        this.setTitle("Intoxicacion");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
      private void crearPanelMonoxidoCarbono(){
        this.panelMonoxidoCarbono=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Intoxicacion\\Monoxido de carbono.txt";
        this.panelMonoxidoCarbono.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelMonoxidoCarbono.obtNumEtiquetas();
        this.panelMonoxidoCarbono.generarPanel(new GridLayout(numFil,1));
    }
    
    
    
      private void crearPanelDrogas(){
        this.panelDrogas=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Intoxicacion\\Sobre dosis de drogas.txt";
        this.panelDrogas.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelDrogas.obtNumEtiquetas();
        this.panelDrogas.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelInsecticida(){
        this.panelInsecticida=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Intoxicacion\\Insecticida.txt";
        this.panelInsecticida.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelInsecticida.obtNumEtiquetas();
        this.panelInsecticida.generarPanel(new GridLayout(numFil,1));
    }
    
    
    
    
    
      private void crearPanelHongos(){
        this.panelHongos=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Intoxicacion\\Hongos.txt";
        this.panelHongos.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelHongos.obtNumEtiquetas();
        this.panelHongos.generarPanel(new GridLayout(numFil,1));
    }
    
    
    
    
    private void crearPanelAlcoholica(){
        this.panelAlcoholica=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Intoxicacion\\Alcoholica.txt";
        this.panelAlcoholica.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelAlcoholica.obtNumEtiquetas();
        this.panelAlcoholica.generarPanel(new GridLayout(numFil,1));
    }
    
    
    
    private void crearPanelTipoIntox() {
        
        this.panelTipoIntox = new Botones();
        
        this.panelTipoIntox.añadirBoton("Alcohol");
        this.panelTipoIntox.añadirBoton("Monoxido de Carbono(CO)");
        this.panelTipoIntox.añadirBoton("Hongo o setas");
        this.panelTipoIntox.añadirBoton("Insecticidas");
        this.panelTipoIntox.añadirBoton("Sobre dosis de droga");
        
        this.panelTipoIntox.generarPanel(new FlowLayout());
        
    }
            
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoIntox.obtCantBotones(); i++) {
            
            this.panelTipoIntox.obtenerBoton(i).addActionListener(this);
            
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
        
        
        if (botonEvento.equals("Alcohol")) {
             panelTemporal = this.panelAlcoholica;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
       
        
        if (botonEvento.equals("Monoxido de Carbono(CO)")) {
             panelTemporal = this.panelMonoxidoCarbono;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Hongo o setas")) {
             panelTemporal = this.panelHongos;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Insecticidas")) {
             panelTemporal = this.panelInsecticida;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Sobre dosis de droga")) {
             panelTemporal = this.panelDrogas;
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