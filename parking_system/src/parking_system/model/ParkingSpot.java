package parking_system.model;

public class ParkingSpot {
	private static final long serialVersionUID = 3L;
	private String parkingSpotID = "";
	private int parkingspot;
	private String parkingAreaName = "";
	private String type = "";
	private int floor;
	private String availability="";
	private int capacity=0;
	private int reserved=0;
	private int available=0;
	private int starttime=0;
	private int endtime=0;
	private String reservationid="";
	
	
	
	public ParkingSpot() {
		this.parkingSpotID = "";
		this.parkingspot = 0;
		this.parkingAreaName = "";
		this.type = "";
		this.floor = 0;
		this.availability = "";
		this.capacity = 0;
		this.reserved = 0;
		this.available = 0;
		this.starttime = 0;
		this.endtime = 0;
		this.reservationid = "";
	}

	public void setParkingSpot(String parkingAreaName, String type, int floor,int capacity, int available) {
		setParkingAreaName(parkingAreaName);
		setType(type);
		setFloor(floor);
		setCapacity(capacity);
		setAvailable(available);
	}
	
	public void setParkingSpotFromDB(String parklingspotid, int parkingspot, String parkingAreaName, String type, int floor, String availability, int starttime, int endtime, String reservationid) {
		setParkingSpotID(parklingspotid);
		setParkingspot(parkingspot);
		setParkingAreaName(parkingAreaName);
		setType(type);
		setFloor(floor);
		setAvailability(availability);
		setStarttime(starttime);
		setEndtime(endtime);
		setReservationid(reservationid);
	}

	public String getParkingAreaName() {
		return parkingAreaName;
	}

	public void setParkingAreaName(String parkingAreaName) {
		this.parkingAreaName = parkingAreaName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getParkingSpotID() {
		return parkingSpotID;
	}

	public void setParkingSpotID(String parkingSpotID) {
		this.parkingSpotID = parkingSpotID;
	}

	public int getParkingspot() {
		return parkingspot;
	}

	public void setParkingspot(int parkingspot) {
		this.parkingspot = parkingspot;
	}

	public int getStarttime() {
		return starttime;
	}

	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}

	public int getEndtime() {
		return endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}

	public String getReservationid() {
		return reservationid;
	}

	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
