<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

  <title>Login Sucess</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

  <style>
    .main {
      margin-top: 10%;
      margin-left: 35%;
      margin-right: auto;
    }
  </style>
</head>

<body onload="ShowTime()">


  <div class="main">

    <h4>現在時間</h4>
    <h5 id="showTimeDiv"></h5>
    <br>
    <h4 id="userName">${account} 您好</h4>
    <h4>恭喜你! 登入成功</h4>

  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>

<script>
  var showTimeDiv = document.getElementById('showTimeDiv');

  function ShowTime() {
    showTimeDiv.innerHTML = new Date();
    setTimeout('ShowTime()', 1000);
  }
</script>

</html>