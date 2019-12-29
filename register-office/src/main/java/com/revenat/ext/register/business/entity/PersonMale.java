package com.revenat.ext.register.business.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "husband")
    private List<MarriageCertificate> marriageCertificates;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "father")
    private List<BirthCertificate> birthCertificates;

    public List<MarriageCertificate> getMarriageCertificates() {
        return marriageCertificates;
    }

    public void setMarriageCertificates(final List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(final List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }
}
