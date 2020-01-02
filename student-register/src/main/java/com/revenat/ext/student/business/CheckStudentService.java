package com.revenat.ext.student.business;

import com.revenat.ext.student.business.entity.Student;
import com.revenat.ext.student.business.model.StudentRequest;
import com.revenat.ext.student.business.model.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * @author Vitaliy Dragun
 */
@Service
public class CheckStudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckStudentService.class);

    private final StudentDao studentDao;

    @Autowired
    public CheckStudentService(final StudentDao studentDao) {
        this.studentDao = requireNonNull(studentDao);
    }

    @Transactional(readOnly = true)
    public List<StudentResponse> checkStudent(final StudentRequest request) {
        final Optional<Student> studentOptional = studentDao.findStudent(
                request.getLastName(),
                request.getFirstName(),
                request.getMiddleName(),
                request.getDateOfBirth(),
                request.getPassportSeries(),
                request.getPassportNumber(),
                request.getPassportIssueDate()
        );
        if (studentOptional.isEmpty()) {
            LOGGER.info("For request:{} no student info was found", request);
            return List.of();
        } else {
            final Student student = studentOptional.get();
            LOGGER.info("For request:{} student info was found: {}", request, student);
            return student
                    .getStudentDocuments().stream()
                    .map(StudentResponse::from)
                    .collect(Collectors.toUnmodifiableList());
        }
    }
}
