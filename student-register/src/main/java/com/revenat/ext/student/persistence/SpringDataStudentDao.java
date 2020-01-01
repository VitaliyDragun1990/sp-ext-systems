package com.revenat.ext.student.persistence;

import com.revenat.ext.student.business.StudentDao;
import com.revenat.ext.student.business.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Vitaliy Dragun
 */
@RepositoryDefinition(domainClass = Student.class, idClass = Long.class)
@Repository("studentDao")
public interface SpringDataStudentDao extends StudentDao {

    @Query("SELECT st FROM Student st WHERE " +
            "st.lastName = :lastName " +
            "AND st.firstName = :firstName " +
            "AND st.middleName = :middleName " +
            "AND st.dateOfBirth = :dateOfBirth " +
            "AND st.passportSeries = :passportSeries " +
            "AND st.passportNumber = :passportNumber " +
            "AND st.passportIssueDate = :passportIssueDate")
    @Override
    Optional<Student> findStudent(
            @Param("lastName") String lastName,
            @Param("firstName") String firstName,
            @Param("middleName") String middleName,
            @Param("dateOfBirth") LocalDate dateOfBirth,
            @Param("passportSeries") String passportSeries,
            @Param("passportNumber") String passportNumber,
            @Param("passportIssueDate") LocalDate passportIssueDate
    );
}
