package com.revenat.ext.cityregister.web;

import com.revenat.ext.cityregister.dao.PersonCheckerDao;
import com.revenat.ext.cityregister.dao.exception.PersonCheckerException;
import com.revenat.ext.cityregister.domain.PersonRequest;
import com.revenat.ext.cityregister.domain.PersonResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name ="CheckPersonServlet", urlPatterns = "/checkPerson")
public class CheckPersonServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String surname = req.getParameter("surname");
        PersonRequest request = new PersonRequest();
        request.setSurName(surname);
        request.setGivenName("Павел");
        request.setPatronymic("Николаевич");
        request.setDateOfBirth(LocalDate.of(1995, 3, 18));
        request.setStringCode(1);
        request.setBuilding("10");
        request.setExtension("2");
        request.setApartment("121");

        try {
            PersonCheckerDao dao = new PersonCheckerDao();
            final PersonResponse response = dao.checkPerson(request);
            if (response.isRegistered()) {
                resp.getWriter().write("Registered");
            } else {
                resp.getWriter().write("Not registered");
            }
        } catch (PersonCheckerException e) {
            resp.getWriter().write("Internal server error. Try again later.");
        }
    }
}
