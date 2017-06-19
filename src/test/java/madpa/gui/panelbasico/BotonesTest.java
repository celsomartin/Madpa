/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.panelbasico;

import madpa.logica.panelbasico.Botones;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Celso
 */
public class BotonesTest {
    
    private Botones botones;
    
    public BotonesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.botones = new Botones();
        
    }
    
    @After
    public void tearDown() {
        
        this.botones = null;
        
    }

    /**
     * Test of establecerColorDeFondo method, of class Botones.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAñadirBoton() {
        
        this.botones.añadirBoton("");
        this.botones.añadirBoton(null);
        
    }
}
