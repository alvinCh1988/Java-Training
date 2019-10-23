<%@ page language="java" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>

<head>

  <title>Login</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

  <style>
    .main {
      margin-top: 10%;
      margin-left: 40%;
      margin-right: auto;
    }
    
     p {
      color: red;
    }
  </style>
</head>

<body>

	

  <div class="main">
    <div id="loginForm" style="width:25%;">
      <form method="post" action="/getAccount">
        <div class="form-group">
          <label for="iptAccount">User Name</label>
          <input type="text" class="form-control" name="accountName" id="iptAccount" >
          <p>${errorActMsg}</p>
        </div>
        <div class="form-group">
          <label for="iptPassword">Password</label>
          <input type="password" class="form-control" name="password" id="iptPassword">
          <p>${errorPwdMsg}</p>
        </div>

        <button type="submit" class="btn btn-primary" style="float: right">Login</button>

      </form>
    </div>
    <a href="<%=request.getContextPath() %>/register">註冊</a>

  </div>



  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>

</html>