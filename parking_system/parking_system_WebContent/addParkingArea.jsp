<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Parking Area</title>
</head>
<body>
<input name="errMsg"  value='${errorMsgs.errorMsg}' type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
   <td>
    <form name="parkingAreaForm" action="/parking_system/ParkingAreaController?saveParkingArea" method="post">
    <table style="width: 1200px; ">
    
    <tr>
    <td> ParkingAreaname(*): </td>
    <td> <input name="parking_area_name" value='${parkingArea.parking_area_name}' type="text" maxlength="16"> </td>
    <td> <input name="userFirstNameError"  value='${errorMsgs.parkingAreaNameError}' type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

 	<tr>
    <td> Type(*): </td>
    <td> <input name="type" value='${parkingArea.type}' type="text" maxlength="16"> </td>
    </tr>

    <tr>
    <td> Floor(*): </td>
    <td> <input name="floor" value='${parkingArea.floor}' type="text" maxlength="16"> </td>
    </tr>

    <tr>
    <td> Capacity(*): </td>
    <td> <input name="capacity" value='${parkingArea.capacity}' type="text" maxlength="16"> </td>
    </tr>

	</td>
</tr>

</table>
<input name="action" value="saveParkingArea" type="hidden">
<input type="submit" value="Add Parking Area ">
</form>





</body>
</html>