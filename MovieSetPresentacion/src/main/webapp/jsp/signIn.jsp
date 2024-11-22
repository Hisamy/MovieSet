<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign in</title>
        <link rel="shortcut icon" href="../images/icon.png" type="image/x-icon">
        <link rel="stylesheet" href="../css/sign-in.css">
    </head>
    <body>
        <div class="container">
            <div class="left-panel">
                <h1>ENTER YOUR ACCOUNT</h1>
                <form class="sign-in-form" method="POST" action="${pageContext.request.contextPath}/Login">            <div class="form-group">
                        <label for="email">E-mail</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <a href="#" class="forgot-password">Forgot your password?</a>
                    <button type="submit" class="sign-in-btn">SIGN IN</button>
                </form>
            </div>
            <div class="right-panel">
                <h2>HELLO AGAIN!</h2>
                <p>Welcome back, log in to your account</p>
                <div class="divider">
                    <span>Or</span>
                </div>

                <a class="create-account-btn" href="createAccount.jsp">
                    CREATE ACCOUNT
                </a>
            </div>
        </div>
    </body>
</html>