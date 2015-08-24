/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author richter
 */
@Entity
public class Employment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @ManyToOne
    private Company company;
    @Temporal(TemporalType.TIMESTAMP)
    private Date theStart;
    @Temporal(TemporalType.TIMESTAMP)
    private Date theEnd;

    protected Employment() {
    }

    public Employment(Long id, Company company, Date start, Date end) {
        this.id = id;
        this.company = company;
        this.theStart = start;
        this.theEnd = end;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the theStart
     */
    public Date getStart() {
        return this.theStart;
    }

    /**
     * @param start the theStart to set
     */
    public void setStart(Date start) {
        this.theStart = start;
    }

    /**
     * @return the theEnd
     */
    public Date getEnd() {
        return this.theEnd;
    }

    /**
     * @param end the theEnd to set
     */
    public void setEnd(Date end) {
        this.theEnd = end;
    }
    
}
