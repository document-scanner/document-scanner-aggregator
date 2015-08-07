/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.orientdb.document.scanner.model;

import java.io.Serializable;

/**
 *
 * @author richter
 */
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Address address;

    protected Contact() {
    }

    public Contact(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
