package com.airlines.controllers;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.airline.modals.Passenger;

/**
 * Application Lifecycle Listener implementation class AirlineListener
 *
 */
@WebListener
public class AirlineListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AirlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext sc = sce.getServletContext();
    	ArrayList<Passenger> pList= (ArrayList<Passenger>)sc.getAttribute("passengers");
    	
    	if(pList == null) {
    		System.out.println("No Passenger List created yet,Let's Create one here");
    		pList = new ArrayList<Passenger>();
    		sc.setAttribute("passengers", pList);
    	}
    	
    	
    }
	
}
