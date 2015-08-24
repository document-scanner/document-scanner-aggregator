/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author richter
 */
/*
internal implementation notes:
- name prefixed with A in order to avoid collision with java.lang.Package
*/
@Entity
public class APackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    /**
     * the date and time (timestamp) of the reception (time is optional, but
     * will be persisted when specified)
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date reception;
    /**
     * the date and time (timestamp) on the package (e.g. the sending time)
     * (time is optional, but will be persisted when specified)
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date theDate;
    /**
     * the date and time (timestamp) of the delivery (by the sender) (time is 
     * optional, but will be persisted when specified)
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date delivery;
    @ManyToMany
    private List<Shipping> shippings;

    protected APackage() {
    }

    public APackage(Long id, Date reception, Date date, Date delivery) {
        this.id = id;
        this.reception = reception;
        this.theDate = date;
        this.delivery = delivery;
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
     * @return the reception
     */
    public Date getReception() {
        return this.reception;
    }

    /**
     * @param reception the reception to set
     */
    public void setReception(Date reception) {
        this.reception = reception;
    }

    /**
     * @return the theDate
     */
    public Date getTheDate() {
        return this.theDate;
    }

    /**
     * @param theDate the theDate to set
     */
    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    /**
     * @return the delivery
     */
    public Date getDelivery() {
        return this.delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public List<Shipping> getShippings() {
        return Collections.unmodifiableList(this.shippings);
    }

    public void setShippings(List<Shipping> shippings) {
        this.shippings = shippings;
    }
}
