package com.revenat.ext.cityregister.domain;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @author Vitaliy Dragun
 */
public class PersonRequest {

    private String surName;

    private String givenName;

    private String patronymic;

    private LocalDate dateOfBirth;

    private Integer stringCode;

    private String building;

    private String extension;

    private String apartment;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStringCode() {
        return stringCode;
    }

    public void setStringCode(Integer stringCode) {
        this.stringCode = stringCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Optional<String> getExtension() {
        return Optional.ofNullable(extension);
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Optional<String> getApartment() {
        return Optional.ofNullable(apartment);
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
