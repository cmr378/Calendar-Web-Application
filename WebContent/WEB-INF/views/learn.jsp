<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style type="text/css">
	  <%@include file="/resources/css/learn.css"%>
	</style>   
	<link href="https://fonts.googleapis.com/css2?family=Muli:ital,wght@1,300;1,900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/de944cbc0a.js" crossorigin="anonymous"></script>
  </head>
  <body>

    <div class="container-fluid">
      <div class="row" id = "pageBody">
        <div class="col-lg-6 col-sm-12">
      <img class = "img-fluid" src="${pageContext.request.contextPath}/resources/imgs/group.png" alt="people hanging out">
        </div>
        <div class="col-lg-6 col-sm-12" id = "content">
          <nav class="navbar navbar-expand-lg navbar-light">
            <h4 id = "logo">
              <i class="fas fa-spinner"></i>
              <span>Hangout</span>
            </h4>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
              </ul>
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="login.html">Log In</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="create.html">Sign Up</a>
                </li>
              </ul>
            </div>
          </nav>
          <h3 id = "info-header">Not Your Ordinary Calendar</h3>
          <ul id = "info">
            <li>
              <div id = "cal-info">
                <i class="far fa-calendar"></i> -Have plans? Schedule any upcoming events you have with our calendar application.
              </div>
            </li>
            <li>
              <div id = "weather-info">
                <i class="fas fa-cloud"></i> - Going out? With the uncertain times we face, we understand the growing need for outdoor events. Create an event with Hangouts, click on the cloud icon, and we'll make sure to let you know whether or not mother nature made any unwanted changes leading up to the event.
              </div>
            </li>
            <li>
              <div id = "user-info">
                <i class="fas fa-user"></i> - Inviting others? Add guests to an event and they'll be notified and will be given an option to join the event if they would like. 
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </body>
</html>
    