INSERT INTO ro_person (sex, first_name, last_name, patronymic, date_birth)
VALUES
    (1, 'Елена', 'Васильева', 'Сергеевна', '1998-03-24'),
    (2, 'Олег', 'Васильев', 'Петрович', '1997-10-16'),
    (2, 'Николай', 'Васильев', 'Олегович', '2018-10-21');

INSERT INTO ro_birth_certificate (certificate_number, issue_date, person_id, mother_id, father_id)
VALUES
    ('123Birth', '2019-01-01', 3, 1, 2);

INSERT INTO ro_passport (person_id, series, number, issue_date, issue_department)
VALUES
    (1, '40000', '123456', '2018-04-10', 'Passport department');