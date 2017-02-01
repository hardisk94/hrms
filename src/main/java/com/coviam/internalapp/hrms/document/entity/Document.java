package com.coviam.internalapp.hrms.document.entity;

/**
 * Created by shailaja on 25/01/17.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="document_gen")

public class Document implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    @Column(name="document_gen_id")
    private String docId;
    @Column(name="document_image")
    private String docImgUrl;
    @Column(name="document_cin")
    private String docCin;
    @Column(name="document_body",columnDefinition="TEXT")
    private String docBody;
    @Column(name="document_footer",columnDefinition="TEXT")
    private String docFooter;
    @Column(name="document_name")
    private String docName;
    @Column(name="customer_id")
    private String customerId;


    public Document() {
    }

    public Document(String docId, String docImgUrl, String docCin, String docBody, String docFooter, String docName, String customerId){
        this.docId=docId;
        this.docImgUrl=docImgUrl;
        this.docCin=docCin;
        this.docBody=docBody;
        this.docFooter=docFooter;
        this.docName=docName;
        this.customerId=customerId;
    }

    public String getdocId() {
        return docId;
    }
    public void setdocId(String docId) {
        this.docId = docId;
    }

    public String getdocImgUrl() {
        return docImgUrl;
    }
    public void setdocImgUrl(String docImgUrl) {
        this.docImgUrl = docImgUrl;
    }

    public String getdocCin() {
        return docCin;
    }
    public void setdocCin(String docCin) {
        this.docCin = docCin;
    }

    public String getdocBody() {
        return docBody;
    }
    public void setdocBody(String docBody) {
        this.docBody = docBody;
    }

    public String getdocFooter() {
        return docFooter;
    }
    public void setdocFooter(String docFooter) {
        this.docFooter = docFooter;
    }

    public String getdocName() {
        return docName;
    }
    public void setdocName(String docName) {
        this.docName = docName;
    }

    public String getcustomerId() {
        return customerId;
    }
    public void setcustomerId(String customerId) {
        this.customerId = customerId;
    }

}