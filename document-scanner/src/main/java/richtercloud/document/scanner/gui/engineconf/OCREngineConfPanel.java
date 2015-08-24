/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.gui.engineconf;

import java.util.Properties;
import javax.swing.JPanel;
import richtercloud.document.scanner.ocr.OCREngine;

/**
 * allows management of (eventually completely) different configuration
 * directives and control of different types of {@link OCREngine}s.
 * 
 * Changes only need to be retained if {@link #save() } has been invoked,
 * otherwise the changes can be discarded or kept.
 * @author richter
 */
/*
internal implementation notes:
- needs to be an abstract class extending JPanel in order to be able to work
with instances (adding to container and components - there's no interface in the
JComponent hierarchy)
*/
public abstract class OCREngineConfPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    /**
     * get the instance of {@link OCREngine} this panel manages
     * @return 
     */
    public abstract OCREngine getOCREngine();
    
    /**
     * write the current changes from the panel's components to its properties
     * where they can be retrieved reliably
     * @param conf
     */
    public abstract void save(Properties conf);
    
    /**
     * 
     * @param conf 
     */
    public abstract void load(Properties conf);
}
