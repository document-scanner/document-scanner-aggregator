/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author richter
 */
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String street;
    private String number;
    private String region;
    private String city;
    private String country;
    private String additional;

    protected Address() {
    }

    public Address(Long id, String street, String number, String region, String city, String country) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.region = region;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the additional
     */
    public String getAdditional() {
        return this.additional;
    }

    /**
     * @param additional the additional to set
     */
    public void setAdditional(String additional) {
        this.additional = additional;
    }
}
