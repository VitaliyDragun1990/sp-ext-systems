package com.revenat.ext.student.business.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Vitaliy Dragun
 */
@Table(name = "sr_university")
@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id", nullable = false)
    private Long universityId;

    @Column(name = "university_name", nullable = false)
    private String universityName;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "university")
    private List<Faculty> faculties;

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
