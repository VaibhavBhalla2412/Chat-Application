<%@ page import="userDAO.UserDAO" %>
<%
    UserDAO user = new UserDAO();
    String username = (String)session.getAttribute("username");
    boolean isRemoved = user.removeUser(username);
    if(!isRemoved){
    request.setAttribute("error", "user "+ username + "not removed successfully.");
    }
	else{
	    session.invalidate();
	    request.setAttribute("error", "user "+ username + " removed successfully.");
	}
    request.getRequestDispatcher("Login.jsp").forward(request, response);
%>