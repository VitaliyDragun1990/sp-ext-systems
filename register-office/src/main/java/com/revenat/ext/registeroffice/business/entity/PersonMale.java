package com.revenat.ext.registeroffice.business.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {

//    private List<MarriageCertificate> marriageCertificates;
//
//    private List<BirthCertificate> birthCertificates;
//
//    public List<MarriageCertificate> getMarriageCertificates() {
//        return marriageCertificates;
//    }
//
//    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
//        this.marriageCertificates = marriageCertificates;
//    }
//
//    public List<BirthCertificate> getBirthCertificates() {
//        return birthCertificates;
//    }
//
//    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
//        this.birthCertificates = birthCertificates;
//    }
}
