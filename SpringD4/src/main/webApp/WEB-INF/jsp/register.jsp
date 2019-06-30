<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.yao.springD4.model.*"%>

<%
 AccountVO actVO = (AccountVO) request.getAttribute("accountVO");
%>

<!DOCTYPE html>
<html>

<head>
    <title>Register</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    
    <style>
    p {
      color: red;
    }
  </style>
</head>

<body onload="checkStatus()">

	<div id="reStatus" hidden="true">
		${status}
	</div>

	
    <div class="container" style="margin-top: 5%">
        <div class="row">
            <div class="col-4">
                <form  enctype="multipart/form-data" method="post" action="/insert">
                    <div class="form-group">
                        <label for="iptLastName">姓</label>
                        <input type="text" class="form-control" id="iptLastName" name="lastName" value="<%= (actVO==null)? "" : actVO.getLastName()%>" >
                    </div>


                    <div class="form-group">
                        <label for="iptFirstName">名</label>
                        <input type="text" class="form-control" id="iptFirstName" name="firstName" value="<%= (actVO==null)? "" : actVO.getFirstName()%>">

                    </div>

                    <div class="form-group">
                        <label for="iptAccount">User Name</label>
                        <input type="text" class="form-control" id="iptAccount" name="account" value="<%= (actVO==null)? "" : actVO.getAccount()%>">
						<p>${accountMsg}</p>
                    </div>

                    <div class="form-group">
                        <label for="iptPassword">Password</label>
                        <input type="password" class="form-control" id="iptPassword" name="password">
                    </div>


                    <div class="form-group">
                        <input type="file" id="progressbarInput" accept="image/gif, image/jpeg, image/png" name="file" />

                    </div>

                    <br>

                    <button type="submit" class="btn btn-primary">註冊</button>

                </form>
            </div>

            <div class="col-5" style="width:300px; height: 300px;">
                <img id="preview_progressbar_img" src="#" />
            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>


<script>

	function checkStatus() {

		var status = document.getElementById("reStatus");

		if (status.innerHTML.trim() === "success") {
			alert("註冊成功");
			window.location.href = '/login';
		}
	}

	$("#progressbarInput").change(function() {
		readURL(this);
	});

	function readURL(input) {

		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview_progressbar_img").attr('src', e.target.result);
			}
			
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

</html>