/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.gui.storageconf;

import java.util.Properties;
import javax.swing.JPanel;
import richtercloud.document.scanner.storage.Storage;

/**
 *
 * @author richter
 */
public abstract class StorageConfPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    
    public abstract Storage getStorage();
    
    public abstract void save(Properties conf);
    
    public abstract void load(Properties conf);
}
