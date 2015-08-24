/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.setter;

import javax.swing.JSpinner;

/**
 *
 * @author richter
 */
public class SpinnerSetter implements ValueSetter<JSpinner> {
    private final static SpinnerSetter instance = new SpinnerSetter();
    
    public static SpinnerSetter getInstance() {
        return instance;
    }

    protected SpinnerSetter() {
    }

    @Override
    public void setValue(String value, JSpinner comp) {
        comp.setValue(value);
    }
    
}
