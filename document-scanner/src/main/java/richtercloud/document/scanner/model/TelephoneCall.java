/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author richter
 */
@Entity
public class TelephoneCall extends CommunicationItem {
    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    private Date theBegin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date theEnd;
    private String transcription;

    protected TelephoneCall() {
    }

    public TelephoneCall(Date begin, Date end, String transcription, Long id, Company contact) {
        super(id, contact);
        this.theBegin = begin;
        this.theEnd = end;
        this.transcription = transcription;
    }

    /**
     * @return the theBegin
     */
    public Date getTheBegin() {
        return this.theBegin;
    }

    /**
     * @param theBegin the theBegin to set
     */
    public void setTheBegin(Date theBegin) {
        this.theBegin = theBegin;
    }

    /**
     * @return the theEnd
     */
    public Date getTheEnd() {
        return this.theEnd;
    }

    /**
     * @param theEnd the theEnd to set
     */
    public void setTheEnd(Date theEnd) {
        this.theEnd = theEnd;
    }

    /**
     * @return the transcription
     */
    public String getTranscription() {
        return this.transcription;
    }

    /**
     * @param transcription the transcription to set
     */
    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }
}
