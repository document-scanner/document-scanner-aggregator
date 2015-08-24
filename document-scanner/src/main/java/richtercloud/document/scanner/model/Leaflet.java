/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author richter
 */
@Entity
public class Leaflet extends AbstractDocument {
    private static final long serialVersionUID = 1L;

    protected Leaflet() {
    }

    public Leaflet(Date date, Date receptionDate, Location originalLocation, boolean originalLost, Long id, Company contact) {
        super(date, receptionDate, originalLocation, originalLost, id, contact);
    }
    
}
