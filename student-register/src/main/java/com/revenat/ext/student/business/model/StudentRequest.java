package com.revenat.ext.student.business.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

/**
 * @author Vitaliy Dragun
 */
public class StudentRequest {

    private String firstName;

    private String lastName;

    private String middleName;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfBirth;

    private String passportNumber;

    private String passportSeries;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate passportIssueDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(final String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(final String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public LocalDate getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(final LocalDate passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", passportIssueDate=" + passportIssueDate +
                '}';
    }

    public static class Builder {

        private String firstName;

        private String lastName;

        private String middleName;

        private LocalDate dateOfBirth;

        private String passportNumber;

        private String passportSeries;

        private LocalDate passportIssueDate;

        public Builder setFirstName(final String firstName) {
            this.firstName = requireNonNull(firstName);
            return this;
        }

        public Builder setLastName(final String lastName) {
            this.lastName = requireNonNull(lastName);
            return this;
        }

        public Builder setMiddleName(final String middleName) {
            this.middleName = requireNonNull(middleName);
            return this;
        }

        public Builder setDateOfBirth(final LocalDate dateOfBirth) {
            this.dateOfBirth = requireNonNull(dateOfBirth);
            return this;
        }

        public Builder setPassportSeries(final String passportSeries) {
            this.passportSeries = requireNonNull(passportSeries);
            return this;
        }

        public Builder setPassportNumber(final String passportNumber) {
            this.passportNumber = requireNonNull(passportNumber);
            return this;
        }

        public Builder setPassportIssueDate(final LocalDate passportIssueDate) {
            this.passportIssueDate = requireNonNull(passportIssueDate);
            return this;
        }

        public StudentRequest build() {
            final StudentRequest request = new StudentRequest();
            request.setLastName(lastName);
            request.setFirstName(firstName);
            request.setMiddleName(middleName);
            request.setDateOfBirth(dateOfBirth);
            request.setPassportSeries(passportSeries);
            request.setPassportNumber(passportNumber);
            request.setPassportIssueDate(passportIssueDate);
            return request;
        }
    }
}
