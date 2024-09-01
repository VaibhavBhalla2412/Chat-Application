<%@page import="java.sql.*"%>
<%
	String path=application.getRealPath("/");
	String username=(String)session.getAttribute("username");
%>


<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>

        <script>
            function changeRoom(element){
                String roomName = element.innerText;
                document.getElementById("changeRoomForm").getElementById("roomName").innerText = roomName;
                document.getElementById("changeRoomForm").submit();
            }
        </script>

	</head>
	<body>
	<%
		if(username==null)
			response.sendRedirect("Login.jsp");
	%>
	<%
	    List<String> chatRooms = (List<String>) request.getAttribute("chatRooms");
	%>

	<form action="ChatEndPoint" method="POST" style="display: none;" id = "changeRoomForm">
        <input id="roomName" value="">
    </form>

		<div >
			<ul id="gn-menu" >

				<li><a href="MainChat.jsp"><span style="color:red;"><%=username%></span></a></li>
				<form action="ChatEndpoint" method="POST">

				</form>
				<li onlclick="ChangeRoom(this)">Global Chat</li>
				<li><a href="ListonlineUsers.jsp"><span>Private Chat</span></a></li>
                <h3>Available Rooms</h3>
                    <ul>
                        <% if (chatRooms != null) { %>
                            <% for (String room : chatRooms) { %>
                <%--             window.location.href='chatroom.jsp?room=<%= room %>' --%>
                                <li onclick="changeRoom(this)">
                                    <%= room %>
                                </li>
                            <% } %>
                        <% } %>
                    </ul>

				<li><a href="Logout.jsp"><span>Log Out</span></a></li>
			</ul>

        <p> The Chat Web Application. </p>
	</body>

</html>