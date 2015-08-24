/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.setter;

import javax.swing.JTextField;

/**
 *
 * @author richter
 */
public class TextFieldSetter implements ValueSetter<JTextField> {
    private final static TextFieldSetter instance = new TextFieldSetter();
    
    public static TextFieldSetter getInstance() {
        return instance;
    }

    public TextFieldSetter() {
    }

    @Override
    public void setValue(String value, JTextField comp) {
        comp.setText(value);
    }
    
}
