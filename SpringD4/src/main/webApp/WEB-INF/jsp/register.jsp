<!-- <%@ page language="java" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>

<head>

    <title>Register</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

</head>

<body>
    <div class="container" style="margin-top: 5%">
        <div class="row">
            <div class="col-4">
                <form  enctype="multipart/form-data" method="post" action="/insert">
                    <div class="form-group">
                        <label for="iptLastName">姓</label>
                        <input type="text" class="form-control" id="iptLastName" name="lastName">
                    </div>


                    <div class="form-group">
                        <label for="iptFirstName">名</label>
                        <input type="text" class="form-control" id="iptFirstName" name="firstName">

                    </div>

                    <div class="form-group">
                        <label for="iptAccount">User Name</label>
                        <input type="text" class="form-control" id="iptAccount" name="account">

                    </div>

                    <div class="form-group">
                        <label for="iptPassword">Password</label>
                        <input type="password" class="form-control" id="iptPassword" name="password">
                    </div>


                    <div class="form-group">
                        <input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="file" />

                    </div>

                    <br>

                    <button type="submit" class="btn btn-primary">註冊</button>

                </form>
            </div>

            <div class="col-5" style="width:300px; height: 300px;">
                <img id="preview_progressbarTW_img" src="#" />
            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>


<script>
    $("#progressbarTWInput").change(function () {
        readURL(this);
    });

    function readURL(input) {

        if (input.files && input.files[0]) {

            var reader = new FileReader();
            reader.onload = function (e) {
                $("#preview_progressbarTW_img").attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>

</html>