package com.revenat.ext.student.business.model;

import com.revenat.ext.student.business.entity.Faculty;
import com.revenat.ext.student.business.entity.StudentDocument;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * @author Vitaliy Dragun
 */
public class StudentResponse {

    private String documentNumber;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate issueDate;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate expireDate;

    private String faculty;

    private String universityName;

    private String educationForm;

    public static StudentResponse from(final StudentDocument studentDocument) {
        final StudentResponse response = new StudentResponse();
        response.setDocumentNumber(studentDocument.getDocumentNumber());
        final Faculty faculty = studentDocument.getFaculty();
        response.setUniversityName(faculty.getUniversity().getUniversityName());
        response.setFaculty(faculty.getFacultyName());
        response.setEducationForm(studentDocument.getEducationForm().name());
        response.setIssueDate(studentDocument.getIssueDate());
        response.setExpireDate(studentDocument.getExpireDate());
        return response;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(final LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(final LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(final String faculty) {
        this.faculty = faculty;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(final String universityName) {
        this.universityName = universityName;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(final String educationForm) {
        this.educationForm = educationForm;
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "documentNumber='" + documentNumber + '\'' +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                ", faculty='" + faculty + '\'' +
                ", universityName='" + universityName + '\'' +
                ", educationForm='" + educationForm + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final StudentResponse response = (StudentResponse) o;
        return Objects.equals(documentNumber, response.documentNumber) &&
                Objects.equals(issueDate, response.issueDate) &&
                Objects.equals(expireDate, response.expireDate) &&
                Objects.equals(faculty, response.faculty) &&
                Objects.equals(universityName, response.universityName) &&
                Objects.equals(educationForm, response.educationForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentNumber, issueDate, expireDate, faculty, universityName, educationForm);
    }

    public static class Builder {

        private String documentNumber;

        private LocalDate issueDate;

        private LocalDate expireDate;

        private String faculty;

        private String universityName;

        private String educationForm;

        public Builder withDocumentNumber(final String documentNumber) {
            this.documentNumber = requireNonNull(documentNumber);
            return this;
        }

        public Builder withIssueDate(final LocalDate issueDate) {
            this.issueDate = requireNonNull(issueDate);
            return this;
        }

        public Builder withExpireDate(final LocalDate expireDate) {
            this.expireDate = requireNonNull(expireDate);
            return this;
        }

        public Builder withFaculty(final String faculty) {
            this.faculty = requireNonNull(faculty);
            return this;
        }

        public Builder withUniversityName(final String universityName) {
            this.universityName = requireNonNull(universityName);
            return this;
        }

        public Builder withEducationForm(final String educationForm) {
            this.educationForm = requireNonNull(educationForm);
            return this;
        }

        public StudentResponse build() {
            final StudentResponse response = new StudentResponse();
            response.setDocumentNumber(documentNumber);
            response.setIssueDate(issueDate);
            response.setExpireDate(expireDate);
            response.setFaculty(faculty);
            response.setUniversityName(universityName);
            response.setEducationForm(educationForm);
            return response;
        }
    }
}
