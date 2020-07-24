package parking_system.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import parking_system.data.ParkingDao;
import parking_system.data.UserDAO;
import parking_system.model.ParkingDetails;
import parking_system.model.ReservationErrorMsgs;
import parking_system.model.Reservation;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/ReservationController")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String selectedReservationID = null;
       
	private void getReservationParam(HttpServletRequest request, Reservation reservation) {
		reservation.setReservation(request.getParameter("username"), request.getParameter("reservationid"), request.getParameter("starttime"), request.getParameter("endtime"), request.getParameter("permit"), request.getParameter("parkingarea"), request.getParameter("floor"), request.getParameter("parkingspot"), request.getParameter("cancelled"), request.getParameter("resvdate"), request.getParameter("violation"), request.getParameter("vehiclenumber"), request.getParameter("cart"), request.getParameter("camera"), request.getParameter("history"), request.getParameter("payment"), request.getParameter("spotID"));		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		Reservation reservation = new Reservation();
		
//		if (action.equalsIgnoreCase("updateReservationInDB")){
//			getReservationParam(request, reservation);
//			session.setAttribute("user", reservation);			
//			UserDAO.updateUserDetails(reservation, );
//			if (userRole.equalsIgnoreCase("user"))
//				url = "/listUser.jsp";
//			else if (userRole.equalsIgnoreCase("manager"))
//				url = "/listManager.jsp";
//			else
//				url = "/listAdmin.jsp";
//			System.out.println("update query");			
//		}
			
		getServletContext().getRequestDispatcher(url).forward(request, response);
	
	}

}
