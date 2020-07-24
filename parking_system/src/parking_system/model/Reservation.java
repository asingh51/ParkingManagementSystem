package parking_system.model;

public class Reservation {
	
	private static final long serialVersionUID = 3L;
	private String username = "";
	private String reservationid = "";
	private String starttime = "";
	private String endtime = "";
	private String permit = "";
	private String parkingarea = "";
	private String floor = "";
	private String parkingspot = "";
	private String cancelled = "";
	private String resvdate = "";
	private String violation = "";
	private String vehiclenumber = "";
	private String cart = "";
	private String camera = "";
	private String history = "";
	private String payment = "";
	private String spotID = "";
	
	private String userPermit = "";
	private String cardNumber = "";
	private String cvv = "";
	
	
	public void setReservation(String username, String reservationid, String starttime, String endtime, String permit, String parkingarea,
			String floor, String parkingspot, String cancelled, String resvdate, String violation, String vehiclenumber,
			String cart, String camera, String history, String payment, String spotID) {
		setUsername(username);
		setReservationid(reservationid);
		setStarttime(starttime);
		setEndtime(endtime);
		setPermit(permit);
		setParkingarea(parkingarea);
		setFloor(floor);
		setParkingspot(parkingspot);
		setCancelled(cancelled);
		setResvdate(resvdate);
		setViolation(violation);
		setVehiclenumber(vehiclenumber);
		setCart(cart);
		setCamera(camera);
		setHistory(history);
		setPayment(payment);
		setSpotID(spotID);
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReservationid() {
		return reservationid;
	}
	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public String getParkingarea() {
		return parkingarea;
	}
	public void setParkingarea(String parkingarea) {
		this.parkingarea = parkingarea;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getParkingspot() {
		return parkingspot;
	}
	public void setParkingspot(String parkingspot) {
		this.parkingspot = parkingspot;
	}
	public String getCancelled() {
		return cancelled;
	}
	public void setCancelled(String cancelled) {
		this.cancelled = cancelled;
	}
	public String getResvdate() {
		return resvdate;
	}
	public void setResvdate(String date) {
		this.resvdate = date;
	}
	public String getViolation() {
		return violation;
	}
	public void setViolation(String violation) {
		this.violation = violation;
	}
	public String getVehiclenumber() {
		return vehiclenumber;
	}
	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}
	public String getCart() {
		return cart;
	}
	public void setCart(String cart) {
		this.cart = cart;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getUserPermit() {
		return userPermit;
	}


	public void setUserPermit(String userPermit) {
		this.userPermit = userPermit;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getSpotID() {
		return spotID;
	}


	public void setSpotID(String spotID) {
		this.spotID = spotID;
	}


	public void  validateReservation(String action, Reservation reservation, ReservationErrorMsgs errorMsg){
		if(action.equalsIgnoreCase("searchP")){
			errorMsg.setTimeError(validateTime(action, reservation.getStarttime(),reservation.getEndtime()));
			errorMsg.setErrorMsg(action);
		}
		if(action.equalsIgnoreCase("finalPayment")){
			errorMsg.setPermitError(validatePermit(action, reservation.getUserPermit(),reservation.getPermit()));
			errorMsg.setErrorMsg(action);
		}
		if(action.equalsIgnoreCase("EndPage")){
			System.out.println("here: " + reservation.getCardNumber() + " cvv: " + reservation.getCvv());
			errorMsg.setCardNumberError(validateCard(action, reservation.getCardNumber()));
			errorMsg.setCvvError(validateCVV(action, reservation.getCvv()));
			errorMsg.setErrorMsg(action);
		}
	}



	private String validateTime(String action, String starttime, String endtime) {
		String msg = "";
		StringBuilder currTime = new StringBuilder(java.time.LocalTime.now().toString());
		currTime.delete(4, currTime.length()-1);
		currTime.deleteCharAt(2);
		System.out.println(" IN VALIDATE TIME -> Starttime: " + starttime+" EndTime: "+ endtime + " Diff: " + (Integer.parseInt(endtime) <= Integer.parseInt(starttime))+ " Curren: " +currTime);
		if (Integer.parseInt(endtime) <= Integer.parseInt(starttime)){
			msg = "End time should be greater than start time";
		}
		else{
			if ((Integer.parseInt(endtime)-Integer.parseInt(starttime) > 300)){
				msg = "Duration of reservation cannot be greater than 3 hours";
			}
			else if((Integer.parseInt(currTime.toString())-Integer.parseInt(starttime) > 0)){
				msg = "Start time should be greater than Current time";
			}
		}
		return msg;
	}
	
	private String validatePermit(String action, String userPermit, String resPermit) {
		String msg= "";
		if (userPermit.equals("ACCESS") && !resPermit.equals("ACCESS")){
			msg = "ACCESS User can only book an Access Parking type";
		}
		else if(userPermit.equals("PREMIUM") && resPermit.equals("ACCESS")){
			msg = "PREMIUM User cannot book an  Access Parking type";
		}
		else if (userPermit.equals("MIDRANGE") && (resPermit.equals("ACCESS") || resPermit.equals("PREMIUM"))){
			msg = "MIDRANGE User cannot book an "+ resPermit +" Parking type";
		}
		else if (userPermit.equals("BASIC") && !resPermit.equals("BASIC")){
			msg = "BASIC User can only book an BASIC Parking type";
		}
		return msg;
	}
	
	private String validateCard(String action, String number){
		String msg = "";
		if(number.equals("") || number.length()==0){
			msg = "Please provide your Card number";
		}
		
		else if(number.length()!=16){
			msg = "Card number should be 16 characters long.";
		}
		else if (!isTextAnInteger(number)){
			msg="Card Number must be a number";
			}
		return msg;
	}
	
	private String validateCVV(String action, String number) {
		String msg = "";
		if(number.equals("") || number.length()==0){
			msg = "Please provide your CVV number";
		}
		else if (!isTextAnInteger(number)){
			msg="CVV must be a number";
			}
		return msg;
	}
	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
}
