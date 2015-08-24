/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author richter
 */
@MappedSuperclass
public abstract class AbstractDocument extends CommunicationItem {
    private static final long serialVersionUID = 1L;
    /**
     * the date and time (timestamp) of the actual reception
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date received;
    /**
     * the data and time (timestamp) of the reception indicated on the document
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date receptionDate;
    @ManyToOne
    private Location originalLocation;
    private boolean originalLost;

    protected AbstractDocument() {
    }

    public AbstractDocument(Date received, Date receptionDate, Location originalLocation, boolean originalLost, Long id, Company contact) {
        super(id, contact);
        this.received = received;
        this.receptionDate = receptionDate;
        this.originalLocation = originalLocation;
        this.originalLost = originalLost;
    }

    /**
     * @return the received
     */
    public Date getReceived() {
        return this.received;
    }

    /**
     * @param date the received to set
     */
    public void setReceived(Date date) {
        this.received = date;
    }

    /**
     * @return the receptionDate
     */
    public Date getReceptionDate() {
        return this.receptionDate;
    }

    /**
     * @param receptionDate the receptionDate to set
     */
    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    /**
     * @return the originalLocation
     */
    public Location getOriginalLocation() {
        return this.originalLocation;
    }

    /**
     * @param originalLocation the originalLocation to set
     */
    public void setOriginalLocation(Location originalLocation) {
        this.originalLocation = originalLocation;
    }

    /**
     * @return the originalLost
     */
    public boolean isOriginalLost() {
        return this.originalLost;
    }

    /**
     * @param originalLost the originalLost to set
     */
    public void setOriginalLost(boolean originalLost) {
        this.originalLost = originalLost;
    }
}
