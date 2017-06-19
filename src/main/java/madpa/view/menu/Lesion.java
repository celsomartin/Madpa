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
public class Lesion extends JFrame implements WindowListener, ActionListener{
    
    private Botones panelTipoLesion;
    private JFrame ventPrin;
    private Etiquetas panelCalambres;
    private Etiquetas panelDislocacionHueso;
    private Etiquetas panelLuxacionMuscular;
    private Etiquetas panelRoturaLigamentos;
    private Etiquetas panelTorceduraPie;
     private ArrayList<Etiquetas> instAñad;
    
    public Lesion(JFrame ventPrin, ImageIcon icono) { 
        this.setIconImage(icono.getImage());
        this.instAñad= new ArrayList<>();
        this.ventPrin = ventPrin;
        initComponent(); 
    }
    
    private void initComponent() {
    
        this.ventPrin.setEnabled(false);
        this.addWindowListener(this);
        
        crearPanelTipoLesion();
        this.add(this.panelTipoLesion, BorderLayout.NORTH);
        
         crearPanelTorceduraPie();
        this.panelTorceduraPie.setVisible(false);
        
         crearPanelRoturaLigamentos();
        this.panelRoturaLigamentos.setVisible(false);
        
         crearPanelLuxacionMuscular();
        this.panelLuxacionMuscular.setVisible(false);
        
         crearPanelDislocacionHueso();
        this.panelDislocacionHueso.setVisible(false);
             
        crearPanelCalambres();
        this.panelCalambres.setVisible(false);
        
      
        añadirListeners();
        this.setTitle("Lesion");
        this.setLocation(new Point(200, 100));
        this.setSize(new Dimension(800, 600));
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
    
    }
    
       private void crearPanelCalambres(){
        this.panelCalambres=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Lesion\\Calambres.txt";
        this.panelCalambres.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelCalambres.obtNumEtiquetas();
        this.panelCalambres.generarPanel(new GridLayout(numFil,1));
    }
    
       private void crearPanelDislocacionHueso(){
        this.panelDislocacionHueso=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Lesion\\Dislocacion de un hueso.txt";
        this.panelDislocacionHueso.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelDislocacionHueso.obtNumEtiquetas();
        this.panelDislocacionHueso.generarPanel(new GridLayout(numFil,1));
    }
    
       private void crearPanelLuxacionMuscular(){
        this.panelLuxacionMuscular=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Lesion\\Luxacion muscular.txt";
        this.panelLuxacionMuscular.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelLuxacionMuscular.obtNumEtiquetas();
        this.panelLuxacionMuscular.generarPanel(new GridLayout(numFil,1));
    }
    
       private void crearPanelRoturaLigamentos(){
        this.panelRoturaLigamentos=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Lesion\\Rotura de ligamentos.txt";
        this.panelRoturaLigamentos.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelRoturaLigamentos.obtNumEtiquetas();
        this.panelRoturaLigamentos.generarPanel(new GridLayout(numFil,1));
    }
    
         private void crearPanelTorceduraPie(){
        this.panelTorceduraPie=new Etiquetas();
        
        String ruta ="BaseDeDatos\\Lesion\\Torcedura de pie.txt";
        this.panelTorceduraPie.crearEtiquetasConURL(ruta, SwingConstants.CENTER);
        
        int numFil=this.panelTorceduraPie.obtNumEtiquetas();
        this.panelTorceduraPie.generarPanel(new GridLayout(numFil,1));
    }
         
         
      private void crearPanelTipoLesion() {
        
        this.panelTipoLesion = new Botones();
        
        this.panelTipoLesion.añadirBoton("Calambres");
        this.panelTipoLesion.añadirBoton("Dislocacion hueso");
        this.panelTipoLesion.añadirBoton("Luxacion muscular");
        this.panelTipoLesion.añadirBoton("Rotura ligamentos");
        this.panelTipoLesion.añadirBoton("Torcedura de pie");   
        
        this.panelTipoLesion.generarPanel(new FlowLayout());
        
    }
      
     private void añadirListeners() {
        
        for (int i = 0; i < this.panelTipoLesion.obtCantBotones(); i++) {
            
            this.panelTipoLesion.obtenerBoton(i).addActionListener(this);
            
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
        if (botonEvento.equals("Calambres")) {
             panelTemporal = this.panelCalambres;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if(botonEvento.equals("Dislocacion hueso")){
             panelTemporal = this.panelDislocacionHueso;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if(botonEvento.equals("Luxacion muscular")){
             panelTemporal = this.panelLuxacionMuscular;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if(botonEvento.equals("Rotura ligamentos")){
             panelTemporal = this.panelRoturaLigamentos;
            this.add(panelTemporal, BorderLayout.CENTER);
            panelTemporal.setVisible(true);
        }
        
        if(botonEvento.equals("Torcedura de pie")){
             panelTemporal = this.panelTorceduraPie;
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