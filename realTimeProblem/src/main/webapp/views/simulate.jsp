<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/w3schools.css">
<title>Simulate</title>
</head>
<body>


	<div class="limiter">
		<center>
			<h1 class="header">Simulate New Data</h1>
			<div class="w3-bar w3-time-table">
				<a href="index" class="w3-bar-item w3-button">All Records</a> <a
					href="latest" class="w3-bar-item w3-button">Latest Value</a> <a
					href="average" class="w3-bar-item w3-button">Average Value</a>
					<a href="goodValues"	class="w3-bar-item w3-button">Good Values</a>  <a
					href="interpolated" class="w3-bar-item w3-button">Interpolated
					Series</a> <a href="simulate" class="w3-bar-item w3-button">Simulate
					New Data</a>
			</div>

		</center>

		<div class="container" align="center" style="margin-top: 100px">
			<form action="simulate" method="post">
				<span class="mySpan"> Simulate New Data</span>
				<input type="number" 
					name="records" value="10">
				<span class="mySpan">	Number of records</span>
				
				<label><button class="myButton" type="submit">Submit</button></label>
			</form>
		</div>

	</div>


</body>
</html>