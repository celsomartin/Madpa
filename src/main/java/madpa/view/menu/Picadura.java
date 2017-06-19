package madpa.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import madpa.logica.panelbasico.Botones;
import madpa.logica.panelbasico.Etiquetas;

/**
 *
 * @author Celso
 */
public class Picadura extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoPic;
    private JFrame ventPrin;
    private Etiquetas panelAbeja;
    private Etiquetas panelArañaRincon;
    private Etiquetas panelAlacran;
    private Etiquetas panelGarrapata;
    private Etiquetas panelMedusa;
    private ArrayList<Etiquetas> instAñad;
    
    
    public Picadura(JFrame ventPrin, ImageIcon icono) { 
        this.setIconImage(icono.getImage());
        this.instAñad= new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent(); 
    }
    
    private void initComponent() {
        
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoPic();
        this.add(this.panelTipoPic, BorderLayout.NORTH);
        
        crearPanelAbeja();
        this.panelAbeja.setVisible(false);
        
        crearPanelAlacran();
        this.panelAlacran.setVisible(false);
        
        crearPanelArañaRincon();
        this.panelArañaRincon.setVisible(false);
        
        
        crearPanelGarrapata();
        this.panelGarrapata.setVisible(false);
        
        crearPanelMedusa();
        this.panelMedusa.setVisible(false);
        
        
        añadirListeners();
        
        this.setTitle("Picadura");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
    }
    
    private void crearPanelTipoPic() {
        
        this.panelTipoPic = new Botones();
        
        this.panelTipoPic.añadirBoton("Alacran");
        this.panelTipoPic.añadirBoton("Araña de rincon");
        this.panelTipoPic.añadirBoton("Abeja");
        this.panelTipoPic.añadirBoton("Medusa");
        this.panelTipoPic.añadirBoton("Garrapata");        
        
        this.panelTipoPic.generarPanel(new FlowLayout());
    }
    
    private void crearPanelAbeja(){
        this.panelAbeja=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Picadura\\Abeja.txt";
        this.panelAbeja.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelAbeja.obtNumEtiquetas();
        this.panelAbeja.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelAlacran(){
        this.panelAlacran=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Picadura\\Alacran.txt";
        this.panelAlacran.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelAlacran.obtNumEtiquetas();
        this.panelAlacran.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelArañaRincon(){
        this.panelArañaRincon=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Picadura\\Araña de rincon.txt";
        this.panelArañaRincon.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelArañaRincon.obtNumEtiquetas();
        this.panelArañaRincon.generarPanel(new GridLayout(numFil,1));
    }
    
    private void crearPanelGarrapata(){
        this.panelGarrapata=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Picadura\\Garrapata.txt";
        this.panelGarrapata.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelGarrapata.obtNumEtiquetas();
        this.panelGarrapata.generarPanel(new GridLayout(numFil,1));
    }
     
    private void crearPanelMedusa(){
        this.panelMedusa=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Picadura\\Medusa.txt";
        this.panelMedusa.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelMedusa.obtNumEtiquetas();
        this.panelMedusa.generarPanel(new GridLayout(numFil,1));
    }
    
    private void añadirListeners() {
        
        for(int i = 0; i < this.panelTipoPic.obtCantBotones(); i++) {
            
            this.panelTipoPic.obtenerBoton(i).addActionListener(this);
            
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
        
        if (botonEvento.equals("Araña de rincon")) {
            panelTemporal = this.panelArañaRincon;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Abeja")) {
            panelTemporal = this.panelAbeja;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Alacran")) {
            panelTemporal = this.panelAlacran;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
            
        }
        
        if (botonEvento.equals("Garrapata")) {
            panelTemporal = this.panelGarrapata;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if (botonEvento.equals("Medusa")) {
            panelTemporal = this.panelMedusa;
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
