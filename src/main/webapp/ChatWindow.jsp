<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="websocket.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title><%= request.getAttribute("roomName") %> - Chat Room</title>


</head>
<body>

<%
    // these attributes are set in chatEndpoint servlet before forwarding to this jsp.
    String chatRoomName = (String) request.getAttribute("roomName");
    int roomId = (int) request.getAttribute("roomId");
    String userName = (String) request.getAttribute("userName");
    List<String> chatRooms = (List<String>) request.getAttribute("chatRooms");
    List<String> members = (List<String>) request.getAttribute("members");
%>

<input type="hidden" id="userName" value="<%= userName %>">
<input type="hidden" id="chatRoomName" value="<%= chatRoomName %>">
<input type="hidden" id="roomId" value="<%= roomId %>">

<form action="ChatEndPoint" method="POST" style="display: none;" id = "changeRoomForm">
    <input id="roomName" value="">
</form>

<div class="rooms-list">
    <a href="ListOnlineUsers.jsp"><span>Private Chat</span></a>
    <h3>Available Rooms:</h3>
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
</div>

<div class="chat-container">
    <div class="chat-header">
        <%= chatRoomName %> - Chat Room
    </div>
    <div id="chat-window" class="chat-window">
        <!-- Messages will appear here -->
    </div>
    <div class="input-container">
        <input type="text" id="message-input" placeholder="Type a message..." onkeydown="if(event.keyCode === 13) sendMessage()">
        <button onclick="sendMessage()">Send</button>
    </div>
</div>

<div class="members-list">
    <h3>Group Members:</h3>
    <ul>
        <% if (members != null) { %>
            <% for (String member : members) { %>
                <li><%= member %></li>
            <% } %>
        <% } %>
    </ul>
</div>

</body>
</html>
