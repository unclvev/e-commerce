<%-- 
    Document   : register
    Created on : Jun 25, 2023, 6:02:29 AM
    Author     : viet2
--%>

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
    </head>

    <body>

        <div class="login-card-container">
            <div class="login-card">
                <div class="login-card-logo">
                    <img src="logo.png" alt="logo">
                </div>
                <div class="login-card-header">
                    <h1>Sign In</h1>
                    <div>Please login to use the platform</div>

                </div>
                
                <form action="VerifyCode" methode="post" class="login-card-form">
                    <div class="form-item">
                        <span class="form-item-icon material-symbols-rounded">person</span>
                        <input name="authcode" type="text" placeholder="Enter Your Code" id="userNameForm" 
                               autofocus required>
                    </div>                 
                    <button type="submit" value="verify">Sign In</button>
                </form>
                <p class="loginhere">
                    go home ? <a href="home" class="loginhere-link">Login here</a>
                </p>
            </div>
            <div class="login-card-social">
                <div>Other Sign-In Options</div>
                <div class="login-card-social-btns">
                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-brand-facebook"
                             width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none"
                             stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                        <path d="M7 10v4h3v7h4v-7h3l1 -4h-4v-2a1 1 0 0 1 1 -1h3v-4h-3a5 5 0 0 0 -5 5v2h-3"></path>
                        </svg>
                    </a>
                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-brand-google" width="24"
                             height="24" viewBox="0 0 24 24" stroke-width="3" stroke="currentColor" fill="none"
                             stroke-linecap="round" stroke-linejoin="round">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                        <path d="M17.788 5.108a9 9 0 1 0 3.212 6.892h-8"></path>
                        </svg>
                    </a>
                </div>
            </div>
        </div>

    </body>

</html>
