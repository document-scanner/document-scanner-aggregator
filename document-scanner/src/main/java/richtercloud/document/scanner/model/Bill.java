/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Currency;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 *
 * @author richter
 */
@Entity
public class Bill extends Document {
    private static final long serialVersionUID = 1L;
    private float amount;
    @Basic(optional = true)
    private Currency currency;

    protected Bill() {
    }

    public Bill(float amount, Currency currency, String comment, String identifier, byte[] scanData, String scanOCRText, List<Payment> payments, Date date, Date receptionDate, Location originalLocation, boolean originalLost, Long id, Company contact) {
        super(comment, identifier, scanData, scanOCRText, payments, date, receptionDate, originalLocation, originalLost, id, contact);
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return this.amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
