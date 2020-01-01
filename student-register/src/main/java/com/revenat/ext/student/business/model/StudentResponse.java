package com.revenat.ext.student.business.model;

import com.revenat.ext.student.business.entity.Faculty;
import com.revenat.ext.student.business.entity.StudentDocument;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

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

    public static StudentResponse from(StudentDocument studentDocument) {
        StudentResponse response = new StudentResponse();
        response.setDocumentNumber(studentDocument.getDocumentNumber());
        Faculty faculty = studentDocument.getFaculty();
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

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
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
}
