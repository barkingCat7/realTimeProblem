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
<title>Interpolated Series</title>
</head>
<body>


	<div class="limiter">
		<center>
			<h1 class="header">Interpolated Series Between Dates</h1>
			<div class="w3-bar w3-time-table">
				<a href="index" class="w3-bar-item w3-button">All Records</a> <a
					href="latest" class="w3-bar-item w3-button">Latest Value</a> <a
					href="average" class="w3-bar-item w3-button">Average Value</a> <a
					href="goodValues" class="w3-bar-item w3-button">Good Values</a> <a
					href="interpolated" class="w3-bar-item w3-button">Interpolated
					Series</a> <a href="simulate" class="w3-bar-item w3-button">Simulate
					New Data</a>
			</div>

		</center>

		<div class="container" align="center" style="margin-top: 100px">
			<form action="interpolated" method="post">

				<span class="mySpan"> Time 1 <input type="datetime-local"
					value="2000-06-12T00:00" name="time1">
				</span> <span class="mySpan"> Time 2 <input type="datetime-local"
					value="2018-06-12T00:00" name="time2">
				</span> <span class="mySpan"> Minute Intervals <input type="number"
					name="minutes" value="1000">
				</span>
				<button class="myButton" type="submit">Submit</button>
			</form>
		</div>



		<div class="container-table100">

			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<table data-vertable="ver1">
						<thead>
							<h3>List of Interpolated Records in this range:</h3>
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

							<c:forEach items="${data}" var="item">
								<c:forEach items="${item}" var="entry">
									<tr class="row100">

										<td class="column100 column1" data-column="column1"><c:out
												value="not Applicable" /></td>
										<td class="column100 column2" data-column="column2"><c:out
												value="${entry.key}" /></td>
										<td class="column100 column3" data-column="column3"><c:out
												value="not Applicable" /></td>
										<td class="column100 column4" data-column="column4"><c:out
												value="not Applicable" /></td>
										<td class="column100 column5" data-column="column5"><c:out
												value="${entry.value}" /></td>
									</tr>
								</c:forEach>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>


</body>
</html>