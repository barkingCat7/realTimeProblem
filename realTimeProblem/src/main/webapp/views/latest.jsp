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
<title>Latest Value</title>
</head>
<body>


	<div class="limiter">
		<center>
			<h1 class="header">Latest Value from Time Table</h1>
			<div class="w3-bar w3-time-table">
				<a href="index" class="w3-bar-item w3-button">All Records</a> 
				<a href="latest" class="w3-bar-item w3-button">Latest Value</a> 
				<a href="average"	class="w3-bar-item w3-button">Average Value</a> 
				<a href="goodValues"	class="w3-bar-item w3-button">Good Values</a> 
				<a href="interpolated"	class="w3-bar-item w3-button">Interpolated Series</a>
				<a href="simulate" class="w3-bar-item w3-button">Simulate New Data</a>
			</div>

		</center>
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<table data-vertable="ver1">
						<thead>
							<tr class="row100 head">
								<th class="column100 column1" data-column="column1">ID</th>
								<th class="column100 column2" data-column="column2">Date &
									Time</th>
								<th class="column100 column3" data-column="column3">Quality</th>
								<th class="column100 column4" data-column="column4">Units</th>
								<th class="column100 column5" data-column="column5">Value</th>

							</tr>
						</thead>
						<tbody>
								<tr class="row100">
									<td class="column100 column1" data-column="column1"><c:out
											value="${table.getId()}" /></td>
									<td class="column100 column2" data-column="column2"><c:out
											value="${table.getDateTime()}" /></td>
									<td class="column100 column3" data-column="column3"><c:out
											value="${table.getQuality()}" /></td>
									<td class="column100 column4" data-column="column4"><c:out
											value="${table.getUnits()}" /></td>
									<td class="column100 column5" data-column="column5"><c:out
											value="${table.getValue()}" /></td>
								</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


</body>
</html>