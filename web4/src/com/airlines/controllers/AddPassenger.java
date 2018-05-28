package com.airlines.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");

		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("errors", false);
		
		String firstName = request.getParameter("first-name");
		System.out.println("firstName : " + firstName);

		if (firstName.length() == 0) {
			System.out.println("first name empty error");
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);

		}

		String lastName = request.getParameter("last-name");
		System.out.println("lastName : " + lastName);

		if (lastName.length() == 0) {
			System.out.println("last name empty error");
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);

		}

		String dob_raw = request.getParameter("dob");
		String dobArray[] = dob_raw.split("\\/");

		String pattern = "^\\d(1,2)\\/\\d(1,2)\\/\\d(4)$";

		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(dob_raw);
		if (m.find()) {
			String month = dobArray[0];
			String day = dobArray[1];
			String year = dobArray[2];

			Calendar cal = Calendar.getInstance();

			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

			Date dob = cal.getTime();
			
			System.out.println(dob);

		} else {
			System.out.println("Invalid Date of birth");
			request.setAttribute("errors", true);
			request.setAttribute("date format error", true);

		}

		String gender = request.getParameter("gender");
		System.out.println("gender : " + gender);

		doGet(request, response);

	}

}
