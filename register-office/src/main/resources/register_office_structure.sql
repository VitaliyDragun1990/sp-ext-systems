DROP TABLE IF EXISTS person;

CREATE TABLE person (
    person_id SERIAL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (person_id)
);