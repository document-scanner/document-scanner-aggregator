/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Collections;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

/**
 *
 * @author richter
 */
@Entity
public class Person extends Company {
    private static final long serialVersionUID = 1L;
    @ElementCollection
    private List<String> firstnames;
    @ElementCollection
    private List<String> lastnames;

    protected Person() {
    }

    public Person(Long id, List<String> firstnames, List<String> lastnames, String name, List<String> allNames, List<Address> addresses, List<EmailAddress> emails) {
        super(id, name, allNames, addresses, emails);
        this.firstnames = firstnames;
        this.lastnames = lastnames;
    }

    /**
     * @return the firstnames
     */
    public List<String> getFirstnames() {
        return Collections.unmodifiableList(this.firstnames);
    }

    /**
     * @param firstnames the firstnames to set
     */
    public void setFirstnames(List<String> firstnames) {
        this.firstnames = firstnames;
    }

    /**
     * @return the lastnames
     */
    public List<String> getLastnames() {
        return Collections.unmodifiableList(this.lastnames);
    }

    /**
     * @param lastnames the lastnames to set
     */
    public void setLastnames(List<String> lastnames) {
        this.lastnames = lastnames;
    }
}
