DROP TABLE IF EXISTS ro_marriage_certificate;
DROP TABLE IF EXISTS ro_birth_certificate;
DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id SERIAL,
    sex SMALLINT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    patronymic VARCHAR(100),
    date_birth DATE NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id SERIAL,
    person_id INTEGER NOT NULL,
    series VARCHAR(10) NOT NULL,
    number VARCHAR(10) NOT NULL,
    issue_date DATE NOT NULL,
    issue_department VARCHAR(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_birth_certificate (
    birth_certificate_id SERIAL,
    certificate_number VARCHAR(20) NOT NULL,
    issue_date DATE NOT NULL,
    person_id INTEGER NOT NULL,
    father_id INTEGER,
    mother_id INTEGER,
    PRIMARY KEY (birth_certificate_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (father_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (mother_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);

CREATE TABLE ro_marriage_certificate (
    marriage_certificate_id SERIAL,
    certificate_number VARCHAR(20) NOT NULL,
    issue_date DATE NOT NULL,
    end_date DATE,
    husband_id INTEGER NOT NULL,
    wife_id INTEGER NOT NULL,
    active BOOLEAN NOT NULL DEFAULT true,
    PRIMARY KEY (marriage_certificate_id),
    FOREIGN KEY (husband_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT,
    FOREIGN KEY (wife_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);