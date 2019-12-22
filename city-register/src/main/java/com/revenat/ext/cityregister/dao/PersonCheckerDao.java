package com.revenat.ext.cityregister.dao;

import com.revenat.ext.cityregister.dao.exception.PersonCheckerException;
import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;

import java.sql.*;

/**
 * @author Vitaliy Dragun
 */
public class PersonCheckerDao {

    private static final String SQL_REQUEST =
    "SELECT temporal " +
    "FROM cr_address_person AS ap " +
    "INNER JOIN cr_person AS p ON ap.person_id = p.person_id " +
    "INNER JOIN cr_address AS a ON a.address_id = ap.address_id " +
    "WHERE " +
    "CURRENT_DATE >= ap.start_date AND (CURRENT_DATE <= ap.end_date OR ap.end_date IS NULL) " +
    "AND upper(p.sur_name) = upper(?) " +
    "AND upper(p.given_name) = upper(?) " +
    "AND upper(p.patronymic) = upper(?) " +
    "AND p.date_of_birth = ? " +
    "AND a.street_code = ? " +
    "AND upper(a.building) = upper(?) ";

    public PersonResponse checkPerson(final PersonRequest request) throws PersonCheckerException {
        String sql = SQL_REQUEST;
        sql += request.getExtension().isPresent() ? "AND upper(a.extension) = upper(?) " : "AND a.extension IS NULL ";
        sql += request.getApartment().isPresent() ? "AND upper(a.apartment) = upper(?) " : "AND a.apartment IS NULL ";

        try (final Connection conn = getConnection();
             final PreparedStatement ps = conn.prepareStatement(sql)) {
            int counter = 1;

            ps.setString(counter++, request.getSurName());
            ps.setString(counter++, request.getGivenName());
            ps.setString(counter++, request.getPatronymic());
            ps.setDate(counter++, Date.valueOf(request.getDateOfBirth()));
            ps.setInt(counter++, request.getStringCode());
            ps.setString(counter++, request.getBuilding());
            if (request.getExtension().isPresent()) {
                ps.setString(counter++, request.getExtension().get());
            }
            if (request.getApartment().isPresent()) {
                ps.setString(counter++, request.getApartment().get());
            }

            try (final ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("temporal") ? PersonResponse.temporalRegistration() :
                            PersonResponse.permanentRegistration();
                } else {
                    return PersonResponse.unregistered();
                }
            }
        } catch (final SQLException e) {
            throw new PersonCheckerException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/city_register", "postgres", "19900225");
    }
}
