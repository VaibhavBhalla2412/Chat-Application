<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script>
        function showError(message) {
            alert(message);
        }
    </script>
</head>
<body>
    <form action="Controller" method="POST">
        Username: <input type="text" name="username" required>
        <button type="submit">Login</button>
    </form>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <script>
            showError("<%= error %>");
        </script>
    <%
        }
    %>
</body>
</html>
