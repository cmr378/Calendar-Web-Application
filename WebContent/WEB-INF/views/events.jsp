<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.adbCaseStudy.entities.Event"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/de944cbc0a.js" crossorigin="anonymous"></script>
<style type="text/css">
	<%@include file="/resources/css/events.css"%>
</style>
<meta charset="UTF-8">
<title>
<%   
	String name = (String)session.getAttribute("email"); 
	out.print(name.toString() + " Events");  
%>
</title>
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
   
   <% List<Event> events = (List<Event>)session.getAttribute("events");
   %>
      
   <div class = "container-fluid">
   	<c:forEach items="${events}" var="event">
   	<div class = "row" id = "event-card">
   	 <div class = "col">
   	 	<h4>Title:</h4> <span><c:out value="${event.getTitle()}"/></span>
  	 </div>
  	 <div class = "col">
   	 	<h4>Location:</h4>  <span><c:out value="${event.getLocation()}"/></span>
  	 </div>
  	  <div class = "col">
   	 	<h4>Description:</h4> <p><c:out value="${event.getDescription()}"/></p>
  	 </div>
 	 <div class = "col">
   	 	<h4>Creator:</h4>  <span><c:out value="${event.getTitle()}"/></span>
  	 </div>
  	 <div class ="update delete">
  	 	<form:form method = "get" action = "deleteEvent" >
  	 		<input name = "id" value ="${event.getId()}">
  	 		<button type = "submit"><i class="fas fa-minus"></i></button>
  	 	</form:form>
	</div>
   	</div>
   	</c:forEach>
   </div>

</body>
</html>