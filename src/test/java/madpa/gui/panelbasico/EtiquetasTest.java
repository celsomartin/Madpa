/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madpa.gui.panelbasico;

import madpa.logica.panelbasico.Etiquetas;
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
public class EtiquetasTest {
    
    private Etiquetas etiqueta;
    
    public EtiquetasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.etiqueta = new Etiquetas();
        
    }
    
    @After
    public void tearDown() {
        
        this.etiqueta = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    @Test(expected = IllegalArgumentException.class)
    public void testGenerarPanel() {
        
        this.etiqueta.añadirEtiqueta("Etiqueta 1");
        this.etiqueta.añadirEtiqueta("Etiqueta 2");
        
        this.etiqueta.generarPanel(null);
        
    }
}
