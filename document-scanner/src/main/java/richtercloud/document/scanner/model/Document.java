/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.document.scanner.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import richtercloud.reflection.form.builder.components.annotations.OCRResult;
import richtercloud.reflection.form.builder.components.annotations.ScanResult;

/**
 *
 * @author richter
 */
@Entity
public class Document extends AbstractDocument {
    private static final long serialVersionUID = 1L;
    private String comment;
    private String identifier;
    @ScanResult
    private byte[] scanData;
    @OCRResult
    private String scanOCRText;
    @ManyToMany(mappedBy = "documents")
    private List<Payment> payments;

    protected Document() {
    }

    public Document(String comment, String identifier, byte[] scanData, String scanOCRText, List<Payment> payments, Date date, Date receptionDate, Location originalLocation, boolean originalLost, Long id, Company contact) {
        super(date, receptionDate, originalLocation, originalLost, id, contact);
        this.comment = comment;
        this.identifier = identifier;
        this.scanData = scanData;
        this.scanOCRText = scanOCRText;
        this.payments = payments;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return the scanData
     */
    public byte[] getScanData() {
        return this.scanData;
    }

    /**
     * @param scanData the scanData to set
     */
    public void setScanData(byte[] scanData) {
        this.scanData = scanData;
    }

    /**
     * @return the scanOCRText
     */
    public String getScanOCRText() {
        return this.scanOCRText;
    }

    /**
     * @param scanOCRText the scanOCRText to set
     */
    public void setScanOCRText(String scanOCRText) {
        this.scanOCRText = scanOCRText;
    }

    /**
     * @return the payments
     */
    public List<Payment> getPayments() {
        return Collections.unmodifiableList(this.payments);
    }

    /**
     * @param payments the payments to set
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
}
