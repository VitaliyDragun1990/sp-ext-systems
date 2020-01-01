DROP TABLE IF EXISTS sr_student_document;
DROP TABLE IF EXISTS sr_student;
DROP TABLE IF EXISTS sr_faculty;
DROP TABLE IF EXISTS sr_university;


CREATE TABLE sr_university
(
    university_id SERIAL NOT NULL,
    university_name character varying(255) NOT NULL,
    CONSTRAINT sr_university_pkey PRIMARY KEY (university_id)
);

CREATE TABLE sr_faculty
(
    faculty_id SERIAL NOT NULL,
    faculty_name character varying(255) NOT NULL,
    university_id bigint NOT NULL,
    CONSTRAINT sr_faculty_pkey PRIMARY KEY (faculty_id),
    CONSTRAINT sr_faculty_sr_university_fk FOREIGN KEY (university_id)
        REFERENCES sr_university (university_id) ON DELETE CASCADE
);

CREATE TABLE sr_student
(
    student_id SERIAL NOT NULL,
    date_of_birth date NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    middle_name character varying(255) NOT NULL,
    passport_issue_date date NOT NULL,
    passport_number character varying(255) NOT NULL,
    passport_series character varying(255) NOT NULL,
    CONSTRAINT sr_student_pkey PRIMARY KEY (student_id)
);

CREATE TABLE sr_student_document
(
    document_id SERIAL NOT NULL,
    document_number character varying(255) NOT NULL,
    education_form integer NOT NULL,
    expire_date date NOT NULL,
    issue_date date NOT NULL,
    faculty_id bigint NOT NULL,
    student_id bigint NOT NULL,
    CONSTRAINT sr_student_document_pkey PRIMARY KEY (document_id),
    CONSTRAINT sr_student_document_sr_faculty_fk FOREIGN KEY (faculty_id)
        REFERENCES sr_faculty (faculty_id) ON DELETE RESTRICT,
    CONSTRAINT sr_student_document_sr_student_fk FOREIGN KEY (student_id)
        REFERENCES sr_student (student_id) ON DELETE RESTRICT
);