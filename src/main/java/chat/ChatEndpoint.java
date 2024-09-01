package chat;
import models.Message;
//import userDAO.*;
import MessageDAO.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ChatEndpoint extends HttpServlet {
    MessageDAO messageDAO;
    @Override
    public void init(){
        messageDAO = new MessageDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomName = request.getParameter("roomName");
        if(roomName == "Global Chat"){
            List<Message> messages = messageDAO.getAllMessages(roomName);

        }

    }

}