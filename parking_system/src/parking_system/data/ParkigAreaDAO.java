package parking_system.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import parking_system.model.ParkingArea;

import parking_system.util.SQLConnection;

public class ParkigAreaDAO {
	
static SQLConnection DBMgr = SQLConnection.getInstance();
public static final int MYSQL_DUPLICATE_PK = 1062;
public static boolean isDuplicate = false;
	
private static ArrayList<ParkingArea> ReturnMatchingParkingAreaList (String queryString) {
		ArrayList<ParkingArea> parkingAreaListInDB = new ArrayList<ParkingArea>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
	try {
		stmt = conn.createStatement();
		ResultSet parkingAreaList = stmt.executeQuery(queryString);
		while (parkingAreaList.next()) {
			ParkingArea parkingArea = new ParkingArea(); 
			parkingArea.setParking_area_name(parkingAreaList.getString("setParking_area_name"));
			parkingArea.setType(parkingAreaList.getString("type"));
			parkingArea.setfloor(parkingAreaList.getString("floor"));
			parkingArea.setCapacity(parkingAreaList.getString("capacity"));
			
			//System.out.println(user.getCompany_name()+" "+company.getIdcompany());
			parkingAreaListInDB.add(parkingArea);	
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
	return parkingAreaListInDB;
	}
		
	private static void StoreListinDB (ParkingArea parkingArea,String queryString) {
		String result = "";
		Statement stmt = null;
		isDuplicate = false;
		Connection conn = SQLConnection.getDBConnection();  
		
		
		
		try {
			
		
		
			stmt = conn.createStatement();
				
			String insertParkingArea = queryString + " VALUES ('"  
					+ parkingArea.getParking_area_name() + "','"
					+ parkingArea.getType() + "','"
					+ parkingArea.getfloor() + "','"
					+ parkingArea.getCapacity() + "','"
					+ '0'+ "','"
					+ parkingArea.getCapacity() + "')"
					;
		
			
			
			System.out.println(insertParkingArea);
			
			stmt.executeUpdate(insertParkingArea);
		
			conn.commit(); 
			
			System.out.println("Success: " +insertParkingArea);
		} catch (SQLException e) {
			
			System.out.println(e);
			
			if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
		        //duplicate primary key 
				System.out.println("Duplicate ParkingArea");
				isDuplicate = true;
		    }
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
	}
	
	public static void insertParkingArea(ParkingArea parkingArea) {  
		
		
		
		StoreListinDB(parkingArea,"INSERT INTO PARKING_DETAILS (parking_area_name,type,floor,capacity,reserved,available) ");
	}
	
	
	
}
