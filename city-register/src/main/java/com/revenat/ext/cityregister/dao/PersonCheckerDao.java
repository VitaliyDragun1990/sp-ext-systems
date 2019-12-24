package com.revenat.ext.cityregister.dao;

import com.revenat.ext.cityregister.config.ConnectionBuilder;
import com.revenat.ext.cityregister.dao.exception.PersonCheckerException;
import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;

import java.sql.*;

import static java.util.Objects.requireNonNull;

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

    private final com.revenat.ext.cityregister.config.ConnectionBuilder connectionBuilder;

    public PersonCheckerDao(final ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = requireNonNull(connectionBuilder);
    }

    public PersonResponse checkPerson(final PersonRequest request) throws PersonCheckerException {
        String sql = SQL_REQUEST;
        sql += request.isExtensionPresent() ? "AND upper(a.extension) = upper(?) " : "AND a.extension IS NULL ";
        sql += request.isApartmentPresent() ? "AND upper(a.apartment) = upper(?) " : "AND a.apartment IS NULL ";

        try (final Connection conn = getConnection();
             final PreparedStatement ps = conn.prepareStatement(sql)) {
            int counter = 1;

            ps.setString(counter++, request.getSurName());
            ps.setString(counter++, request.getGivenName());
            ps.setString(counter++, request.getPatronymic());
            ps.setDate(counter++, Date.valueOf(request.getDateOfBirth()));
            ps.setInt(counter++, request.getStreetCode());
            ps.setString(counter++, request.getBuilding());
            if (request.isExtensionPresent()) {
                ps.setString(counter++, request.getExtension());
            }
            if (request.isApartmentPresent()) {
                ps.setString(counter++, request.getApartment());
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
        return connectionBuilder.getConnection();
    }
}
