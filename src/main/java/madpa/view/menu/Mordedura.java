
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
public class Mordedura extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoMordedura;
    private JFrame ventPrin;
    private Etiquetas panelPerro;
    private Etiquetas panelMurcielago;
    private Etiquetas panelRaton;
    private Etiquetas panelSerpiente;
    private ArrayList<Etiquetas> instAñad;
    
    public Mordedura(JFrame ventPrin, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.instAñad= new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent();
        
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoMordedura();
        this.add(this.panelTipoMordedura, BorderLayout.NORTH);
        
        crearPanelSerpiente();
        this.panelSerpiente.setVisible(false);
        
        crearPanelRaton();
        this.panelRaton.setVisible(false);
        
        crearPanelMurcielago();
        this.panelMurcielago.setVisible(false);
        
        crearPanelPerro();
        this.panelPerro.setVisible(false);   
        
       // int numFil = this.panelTipoMordedura.obtCantBotones();       
        añadirListeners();       
        this.setTitle("Mordedura");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
     private void crearPanelTipoMordedura() {
        this.panelTipoMordedura = new Botones();
        
        this.panelTipoMordedura.añadirBoton("Perro");
        this.panelTipoMordedura.añadirBoton("Raton");
        this.panelTipoMordedura.añadirBoton("Serpiente");
        this.panelTipoMordedura.añadirBoton("Murcielago");
             
        this.panelTipoMordedura.generarPanel(new FlowLayout());
        
    }
    
    private void crearPanelSerpiente(){
        this.panelSerpiente=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Mordedura\\Serpiente.txt";
        this.panelSerpiente.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelSerpiente.obtNumEtiquetas();
        this.panelSerpiente.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelRaton(){
        this.panelRaton=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Mordedura\\Raton.txt";
        this.panelRaton.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelRaton.obtNumEtiquetas();
        this.panelRaton.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelMurcielago(){
        this.panelMurcielago=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Mordedura\\Murcielago.txt";
        this.panelMurcielago.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelMurcielago.obtNumEtiquetas();
        this.panelMurcielago.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelPerro(){
        this.panelPerro=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Mordedura\\Perro.txt";
        this.panelPerro.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelPerro.obtNumEtiquetas();
        this.panelPerro.generarPanel(new GridLayout(numFil,1));
    }
    
    
    private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoMordedura.obtCantBotones(); i++) {
            
            this.panelTipoMordedura.obtenerBoton(i).addActionListener(this);
            
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
        
         
        if (botonEvento.equals("Perro")) {
         panelTemporal = this.panelPerro;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);    
            
        }
        
        if (botonEvento.equals("Raton")) {
             panelTemporal = this.panelRaton;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Serpiente")) {
             panelTemporal = this.panelSerpiente;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Murcielago")) {
             panelTemporal = this.panelMurcielago;
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