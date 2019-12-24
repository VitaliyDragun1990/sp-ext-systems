package com.revenat.ext.cityregister.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Vitaliy Dragun
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(final String s) {
        return LocalDate.parse(s, DATE_TIME_FORMATTER);
    }

    @Override
    public String marshal(final LocalDate localDate) {
        return localDate.format(DATE_TIME_FORMATTER);
    }
}
