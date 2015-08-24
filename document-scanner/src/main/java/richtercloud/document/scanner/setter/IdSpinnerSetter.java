/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.setter;

import richtercloud.reflection.form.builder.jpa.IdPanel;

/**
 *
 * @author richter
 */
public class IdSpinnerSetter implements ValueSetter<IdPanel>{
    private final static IdSpinnerSetter instance = new IdSpinnerSetter();

    public static IdSpinnerSetter getInstance() {
        return instance;
    }

    protected IdSpinnerSetter() {
    }

    @Override
    public void setValue(String value, IdPanel comp) {
        comp.getIdSpinner().setValue(value);
    }
    
}
