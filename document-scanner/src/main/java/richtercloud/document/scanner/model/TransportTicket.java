/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author richter
 */
@Entity
public class TransportTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @ManyToOne
    private Company transportCompany;
    @ElementCollection
    private List<String> waypoints;

    protected TransportTicket() {
    }

    public TransportTicket(Company transportCompany, List<String> waypoints) {
        this.transportCompany = transportCompany;
        this.waypoints = waypoints;
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
     * @return the transportCompany
     */
    public Company getTransportCompany() {
        return this.transportCompany;
    }

    /**
     * @param transportCompany the transportCompany to set
     */
    public void setTransportCompany(Company transportCompany) {
        this.transportCompany = transportCompany;
    }

    /**
     * @return the waypoints
     */
    public List<String> getWaypoints() {
        return Collections.unmodifiableList(this.waypoints);
    }

    /**
     * @param waypoints the waypoints to set
     */
    public void setWaypoints(List<String> waypoints) {
        this.waypoints = waypoints;
    }
}
