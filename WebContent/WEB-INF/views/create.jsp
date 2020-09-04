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
    <script src="https://kit.fontawesome.com/de944cbc0a.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Muli:ital,wght@1,300;1,900&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <style type="text/css">
		<%@include file="/resources/css/create.css"%>
	</style>
    <title>Log In</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg">
      <h4 id = "logo">
        <a href="index">Hang<span>out</span></a>
      </h4>
    </nav>

    <div class="container-fluid" id = "signup">
      <div class="row justify-content-center">
        <div class="col-lg-6" id = "bor-row">
          <h3 id = "heading">Create Account</h3>
          <form:form method = "post" modelAttribute = "userForm" class = "form-block justify-content-center">
            <input type="email" class = "userinput" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur = "this.placeholder = 'Email'" onkeydown="limit(this);" onkeyup="limit(this);">
            <form:errors path = "email" cssClass = "textDanger"/>
            <input type="password" class = "userinput" id = "firstPass" name="firstPass" placeholder="Password"  onfocus="this.placeholder = ''" onblur = "this.placeholder = 'Password'">
            <input type="password" class = "userinput" id = "secondPass" name="secondPass" placeholder="Confirm Password"  onfocus="this.placeholder = ''" onblur = "this.placeholder = 'Confirm Password'">
            <input type = "submit" value = "Register" name = "login" id = "button">
          </form:form>
        </div>
        <div class="col-lg-6">
          <img class = "img-fluid" src="${pageContext.request.contextPath}/resources/imgs/gathering.svg" alt="">
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/create.js"></script>  
</html>