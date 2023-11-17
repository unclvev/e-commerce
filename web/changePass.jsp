<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,600,0,0" />
    <title>Login Page</title>
    <style>
        .error-message {
            color: red;
        }
    </style>
</head>

<body>

    <div class="login-card-container">
        <div class="login-card">
            <div class="login-card-logo">
                <img src="logo.png" alt="logo">
            </div>
            <div class="login-card-header">
                <h1>KARMA SHOP</h1>
                <div id="errorMessage"></div>
            </div>
            
            <form action="change" method="post" class="login-card-form" onsubmit="return changePassword();">
                <div class="form-item">
                    <span class="form-item-icon material-symbols-rounded">person</span>
                    <input name="old" type="text" placeholder="Enter Your password" id="userNameForm" 
                           autofocus required>
                </div>               
                <div class="form-item">
                    <span class="form-item-icon material-symbols-rounded">lock</span>
                    <input name="new" type="password" placeholder="Enter new Password" id="passwordForm"
                           required>
                </div>
                <div class="form-item">
                    <span class="form-item-icon material-symbols-rounded">lock</span>
                    <input name="repass" type="password" placeholder="Repeat your new password" id="RePasswordForm"
                           required>
                </div>
                
                <button type="submit">Change</button>
            </form>
            
            <p class="loginhere">
                Change your mind? <a href="home" class="loginhere-link">Home</a>
            </p>
        </div>
        
    </div>

    <script>
        function changePassword() {
            var oldPass = document.getElementById("userNameForm").value;
            var newPass = document.getElementById("passwordForm").value;
            var repPass = document.getElementById("RePasswordForm").value;

            // Kiểm tra logic thay đổi mật khẩu ở đây
            // ...

            if (newPass !== repPass) {
                document.getElementById("errorMessage").innerHTML = "<span class='error-message'>Please enter matching passwords.</span>";
                return false; // Ngăn không gửi form
            } else {
                // Gửi form và hiển thị thông báo thành công
                alert("Password changed successfully.");
                return true; // Cho phép gửi form
            }
        }
    </script>

</body>

</html>
