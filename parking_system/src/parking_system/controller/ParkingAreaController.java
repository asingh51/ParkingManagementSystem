package parking_system.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import parking_system.data.ParkigAreaDAO;
import parking_system.data.ParkingDao;
import parking_system.data.UserDAO;
import parking_system.model.ParkingArea;
import parking_system.model.ParkingDetails;
import parking_system.model.ReservationErrorMsgs;
import parking_system.model.User;
import parking_system.model.UserErrorMsgs;

/**
 * Servlet implementation class ParkingAreaController
 */
@WebServlet("/ParkingAreaController")
public class ParkingAreaController extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	private void getParkinAreaParam (HttpServletRequest request, ParkingArea parkingArea) {
		parkingArea.setParkingArea(request.getParameter("parking_area_name"),request.getParameter("type"),request.getParameter("floor"),request.getParameter("capacity"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
	
		ParkingArea parkingArea=new ParkingArea();
		

		if (action.equalsIgnoreCase("saveParkingArea") ) {  
			getParkinAreaParam(request, parkingArea);
			
			session.setAttribute("parkingArea", parkingArea);
			
			
			
			ParkigAreaDAO.insertParkingArea(parkingArea);
			session.invalidate();
			url="/listManager.jsp";
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
				
		}
		
				
	}


