<%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 31.10.2019
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Repositories.UserRep" %>
<%@ page import="models.Answer" %>
<link rel="icon" href="css/logo.jpg">
<!doctype html>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Jekyll v3.8.5">
  <title>
    Web Solution Checker
  </title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="./css/bootstrap.css">
  <link href="./css/bootstrap2.css">
  <script src="./javascript/jquery2.js"></script>
  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
    }
    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>
  <link rel="stylesheet" type="text/css" href="style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <%
    User user = (User) session.getAttribute("user");
    UserRep userRep = new UserRep();
  %>
</head>
<body style="background-color:#7FDEFF;">
<nav class="navbar" style="background-color: #FFBF45;">
  <a class="navbar-brand" width="30" height="30" class="d-inline-block align-top">
    Web Solution Checker
  </a>
  <span style="color: #1a1a1d" class="navbar-text col-0">
      <%=user.getEmail()%>
    </span>
  <form class="form-inline my-2 my-lg-0" action="/wsc/Logout" method="post">
    <button type="submit" class="btn btn-secondary">Выйти</button>
  </form>
</nav>
<main role="main">
  <div class="container">
    <div class="row">
      <div class="col-lg-6">
        <form action="/wsc/Calculations" id="calculation">
          <div class="w-75 p-3" class="input-group">
            <input type="hidden" name="id" value="<%=user.getId()%>">
            <select name="type" class="custom-select" id="exampleFormControlSelect1" style="visibility: visible;">
              <option value="LS34">Низкая скорость (3G\4G)</option>
              <option value="LS3">Низкая скорость 3G</option>
              <option value="LS4">Низкая скорость 4G</option>
              <option value="PR234">Слабые уровни сигнала (2G\3G\4G)</option>
              <option value="PR23">Слабый сигнал (2G\3G)</option>
              <option value="D4">Обрывы на 4G</option>
              <option value="D23">Обрывы при разговоре (2G\3G)</option>
              <option value="Q23">Качество связи (2G\3G)</option>
              <option value="None" selected>Выберите тип жалобы</option>
            </select>
            <input name="phone_numb" type="text" class="form-control" placeholder="# телефона" aria-label="Recipient's username" aria-describedby="basic-addon2" style="margin-top: 1%;">
            <input name="req_num" type="text" class="form-control" placeholder="# заявки" aria-label="Recipient's username" aria-describedby="basic-addon2" style="margin-top: 1%;">
            <input name="LatLon" type="text" class="form-control" placeholder="координаты°" aria-label="Recipient's username" aria-describedby="basic-addon2" style="margin-top: 1%;">
            <%String error = request.getParameter("error");
              if(error!=null){
                if(error.equals("1"))
                  out.write("<p style=\"color: red\">Check input values </p>");
              }
            %>
            <div class="input-group-append">
              <button style="color:#83FF76; margin-top: 3%; margin-left: 79%;" class="btn btn-secondary" id="send" type="submit">Искать</button>
            </div>
            <div>
              <% if (user.getGroup().equals("performance") && request.getAttribute("secretAnswers") != null) {
                ArrayList<String> secrets = (ArrayList<String>) request.getAttribute("secretAnswers");
                for (String s : secrets) {
                  out.write("<p>" + s + "</p>");
                }
              }else if(!user.getGroup().equals("performance") && request.getAttribute("secretAnswers") != null) {
                ArrayList<String> secrets1 = (ArrayList<String>) request.getAttribute("secretAnswers");
                for (String s : secrets1) {
                  out.write("<p>" + s + "</p>");
                }
              }
              %>
            </div>
          </div>
        </form>
      </div>
      <div class="col-lg-6">
        <%
          ArrayList<Answer> answers = userRep.getAnswers(user.getId());
          if (answers.size() == 0) {
        %>
        <h3 style="margin: 2%">Список ответов пуст</h3>
        <%
        } else {
          for (int i = 0 ; i <= answers.size() - 1; i++) {
        %>
        <form action="/wsc/deleteAnswer">
          <button type="submit" class="close" aria-label="Close">
            <span style="color: black" aria-hidden="true">&times;</span>
          </button>
          <div class="container">
            <div class="row">
              <div class="col-lg-12" style="margin-top: 2%; border-block-color: black;">
                <p>#<%=answers.get(i).getRequest_number()%></p>
                <p><%="("+answers.get(i).getDateAnsw()+")"%></p>
                <p style="font-weight: bold"><%=answers.get(i).getAnswer_type()%></p>
                <p><%=answers.get(i).getPhone_number()%></p>
                <p><%=answers.get(i).getLatitude() + " " + answers.get(i).getLongitude()%></p>
                <input type="hidden" name="id" value="<%=answers.get(i).getId()%>">
              </div>
            </div>
          </div>
        </form>
        <%
            }
          }
        %>
        </div>
    </div>
  </div>
</main>
<script>
  $(document).ready(function () {
    $("#calculation").submit(function () {
      $("#send").attr("disabled", true);
      return true;
    });
  });
</script>
<script src="./javascript/jquery.js"></script>
<script src="./javascript/ajax.js"></script>
<script src="./javascript/bootsrap.js"></script>
<script src="./javascript/jquery3.js"></script>
<script>window.jQuery || document.write('<script src="./javascript/jslim.js"><\/script>')</script>
<script src="./javascript/bundle.js"></script>
</body>
</html>

