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

/**
 *
 * @author richter
 */
@Entity
public class EmailAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String address;
    @ElementCollection
    private List<String> pgpKeyIds;

    protected EmailAddress() {
    }

    public EmailAddress(Long id, String address, List<String> pgpKeyIds) {
        this.id = id;
        this.address = address;
        this.pgpKeyIds = pgpKeyIds;
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
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the pgpKeyIds
     */
    public List<String> getPgpKeyIds() {
        return Collections.unmodifiableList(this.pgpKeyIds);
    }

    /**
     * @param pgpKeyIds the pgpKeyIds to set
     */
    public void setPgpKeyIds(List<String> pgpKeyIds) {
        this.pgpKeyIds = pgpKeyIds;
    }
}
