package com.revenat.ext.register.business.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Vitaliy Dragun
 */
public class MarriageRequest implements Serializable {

    private String husbandSureName;

    private String husbandGivenName;

    private String husbandPatronymic;

    private LocalDate husbandDateOfBirth;

    private String husbandPassportSeries;

    private String husbandPassportNumber;

    private LocalDate husbandPassportIssueDate;

    private String wifeSureName;

    private String wifeGivenName;

    private String wifePatronymic;

    private LocalDate wifeDateOfBirth;

    private String wifePassportSeries;

    private String wifePassportNumber;

    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;

    private LocalDate marriageCertificateDate;

    public String getHusbandSureName() {
        return husbandSureName;
    }

    public void setHusbandSureName(final String husbandSureName) {
        this.husbandSureName = husbandSureName;
    }

    public String getHusbandGivenName() {
        return husbandGivenName;
    }

    public void setHusbandGivenName(final String husbandGivenName) {
        this.husbandGivenName = husbandGivenName;
    }

    public String getHusbandPatronymic() {
        return husbandPatronymic;
    }

    public void setHusbandPatronymic(final String husbandPatronymic) {
        this.husbandPatronymic = husbandPatronymic;
    }

    public LocalDate getHusbandDateOfBirth() {
        return husbandDateOfBirth;
    }

    public void setHusbandDateOfBirth(final LocalDate husbandDateOfBirth) {
        this.husbandDateOfBirth = husbandDateOfBirth;
    }

    public String getHusbandPassportSeries() {
        return husbandPassportSeries;
    }

    public void setHusbandPassportSeries(final String husbandPassportSeries) {
        this.husbandPassportSeries = husbandPassportSeries;
    }

    public String getHusbandPassportNumber() {
        return husbandPassportNumber;
    }

    public void setHusbandPassportNumber(final String husbandPassportNumber) {
        this.husbandPassportNumber = husbandPassportNumber;
    }

    public LocalDate getHusbandPassportIssueDate() {
        return husbandPassportIssueDate;
    }

    public void setHusbandPassportIssueDate(final LocalDate husbandPassportIssueDate) {
        this.husbandPassportIssueDate = husbandPassportIssueDate;
    }

    public String getWifeSureName() {
        return wifeSureName;
    }

    public void setWifeSureName(final String wifeSureName) {
        this.wifeSureName = wifeSureName;
    }

    public String getWifeGivenName() {
        return wifeGivenName;
    }

    public void setWifeGivenName(final String wifeGivenName) {
        this.wifeGivenName = wifeGivenName;
    }

    public String getWifePatronymic() {
        return wifePatronymic;
    }

    public void setWifePatronymic(final String wifePatronymic) {
        this.wifePatronymic = wifePatronymic;
    }

    public LocalDate getWifeDateOfBirth() {
        return wifeDateOfBirth;
    }

    public void setWifeDateOfBirth(final LocalDate wifeDateOfBirth) {
        this.wifeDateOfBirth = wifeDateOfBirth;
    }

    public String getWifePassportSeries() {
        return wifePassportSeries;
    }

    public void setWifePassportSeries(final String wifePassportSeries) {
        this.wifePassportSeries = wifePassportSeries;
    }

    public String getWifePassportNumber() {
        return wifePassportNumber;
    }

    public void setWifePassportNumber(final String wifePassportNumber) {
        this.wifePassportNumber = wifePassportNumber;
    }

    public LocalDate getWifePassportIssueDate() {
        return wifePassportIssueDate;
    }

    public void setWifePassportIssueDate(final LocalDate wifePassportIssueDate) {
        this.wifePassportIssueDate = wifePassportIssueDate;
    }

    public String getMarriageCertificateNumber() {
        return marriageCertificateNumber;
    }

    public void setMarriageCertificateNumber(final String marriageCertificateNumber) {
        this.marriageCertificateNumber = marriageCertificateNumber;
    }

    public LocalDate getMarriageCertificateDate() {
        return marriageCertificateDate;
    }

    public void setMarriageCertificateDate(final LocalDate marriageCertificateDate) {
        this.marriageCertificateDate = marriageCertificateDate;
    }

    @Override
    public String toString() {
        return "MarriageRequest{" +
                "husbandSureName='" + husbandSureName + '\'' +
                ", husbandGivenName='" + husbandGivenName + '\'' +
                ", husbandPatronymic='" + husbandPatronymic + '\'' +
                ", husbandDateOfBirth=" + husbandDateOfBirth +
                ", husbandPassportSeries='" + husbandPassportSeries + '\'' +
                ", husbandPassportNumber='" + husbandPassportNumber + '\'' +
                ", husbandPassportIssueDate=" + husbandPassportIssueDate +
                ", wifeSureName='" + wifeSureName + '\'' +
                ", wifeGivenName='" + wifeGivenName + '\'' +
                ", wifePatronymic='" + wifePatronymic + '\'' +
                ", wifeDateOfBirth=" + wifeDateOfBirth +
                ", wifePassportSeries='" + wifePassportSeries + '\'' +
                ", wifePassportNumber='" + wifePassportNumber + '\'' +
                ", wifePassportIssueDate=" + wifePassportIssueDate +
                ", marriageCertificateNumber='" + marriageCertificateNumber + '\'' +
                ", marriageCertificateDate=" + marriageCertificateDate +
                '}';
    }
}
