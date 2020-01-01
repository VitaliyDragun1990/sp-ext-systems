package com.revenat.ext.student.business;

import com.revenat.ext.student.business.entity.Student;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Vitaliy Dragun
 */
public interface StudentDao {

    Optional<Student> findStudent(
            String lastName,
            String firstName,
            String middleName,
            LocalDate dateOfBirth,
            String passportSeries,
            String passportNumber,
            LocalDate passportIssueDate
    );
}
