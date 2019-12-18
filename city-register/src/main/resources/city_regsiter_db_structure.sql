--1. District
--2. Street
--3. Address - district, street, building, extension, apartment
--4. Person -  surname, last name, patronymic, passport(series/number/issue date),
--   birthday certificate(number/issue date)
--5. Relation of person and it's address - Person, Address, date range, registration type
DROP TABLE IF EXISTS cr_address_person;
DROP TABLE IF EXISTS cr_person;
DROP TABLE IF EXISTS cr_address;
DROP TABLE IF EXISTS cr_street;
DROP TABLE IF EXISTS cr_district;

CREATE TABLE cr_district (
    district_code INTEGER NOT NULL,
    district_name VARCHAR(300),
    PRIMARY KEY (district_code)
);

CREATE TABLE cr_street (
    street_code INTEGER NOT NULL,
    street_name VARCHAR(300),
    PRIMARY KEY (street_code)
);

CREATE TABLE cr_address (
    address_id SERIAL,
    district_code INTEGER NOT NULL,
    street_code INTEGER NOT NULL,
    building VARCHAR(10) NOT NULL,
    extension VARCHAR(10),
    apartment VARCHAR(10),
    PRIMARY KEY (address_id),
    FOREIGN KEY (street_code) REFERENCES cr_street(street_code) ON DELETE RESTRICT,
    FOREIGN KEY (district_code) REFERENCES cr_district(district_code) ON DELETE RESTRICT
);

CREATE TABLE cr_person (
    person_id SERIAL,
    sur_name VARCHAR(100) NOT NULL,
    given_name VARCHAR(100) NOT NULL,
    patronymic VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    passport_series VARCHAR(10),
    passport_number VARCHAR(10),
    passport_date DATE,
    certificate_number VARCHAR(10),
    certificate_date DATE,
    PRIMARY KEY  (person_id)
);

CREATE TABLE cr_address_person (
    person_address_id SERIAL,
    address_id INTEGER NOT NULL,
    person_id INTEGER NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    PRIMARY KEY (person_address_id),
    FOREIGN KEY (address_id) REFERENCES cr_address(address_id) ON DELETE RESTRICT,
    FOREIGN KEY (person_id) REFERENCES cr_person(person_id) ON DELETE RESTRICT
);