/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.logica.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PanelImagen extends javax.swing.JPanel {
    public PanelImagen(){
        this.setSize(100,100);
        Icon imgBoton = new ImageIcon(getClass().getResource("/madpa/imagenes/Menu principal.jpg"));
    }
    @Override
    public void paintComponent (Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(this.getClass().getResource("/madpa/imagenes/Menu principal.jpg"));
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
        this.setOpaque(false);
        super.paintComponent(g);
    }
}
