 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.menu;

import madpa.gui.panelbasico.BarraDeHerramientas;
import madpa.gui.panelbasico.Botones;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import madpa.excepcion.MuchasVentanasException;

/**
 *
 * @author Celso
 */
public class Principal extends JFrame implements ActionListener {
    
    private BarraDeHerramientas panelBarraHerramientas;
    private Botones panelTipoAccidente;
    private ArrayList<JFrame> listaVentanasActivas;
    
    public Principal() { initComponent(); }

    private void initComponent() {
        
        this.listaVentanasActivas = new ArrayList<>();
        
        crearPanelBarraHerramientas();
        this.setJMenuBar(this.panelBarraHerramientas.obtenerJMenuBar());
        
        crearPanelBotones();
        this.add(this.panelTipoAccidente, BorderLayout.CENTER);
        
        añadirListeners();
        
        
        this.setTitle("Menu principal");
        this.getContentPane().setBackground(Color.WHITE);
        this.setMinimumSize(new Dimension(600, 400));
        this.setResizable(false);
        this.setLocation(new Point(100, 100));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.listaVentanasActivas.add(this);
        this.setVisible(true);
    }
    
    private void crearPanelBotones() {
        
        this.panelTipoAccidente = new Botones();
            
        this.panelTipoAccidente.añadirBoton("Herida");
        this.panelTipoAccidente.añadirBoton("Alergia");
        this.panelTipoAccidente.añadirBoton("Fractura");
        this.panelTipoAccidente.añadirBoton("Quemadura");
        this.panelTipoAccidente.añadirBoton("Electrocucion");
        this.panelTipoAccidente.añadirBoton("Intoxicacion");
        this.panelTipoAccidente.añadirBoton("Picadura");
        this.panelTipoAccidente.añadirBoton("Mordedura");
        this.panelTipoAccidente.añadirBoton("Lesion");
        
        this.panelTipoAccidente.establecerCursor(
                new Cursor(Cursor.HAND_CURSOR));
        
        int numTipoAccidente = 
                this.panelTipoAccidente.obtenerCantidadDeBotones() / 3;
        this.panelTipoAccidente.generarPanel(
                new GridLayout(numTipoAccidente, 3, 10, 10));
        
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
        
        for (int i = 0; i < this.panelTipoAccidente.obtenerCantidadDeBotones(); i++)
            this.panelTipoAccidente.obtenerBoton(i).addActionListener(this);
            
        for (int i = 0; i < this.panelBarraHerramientas.obtenerCantidadDeItems(); i++)
            this.panelBarraHerramientas.obtenerItem(i).addActionListener(this);
        
    }
    
    private boolean ventanaActiva(String tituloVentana) {
        
        JFrame ventanaTemporal;
        
        for (int i = 0; i < this.listaVentanasActivas.size(); i++) {

            ventanaTemporal = this.listaVentanasActivas.get(i);
            
            if (ventanaTemporal.getTitle().equals("")) {

                this.listaVentanasActivas.remove(ventanaTemporal);

            } else {

                if (ventanaTemporal.getTitle().equals(tituloVentana)) {

                    return true;

                }

            }

        }

        
        return false;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String botonEvento = e.getActionCommand();
        
        
        //Botones del menu principal
        if (botonEvento.equals("Herida")) {
            
            if (!ventanaActiva("Herida")) {
                
                Herida herida = new Herida();
                this.listaVentanasActivas.add(herida);
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
                
            }
            
        }
        
        if (botonEvento.equals("Alergia")) {
            
            if (!ventanaActiva("Alergia")) {
                
                Alergia alergia = new Alergia();
                this.listaVentanasActivas.add(alergia);
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
                
            }
        }
        
        if (botonEvento.equals("Fractura")) {
            
            if (!ventanaActiva("Fractura")) {
             
                Fractura fractura = new Fractura();
                this.listaVentanasActivas.add(fractura);
                
            } else{
                
                MuchasVentanasException.lanzarMensaje();
                
            }
        }
        
        if (botonEvento.equals("Quemadura")) {
            
            if (!ventanaActiva("Quemadura")) {
                
                Quemadura quemadura = new Quemadura();
                this.listaVentanasActivas.add(quemadura);
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
                
            }
            
        }
        
        if (botonEvento.equals("Electrocucion")) {
            
            if (!ventanaActiva("Electrocucion")) {
                
                Electrocucion electrocucion = new Electrocucion();
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
                
            }
            
        }
        
        if (botonEvento.equals("Intoxicacion")) {
            
            if (!ventanaActiva("Intoxicacion")) {
            
                Intoxicacion intoxicacion = new Intoxicacion();
                this.listaVentanasActivas.add(intoxicacion);
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
                
            }
        }
        
        if (botonEvento.equals("Picadura")) {
            
            if (!ventanaActiva("Picadura")) {
            
                Picadura picadura = new Picadura();
                this.listaVentanasActivas.add(picadura);
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
            }
        }
        
        if (botonEvento.equals("Mordedura")) {
            
            if (!ventanaActiva("Mordedura")) {
            
                Mordedura mordedura = new Mordedura();
                this.listaVentanasActivas.add(mordedura);
                
            } else {
            
                MuchasVentanasException.lanzarMensaje();
                
            }
        }
        
        if (botonEvento.equals("Lesion")) {
            
            if (!ventanaActiva("Lesion")) {
            
                Lesion lesion = new Lesion();
                this.listaVentanasActivas.add(lesion);
                
            } else{
                
                MuchasVentanasException.lanzarMensaje();
                
            }
        }
        
        //Opciones de la barra de herramientas
        if (botonEvento.equals("Botiquin")) {
            
            if (!ventanaActiva("Botiquin")) {
                
                Botiquin botiquin = new Botiquin();
                this.listaVentanasActivas.add(botiquin);
                
            } else {
                
                MuchasVentanasException.lanzarMensaje();
                
            }
            
        }
        
        if (botonEvento.equals("Sintomas")) {
            
            
            
        }
        
    }
}
