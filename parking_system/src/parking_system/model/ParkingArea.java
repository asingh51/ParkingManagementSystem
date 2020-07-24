package parking_system.model;

public class ParkingArea {

	private static final long serialVersionUID = 3L;
	private String parking_area_name = "";
	private String type = "";
	private String floor = "";
	private String capacity = "";
	public String getParking_area_name() {
		return parking_area_name;
	}

	public void setParking_area_name(String parking_area_name) {
		this.parking_area_name = parking_area_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	
	public String getfloor() {
		return floor;
	}

	public void setfloor(String floor) {
		this.floor = floor;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}



	
	public void setParkingArea(String parking_area_name, String type, String floor, String capacity) {
		setParking_area_name(parking_area_name);
		setType(type);
		setfloor(floor);
		setCapacity(capacity);
		
	}



	
		
}
