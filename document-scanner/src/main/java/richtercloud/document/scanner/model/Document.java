/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.orientdb.document.scanner.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author richter
 */
public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    private Contact sender;
    private Date sent;
    private Date received;
    private String comment;

    protected Document() {
    }

    public Document(Contact sender, Date sent, Date received, String comment) {
        this.sender = sender;
        this.sent = sent;
        this.received = received;
        this.comment = comment;
    }

    /**
     * @return the sender
     */
    public Contact getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(Contact sender) {
        this.sender = sender;
    }

    /**
     * @return the sent
     */
    public Date getSent() {
        return sent;
    }

    /**
     * @param sent the sent to set
     */
    public void setSent(Date sent) {
        this.sent = sent;
    }

    /**
     * @return the received
     */
    public Date getReceived() {
        return received;
    }

    /**
     * @param received the received to set
     */
    public void setReceived(Date received) {
        this.received = received;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
