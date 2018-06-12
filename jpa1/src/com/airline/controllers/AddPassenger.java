package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.modals.FlightClass;
import com.airline.modals.Gender;
import com.airline.modals.Passengers;
import com.airline.service.PassengerService;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	PassengerService ps;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Passengers p = new Passengers();
		p.setFirstName("Ali");
		p.setLastName("Tahir");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,1996);
		cal.set(Calendar.DAY_OF_MONTH,21);
		cal.set(Calendar.MONTH,9);
		
		Date dob = cal.getTime();
		p.setDob(dob);
		
		p.setGender(Gender.Male);
		p.setFlightClass(FlightClass.Coach);
		
		PrintWriter out = response.getWriter();
		out.println(p);
		
		ps.addPassenger(p);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
