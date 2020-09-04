<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/de944cbc0a.js" crossorigin="anonymous"></script>
    <style type="text/css">
  		<%@include file="/resources/css/u2.css"%>
	</style>
    <title>Welcome</title>
  </head>
  <body>
  
    <nav class="navbar navbar-expand-lg navbar-light">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand">
          <i class="fas fa-spinner"></i>
          Hangout
        </a>
        <ul class="navbar-nav mr-auto">
        </ul>
        <ul class="navbar-nav" id = "nav-tools">
          <li class="nav-item">
            <a class="nav-link" href="events">
              <i class="far fa-calendar" title = "Show All Events"></i>
            </a>
          </li>
          <li class="nav-item">
          <div></div>
            <a class="nav-link dropdown" href="logout">
              <i class="fas fa-door-open" title = "Logout"></i>
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container-fluid" id = "calendar">
      <div class="row">
        <div class="col" id = "monthInfo">
            <h1 id = "resetMonth" onclick="resetMonth()">Today</h1>
            <i class="fas fa-caret-left" id = "monthController1"></i>
            <i class="fas fa-caret-right " id = "monthController2"></i>
            <h1 id = "currMonth"></h1>
            <form id = "search" name = "search">
              <i class="fas fa-search" id = "searchbar" onclick = "searchMonth()"></i>
              <input type="number" placeholder="M" type="number" NAME="name" min="1" max="12"  onkeyup=enforceMinMax(this)  id = "controllerMonth">
              <input type="number" placeholder="DD" type="number" NAME="name" min="1" max="31" maxlength="2" onkeyup=enforceMinMax(this)  id = "controllerDate">
              <input type="number" placeholder="YR" type="number" NAME="name" min="1" max="3000" maxlength="2" onkeyup=enforceMinMax(this)  id = "controllerYear">
            </form>
        </div>
      </div>
      <div class="row" id = "weekdays">
        <div class="col">S</div>
        <div class="col">M</div>
        <div class="col">T</div>
        <div class="col">W</div>
        <div class="col">T</div>
        <div class="col">F</div>
        <div class="col">S</div>
      </div>
    </div>

    <div id="myModal" class="planner">
      <!-- Modal content -->
      <div class="planner-contents">
        <div class="close">
          &times;
        </div>
        <i class="fas fa-cloud" id = "weather-event"></i>
        <h3 id = "heading">Create Event</h3>
        <form:form method = "post" modelAttribute = "event" action = "createEvent" id = "event-planner">
          <input type="text" name="title" value="" placeholder="Title" size = "25" onblur = "this.placeholder = 'Title'" id = "eventName">
          <input type="text" name="location" value="" placeholder="Zip or City,State" size = "25" onblur = "this.placeholder = 'Zip or City,State'" id = "eventLocation">
          <input type="text" name="guests" value="" placeholder="Guests (optional)" size = "25" onblur = "this.placeholder = 'Guests (optional)'" id = "eventGuests">
          <input type="text" name="description" value="" placeholder="Description" size = "25" onblur = "this.placeholder = 'Description'" id = "event-description" >
    	  <div class = "row">
  	        <div class = "col">
  	        	<label style = "margin-right:1em;">From:</label>
           		<input type="datetime-local" name="startTime" value="" size = "25" id = "startTime">
          	</div>
          	<div class = "col">
          	  	<label style = "margin-right:2em;">To:</label>
        	    <input type="datetime-local" name="endTime" value="" size = "25" id = "endTime">   
          	</div>
          </div>
       	  <input value = "Create" type='submit' name = "create" id = "createEvent"/>    
        </form:form>
      </div>
    </div>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/calendar.js"></script>  
	</body>
</html>
