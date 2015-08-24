/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.setter;

import javax.swing.JComponent;

/**
 * An interface to handle different setter methods of different
 * {@link JComponent} and pass the OCR result to them (always a {@code String}).
 * @author richter
 * @param <C>
 */
public interface ValueSetter<C extends JComponent> {
    
    void setValue(String value, C comp);
}
