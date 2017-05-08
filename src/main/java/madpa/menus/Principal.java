/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.menus;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import madpa.paneles.Principal;
/**
 *
 * @author Celso
 */
public class Principal extends JFrame{
    
    private Principal panelPrincipal;
    
    public MenuPrincipal() {
        initComponent();
    }

    private void initComponent() {
        
        instanciarPaneles();
        agregarPanelesAlMenu();
        
        this.setSize(500, 500);
        this.setVisible(true);
    }
    private void instanciarPaneles() {
        this.panelPrincipal = new Principal(3, 3);
    }
    public void agregarPanelesAlMenu() {
        this.add(this.panelPrincipal, BorderLayout.CENTER);
        
    }
}
