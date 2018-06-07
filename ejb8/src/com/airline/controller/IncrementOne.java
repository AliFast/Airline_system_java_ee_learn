package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.CounterBean;
import com.airline.service.CounterBeanStateful;

/**
 * Servlet implementation class IncrementOne
 */
@WebServlet("/IncrementOne")
public class IncrementOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	CounterBean cb;
	
	@EJB
	CounterBeanStateful cbStateful;
	
    public IncrementOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		out.println("The Current Count Value of Singleton is : " + cb.getCount());
		out.println("The Current Count Value of Stateful is : " + cbStateful.getCount());
		cb.AddOne();
		cbStateful.AddOne();
		out.println("After increment Count Value of Singleton is : " + cb.getCount());
		out.println("After increment Count Value of Stateful is : " + cbStateful.getCount());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
