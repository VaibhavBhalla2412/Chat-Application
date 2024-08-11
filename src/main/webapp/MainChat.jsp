<%@page import="java.sql.*"%>
<%
	String path=application.getRealPath("/");
	String username=(String)session.getAttribute("username");
%>
<%-- <% --%>
<%-- 	Connection c=(Connection)application.getAttribute("connection"); --%>
<%-- 	PreparedStatement ps=null; --%>
<%-- 	ps=c.prepareStatement("select * from groups"); --%>
<%-- 	ResultSet rs=ps.executeQuery(); --%>
<%--  %> --%>

<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home</title>
<%-- 			<link rel="shortcut icon" href="../favicon.ico"> --%>
<%-- 		<link rel="stylesheet" type="text/css" href="css/normalize.css" /> --%>
<%-- 		<link rel="stylesheet" type="text/css" href="css/demo.css" /> --%>
<%-- 		<link rel="stylesheet" type="text/css" href="css/component.css" /> --%>
<%-- 		<script src="js/modernizr.custom.js"></script> --%>

<%-- 		<style> --%>

<%-- #roomchat{background-color:white; height:300px; width:20%; margin-top:-28%;margin-left:79%; --%>
<%-- border-width: 2px 4px 4px 4px; --%>
<%-- border-style: solid; --%>
<%-- border-radius: 20px; --%>
<%-- border-right-width: 10px; --%>
<%-- border-color: #ff0000 #00ff00 #0000ff rgb(250,0,255); --%>



<%-- ul li a:link { --%>
<%--     color: red; --%>

<%-- ul li a:hover { --%>
<%--     color: hotpink; --%>
<%-- } --%>


<%-- ul li a:active { --%>
<%--     color: blue; --%>
<%-- } --%>



<%-- </style> --%>

	</head>
	<body>
	<%
		if(username==null)
			response.sendRedirect("Login.jsp");
	%>
		<div >
			<ul id="gn-menu" >
				<!--<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>Menu</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">

								<li><a class="gn-icon gn-icon-download">P</a></li>
								<li><a class="gn-icon gn-icon-cog">Go To Chat</a></li>
								<li><a class="gn-icon gn-icon-help">Change Password</a></li>
								<li><a class="gn-icon gn-icon-help">LOG Out</a></li>

							</ul>
						</div>

					</nav>
				</li>-->

				<li><a href="MainChat.jsp"><span style="color:red;"><%=username%></span></a></li>
				<li><a href="ChatWindow.jsp">Global Chat</a></li>
<%-- 				<li><a href="change_password_form.jsp"><span>Change Password</span></a></li> --%>

<%-- 				<li><a class="codrops-icon codrops-icon-drop" href="profile_update.jsp"><span>Update Profile</span></a></li> --%>
				<li><a href="ListonlineUsers.jsp"><span>Private Chat</span></a></li>
                <li>Rooms
                    <%
                    out.println("<select name='RoomName'>");
//                     while (rs.next()) {
//                         String RoomName = rs.getString("RoomName");
//                         out.println("<option value='" + RoomName + "'>" + RoomName + "</option>");
//                     }
                    out.println("<option value='testRoom'> testRoom</option>");
                    out.println("</select>");
                    %>
                    </li>

				<li><a href="Logout.jsp"><span>Log Out</span></a></li>
			</ul>
<%-- 			<header> --%>
<%-- 			<h1>Welcome To WebChat</h1> --%>
<%-- 			</header> --%>
<%-- <table style="background-color:#34495e; margin-top:-7%; margin-right:40%; border-color: navy" align="center" border="0"> --%>
<%-- <tr> --%>
<%-- <td colspan="3" align="center"> --%>
<%-- <br><br><Br> --%>
<%-- <img src="<%=path %>" width="300px" height="220px"> --%>
<%-- </td> --%>

<%-- </tr> --%>

<%-- <tr> --%>
<%-- <td><form action="../change_picture.jsp" method="post" enctype="multipart/form-data"><input type="file" value="Take" name="file"/><input type="submit" value="Change"></form></td> --%>

<%-- </tr> --%>
		</div><!-- /container -->


<%-- 		<script src="js/classie.js"></script> --%>
<%-- 		<script src="js/gnmenu.js"></script> --%>
<%-- 		<script> --%>
<%-- 			new gnMenu( document.getElementById( 'gn-menu' ) ); --%>
<%-- 		</script> --%>
<%-- 		<div id="roomchat"> --%>
<%-- 		<ul> <li> Group CHAT</li> --%>
<%-- <ul> <li> <a  href="create_group_form.jsp">Create Group --%>
<%-- </a> --%>
<%-- </li> --%>
<%-- <ul> --%>
<%-- <% --%>
<%-- while(rs.next()) --%>
<%-- { --%>
<%-- 		String gname=rs.getString(1); --%>
<%-- %> --%>
<%--  <li> <a  href="group_chat_frame.jsp?gname=<%=gname%>"><%=gname %></a></li> --%>
<%-- <% --%>
<%-- } --%>
<%--  %> --%>
<%-- <br> --%>
<%-- </ul> --%>
<%-- </div> --%>
        <p> The Chat Web Application. </p>
	</body>

</html>