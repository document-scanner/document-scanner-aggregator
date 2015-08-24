/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author richter
 */
@Entity
public class Shipping extends CommunicationItem {
    private static final long serialVersionUID = 1L;
    @ManyToMany(mappedBy = "shippings")
    private List<APackage> packages;

    protected Shipping() {
    }

    public Shipping(List<APackage> packages, Long id, Company contact) {
        super(id, contact);
        this.packages = packages;
    }

    /**
     * @return the packages
     */
    public List<APackage> getPackages() {
        return Collections.unmodifiableList(this.packages);
    }

    /**
     * @param packages the packages to set
     */
    public void setPackages(List<APackage> packages) {
        this.packages = packages;
    }
}
