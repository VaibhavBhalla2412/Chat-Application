<%@ page import="userDAO.UserDAO" %>
<%@ page import="" %>
<%
    UserDAO user = new UserDAO();
    String username = (String)session.getAttribute("username");
    boolean isRemoved = user.removeUser(username);
    if(!isRemoved){
    request.setAttribute("error", "user "+ username + "not removed successfully.");
    }
	else{
	    session.invalidate();
	}
    request.getRequestDispatcher("Login.jsp").forward(request, response);
%>