package parking_system.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import javax.management.StringValueExp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import parking_system.data.ParkingDao;
import parking_system.data.ReservationDAO;
import parking_system.model.ParkingDetails;
import parking_system.model.ParkingSpot;
import parking_system.model.ReservationErrorMsgs;
import parking_system.model.Reservation;

/**
 * Servlet implementation class ParkingController
 */
@WebServlet("/ParkingController")
public class ParkingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    private static DecimalFormat decimalFormat = new DecimalFormat(".##");
       
	/*private void getParkingParam (HttpServletRequest request, ParkingDetails parking) {
		parking.setUser(request.getParameter("username"),request.getParameter("firstName"),request.getParameter("lastName"),request.getParameter("email"), request.getParameter("password"), request.getParameter("role"),request.getParameter("utaid"),request.getParameter("phone"),request.getParameter("streetaddress"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zipcode"),request.getParameter("vehiclenumber"),"1",request.getParameter("permit"));  
	}*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		ParkingDetails parking = new ParkingDetails();
		Reservation reservation = new Reservation();
		ReservationErrorMsgs rErrorMsgs = new ReservationErrorMsgs();;
		
		if(action.equalsIgnoreCase("searchP")) {
			StringBuilder st = new StringBuilder(request.getParameter("starttime"));
			StringBuilder et = new StringBuilder(request.getParameter("endtime"));
			reservation.setStarttime(st.deleteCharAt(2).toString());
			reservation.setEndtime(et.deleteCharAt(2).toString());
			System.out.println("Starttime: " + st.toString()+" EndTime: "+ et.toString() + " Diff: " + (Integer.parseInt(et.toString())-Integer.parseInt(st.toString())));
			reservation.validateReservation(action, reservation, rErrorMsgs);
			if(!rErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("rErrorMsgs", rErrorMsgs);
				url="/searchParking.jsp";
			}
			else{
				session.removeAttribute("rErrorMsgs");
				ArrayList<ParkingSpot> parkingInDB = new ArrayList<>();
				parkingInDB = ParkingDao.getAvailableParking(st.toString(),et.toString());
				session.setAttribute("PARKINGS", parkingInDB);
				session.setAttribute("starttime", st.toString());
				session.setAttribute("endtime", et.toString());
				url="/listParking.jsp";
			}
		}
		else if(action.equalsIgnoreCase("finalPayment")) {
			System.out.println("in final payment");
			String radioBut = request.getParameter("select");
			String reservationDet[] = radioBut.split(",");
			
			session.setAttribute("parkingArea", reservationDet[0]);
			session.setAttribute("resPermit", reservationDet[1]);
			session.setAttribute("floor", reservationDet[2]);
			session.setAttribute("capacity", reservationDet[3]);
			session.setAttribute("avialable", reservationDet[4]);
			
			reservation.setParkingarea(reservationDet[0]);
			reservation.setPermit(reservationDet[1]);
			reservation.setFloor(reservationDet[2]);
			reservation.setUserPermit(session.getAttribute("permit").toString());
			
			reservation.validateReservation(action, reservation, rErrorMsgs);
			if(!rErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("rErrorMsgs", rErrorMsgs);
				url="/listParking.jsp";
			}
			else{
				session.removeAttribute("rErrorMsgs");
				String [] options = request.getParameterValues("optionsv");
				
				double finamount = 0;
				String hist="0";
				String cam="0";
				String cart="0";
				double histValue = 1.95;
				double cameraValue = 2.95;
				double cartValue = 15.95;
				
				if(options!=null){
					for(int i=0;i<options.length;i++) {
						String opt = options[i];
						if(opt.equals("hist")) {
							finamount+= histValue;
							hist="1";
						}
						else if(opt.equals("cam")) {
							finamount+= cameraValue;
							cam="1";
						}
						else if(opt.equals("cart")){
							if (calendar.get(Calendar.DAY_OF_WEEK) == 1){
								if (Integer.parseInt(session.getAttribute("endtime").toString()) < 1200 || Integer.parseInt(session.getAttribute("endtime").toString()) > 1700)
									finamount+= 2*cartValue;
								else
									finamount+= cartValue;
							}
							else if(calendar.get(Calendar.DAY_OF_WEEK) == 7){
								if (Integer.parseInt(session.getAttribute("endtime").toString()) < 800 || Integer.parseInt(session.getAttribute("endtime").toString()) > 1700)
									finamount+= 2*cartValue;
								else
									finamount+= cartValue;
							}
							else{
								if (Integer.parseInt(session.getAttribute("endtime").toString()) < 600 || Integer.parseInt(session.getAttribute("endtime").toString()) > 2000)
									finamount+= 2*cartValue;
								else
									finamount+= cartValue;
							}
							cart="1";
						}
					}
					
				}
				System.out.println("Current Day: " + calendar.get(Calendar.DAY_OF_WEEK));
				System.out.println("ENdTime: " + session.getAttribute("endtime").toString());
				System.out.println("amount: $"+ decimalFormat.format(finamount));
				session.setAttribute("amount", "$ "+decimalFormat.format(finamount));
				
				String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                    + "0123456789"
	                    + "abcdefghijklmnopqrstuvxyz"; 

				StringBuilder sb = new StringBuilder(); 
				
				for (int i = 0; i < 10; i++) { 
				
				int index = (int)(AlphaNumericString.length()* Math.random()); 
				
				sb.append(AlphaNumericString.charAt(index)); 
				} 																		
				
				int parkingSpot = Integer.parseInt(session.getAttribute("capacity").toString()) - Integer.parseInt(session.getAttribute("avialable").toString()) + 1 ;
				System.out.println("pspot: "+parkingSpot);
				StringBuilder spotId = new StringBuilder();
				if (session.getAttribute("parkingArea").toString().equals("West Garage"))
					spotId.append("WG");
				else if (session.getAttribute("parkingArea").toString().equals("Maverick"))
					spotId.append("MV");
				else if (session.getAttribute("parkingArea").toString().equals("Nedderman"))
					spotId.append("ND");
				else if (session.getAttribute("parkingArea").toString().equals("Davis"))
					spotId.append("DV");
				
				if (session.getAttribute("floor").toString().equals("1"))
					spotId.append("1F");
				else if (session.getAttribute("floor").toString().equals("2"))
					spotId.append("2F");
				else if (session.getAttribute("floor").toString().equals("3"))
					spotId.append("3F");
				else if (session.getAttribute("floor").toString().equals("4"))
					spotId.append("4F");
				else if (session.getAttribute("floor").toString().equals("5"))
					spotId.append("5F");
				
				if (session.getAttribute("resPermit").toString().equals("BASIC"))
					spotId.append("B");
				else if (session.getAttribute("floor").toString().equals("MIDRANGE"))
					spotId.append("M");
				else if (session.getAttribute("floor").toString().equals("PREMIUM"))
					spotId.append("P");
				else if (session.getAttribute("floor").toString().equals("ACCESS"))
					spotId.append("A");
				
				spotId.append(String.valueOf(parkingSpot));
				
				System.out.println("SpotID: " + spotId);
				
				List<String> list = new ArrayList<String>();
				
				list.add(session.getAttribute("username").toString()); //to be updated
				list.add(sb.toString());
				list.add(session.getAttribute("starttime").toString());
				list.add(session.getAttribute("endtime").toString());
				list.add(session.getAttribute("resPermit").toString());
				list.add(session.getAttribute("parkingArea").toString());
				list.add(session.getAttribute("floor").toString());
				list.add(String.valueOf(parkingSpot));
				list.add(String.valueOf(0));
				list.add("revdate");
				list.add("NULL");
				list.add(session.getAttribute("vehiclenumber").toString());
				list.add(cart);
				list.add(cam);
				list.add(hist);
				list.add(String.valueOf(finamount));
				list.add(spotId.toString());
				
				session.setAttribute("reservationdetails", list);
				url="/payment.jsp";
			}
		}
		
		else if(action.equalsIgnoreCase("EndPage")) {
			String cardNumber = request.getParameter("card");
			String cvv = request.getParameter("cvv");
			reservation.setCardNumber(cardNumber);
			reservation.setCvv(cvv);
			System.out.println("CN: " + cardNumber + " cvv: " + cvv);
			reservation.validateReservation(action, reservation, rErrorMsgs);
			if(!rErrorMsgs.getErrorMsg().equals("")){
				session.setAttribute("rErrorMsgs", rErrorMsgs);
				session.setAttribute("reservation", reservation);
				url="/payment.jsp";
			}
			else{
			List<String> ls = (List<String>) session.getAttribute("reservationdetails");
			
			Reservation reservation2 = new Reservation();
			reservation2.setReservation(ls.get(0), ls.get(1), ls.get(2), ls.get(3), ls.get(4), ls.get(5), ls.get(6), ls.get(7), ls.get(8), ls.get(9), ls.get(10), ls.get(11), ls.get(12), ls.get(13), ls.get(14), ls.get(15), ls.get(16));
			session.setAttribute("ref", ls.get(1));
			session.setAttribute("spotID", ls.get(16));
			ReservationDAO.insertReservation(reservation2);
			ReservationDAO.updateReservationSpot(ls.get(16),ls.get(2), ls.get(3),ls.get(1));
			url="/finalPage.jsp";
			}
		}
		
		else if(action.equalsIgnoreCase("searchSpot")) {
			
			String spotid = request.getParameter("spotId");
			System.out.println("spot id is "+spotid);
			
			
			ArrayList<ParkingDetails> parkingInDB = new ArrayList<ParkingDetails>();
			ParkingSpot pspot = new ParkingSpot();
			pspot = ParkingDao.getParticularSpot(spotid);
			System.out.println("here :" + pspot);
			if(!pspot.getParkingAreaName().equals("")){
				session.removeAttribute("sPSErrMsg");
				session.setAttribute("PSPOT", pspot);
				url="/listParkingSpot.jsp";
			}
			else {
				session.setAttribute("sPSErrMsg", "No Parking Spot found");
				url="/searchParkingSpot.jsp";
			}
		}
		
		else if(action.equalsIgnoreCase("toggleSpot")) {
			
			String spotid = request.getParameter("pidtoggle");
			System.out.println("spot id to toggle is "+spotid);
			
			ParkingDao.deactivateSpot(spotid);
			
			url="/listManager.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
