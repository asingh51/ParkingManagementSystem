package parking_system.model;

public class ReservationErrorMsgs {
	
	private String errorMsg = "";
	private String startTimeError = "";
	private String endTimeError = "";	
	private String timeError="";
	private String permitError= "";
	private String cardNumberError= "";
	private String cvvError = "";
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String action) {
		if(action.equalsIgnoreCase("searchP")){
			if (!startTimeError.equals("") || !endTimeError.equals("") || !timeError.equals("") || !permitError.equals(""))
				this.errorMsg = "Please correct the following errors";
		}
		if(action.equalsIgnoreCase("finalPayment")){
			if (!permitError.equals(""))
				this.errorMsg = "Please correct the following errors";
		}
		if(action.equalsIgnoreCase("EndPage")){
			if (!cardNumberError.equals("") || !cvvError.equals(""))
				this.errorMsg = "Please correct the following errors";
		}
	}
	public String getStartTimeError() {
		return startTimeError;
	}
	public void setStartTimeError(String startTime) {
		this.startTimeError = startTime;
	}
	public String getEndTime() {
		return endTimeError;
	}
	public void setEndTime(String endTime) {
		this.endTimeError = endTime;
	}
	public String getTimeError() {
		return timeError;
	}
	public void setTimeError(String timeError) {
		this.timeError = timeError;
	}
	public String getPermitError() {
		return permitError;
	}
	public void setPermitError(String permitError) {
		this.permitError = permitError;
	}
	public String getCardNumberError() {
		return cardNumberError;
	}
	public void setCardNumberError(String cardNumberError) {
		this.cardNumberError = cardNumberError;
	}
	public String getCvvError() {
		return cvvError;
	}
	public void setCvvError(String cvvError) {
		this.cvvError = cvvError;
	}
}
