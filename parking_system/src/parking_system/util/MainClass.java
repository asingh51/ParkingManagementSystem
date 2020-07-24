package parking_system.util;

import java.sql.*;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/parking_system?useSSL=false";
		String uname = "root";
		String pass = "rootcanal";

		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
	
		for(int i=1;i<=250;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "	5FB"+i	 + "','"
				+ 	i	 + "','"
				+ "West Garage"	 + "','"
				+ "BASIC" + "','"
				+ "5" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		
		
		for(int i=1;i<=250;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "WG4FM"+i	 + "','"
				+ 	i	 + "','"
				+ "West Garage"	 + "','"
				+ "MIDRANGE" + "','"
				+ "4" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		for(int i=1;i<=250;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "WG3FM"+i	 + "','"
				+ 	i	 + "','"
				+ "West Garage"	 + "','"
				+ "MIDRANGE" + "','"
				+ "3" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		for(int i=1;i<=250;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "WG2FM"+i	 + "','"
				+ 	i	 + "','"
				+ "West Garage"	 + "','"
				+ "MIDRANGE" + "','"
				+ "2" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		for(int i=1;i<=230;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "WG1FP"+i	 + "','"
				+ 	i	 + "','"
				+ "West Garage"	 + "','"
				+ "PREMIUM" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		for(int i=1;i<=20;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "WG1FA"+i	 + "','"
				+ 	i	 + "','"
				+ "West Garage"	 + "','"
				+ "ACCESS" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		for(int i=1;i<=200;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "MV1FB"+i	 + "','"
				+ 	i	 + "','"
				+ "Maverick"	 + "','"
				+ "BASIC" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		for(int i=1;i<=20;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "MV1FA"+i	 + "','"
				+ 	i	 + "','"
				+ "Maverick"	 + "','"
				+ "ACCESS" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		for(int i=1;i<=150;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "DV1FB"+i	 + "','"
				+ 	i	 + "','"
				+ "Davis"	 + "','"
				+ "BASIC" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		
		for(int i=1;i<=20;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "DV1FA"+i	 + "','"
				+ 	i	 + "','"
				+ "Davis"	 + "','"
				+ "ACCESS" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		for(int i=1;i<=180;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "ND1FB"+i	 + "','"
				+ 	i	 + "','"
				+ "Nedderman"	 + "','"
				+ "BASIC" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		for(int i=1;i<=20;i++)
		{
		String insertParkingArea = "INSERT INTO PARKINGSPOT_DETAILS "+ " VALUES ('"  
				+ "ND1FA"+i	 + "','"
				+ 	i	 + "','"
				+ "Nedderman"	 + "','"
				+ "ACCESS" + "','"
				+ "1" + "','"
				+ "AVAILABLE"+"',0,0,null" + ")";
		
		System.out.println(insertParkingArea);
		st.executeUpdate(insertParkingArea);
		}
		
		
		
		
		
		st.close();
		con.close();
		
	}
	
}

