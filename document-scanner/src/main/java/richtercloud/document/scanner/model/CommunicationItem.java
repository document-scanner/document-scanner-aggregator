/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author richter
 */
@MappedSuperclass
public abstract class CommunicationItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @ManyToOne
    private Company contact;

    protected CommunicationItem() {
    }

    public CommunicationItem(Long id, Company contact) {
        this.id = id;
        this.contact = contact;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the contact
     */
    public Company getContact() {
        return this.contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Company contact) {
        this.contact = contact;
    }
}
