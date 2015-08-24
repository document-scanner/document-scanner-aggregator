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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 *
 * @author richter
 */
@Entity
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String name;
    @ElementCollection
    private List<String> allNames;
    /**
     * Multiple contacts can have the same address (shared office) and a contact
     * can have multiple addresses.
     */
    @ManyToMany
    private List<Address> addresses;
    /**
     * One {@code Company} can have multiple email addresses, but it's very
     * unlikely that two contacts share the same email address.
     */
    @OneToMany
    private List<EmailAddress> emails;

    protected Company() {
    }

    public Company(Long id, String name, List<String> allNames, List<Address> addresses, List<EmailAddress> emails) {
        this.id = id;
        this.name = name;
        this.allNames = allNames;
        this.addresses = addresses;
        this.emails = emails;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return Collections.unmodifiableList(this.addresses);
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the allNames
     */
    public List<String> getAllNames() {
        return Collections.unmodifiableList(this.allNames);
    }

    /**
     * @param allNames the allNames to set
     */
    public void setAllNames(List<String> allNames) {
        this.allNames = allNames;
    }

    /**
     * @return the emails
     */
    public List<EmailAddress> getEmails() {
        return Collections.unmodifiableList(this.emails);
    }

    /**
     * @param emails the emails to set
     */
    public void setEmails(List<EmailAddress> emails) {
        this.emails = emails;
    }
}
