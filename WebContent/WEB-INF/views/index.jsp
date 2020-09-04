<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css2?family=Muli:ital,wght@1,300;1,900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Myeongjo&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/de944cbc0a.js" crossorigin="anonymous"></script>
<style type="text/css">
  <%@include file="/resources/css/home.css"%>
</style>
<title>Home</title>
</head>

<body>

<div class="container-fluid">
  <div class="row" id = "pageBody">
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
              <a class="nav-link" href="index">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login">Log In</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="create">Sign Up</a>
            </li>
          </ul>
        </div>
      </nav>
      <h5 id = "p-head">Have Plans ?</h5>
      <p id = "description">
        <span id = "first-desc">Plan, Create, and Share</span>
        <span id = "second-desc">Everything you love to do.</span>
      </p>
      <h5 id = "p-foot">Want To Learn More ?
            <span id = "dropdown"> <a href="learn" style = "color: white; "> <i class="fas fa-chevron-down"></i></a></span>
        </h5>
    </div>
    <div class="col-lg-6 col-sm-12">
      <img class = "img-fluid" src="${pageContext.request.contextPath}/resources/imgs/home1.png" alt="people hanging out">
    </div>
  </div>
</div>
</body>
</html>