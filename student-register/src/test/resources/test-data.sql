INSERT INTO sr_university (university_id, university_name) VALUES
(1, 'Санкт-Петербургский Государственный Университет'),
(2, 'Санкт-Петербургский Политехнический Университет'),
(3, 'Санкт-Петербургский Морской Технический Университет');

INSERT INTO sr_faculty (faculty_name, university_id) VALUES
('Машиностроение', 1),
('Юриспруденция', 2),
('Информационные системы', 3);

INSERT INTO sr_student (date_of_birth, first_name, last_name, middle_name, passport_issue_date, passport_series, passport_number)
VALUES
('1998-03-24', 'Олег', 'Васильев', 'Петрович', '2017-06-15', '50000', '654321');

INSERT INTO sr_student_document (document_number, education_form, expire_date, issue_date, faculty_id, student_id)
VALUES
('DOC123456', 0, '2020-10-12', '2015-10-10', 1, 1),
('DOC654321', 1, '2021-11-25', '2017-09-05', 3, 1);