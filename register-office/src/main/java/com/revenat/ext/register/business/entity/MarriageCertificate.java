package com.revenat.ext.register.business.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Vitaliy Dragun
 */
@Table(name = "ro_marriage_certificate")
@Entity
@NamedQuery(
        name = MarriageCertificate.FIND_CERTIFICATE,
        query = "SELECT m FROM MarriageCertificate m " +
                "INNER JOIN m.husband h " +
                "INNER JOIN m.wife w " +
                "INNER JOIN m.husband.passports hp " +
                "INNER JOIN m.wife.passports wp " +
                "WHERE " +
                "h.firstName = :hFirstName AND " +
                "h.lastName = :hLastName AND " +
                "h.patronymic = :hPatronymic AND " +
                "hp.series = :hPassportSeries AND " +
                "hp.number = :hPassportNumber AND " +
                "w.firstName = :wFirstName AND " +
                "w.lastName = :wLastName AND " +
                "w.patronymic = :wPatronymic AND " +
                "wp.series = :wPassportSeries AND " +
                "wp.number = :wPassportNumber AND " +
                "m.number = :certificateNumber AND " +
                "m.issueDate = :certificateIssueDate"
)
public class MarriageCertificate {

    public static final String FIND_CERTIFICATE = "MarriageCertificate.findCertificate";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marriage_certificate_id")
    private Long marriageCertificateId;

    @Column(name = "certificate_number")
    private String number;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonMale husband;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonFemale wife;

    @Column(name = "active")
    private boolean active;

    @Column(name = "end_date")
    private LocalDate endDate;

    public Long getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(final Long marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(final LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    public PersonMale getHusband() {
        return husband;
    }

    public void setHusband(final PersonMale husband) {
        this.husband = husband;
    }

    public PersonFemale getWife() {
        return wife;
    }

    public void setWife(final PersonFemale wife) {
        this.wife = wife;
    }
}
