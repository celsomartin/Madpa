/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.paneles;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Celso
 */
public class Principal extends JPanel{
    
    private ArrayList<JButton> botones;
    private int numCol;
    private int numFil;
    
    public Principal(int numFil, int numCol) {
        this.numFil = numFil;
        this.numCol = numCol;
        intComponent();
    }

    private void intComponent() {
        GridLayout disMatricial = new GridLayout(this.numFil, this.numCol);
        this.setLayout(disMatricial);
        this.botones = new ArrayList<>();
        instanciarBotones();
        
    }
    private void instanciarBotones() {
        this.botones.add(new JButton("Picaduras/Mordeduras"));
        añadirBotonAlPanel();
        this.botones.add(new JButton("Quemaduras"));
        añadirBotonAlPanel();
        this.botones.add(new JButton("Heridas"));
        añadirBotonAlPanel();
        this.botones.add(new JButton("Alergias"));
        añadirBotonAlPanel();
        this.botones.add(new JButton("Electrocutaciones"));
        añadirBotonAlPanel();
        this.botones.add(new JButton("Fracturas"));
        añadirBotonAlPanel();
        this.botones.add(new JButton("Intoxicación"));
        añadirBotonAlPanel();
    }
    private void añadirBotonAlPanel() {
        this.add(this.botones.get(this.botones.size()-1));
    }
    public void añadirBoton(String text) {
        this.botones.add(new JButton(text));
        añadirBotonAlPanel();
    }
}
