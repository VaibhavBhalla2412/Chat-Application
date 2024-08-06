package userDAO;
import jakarta.servlet.http.HttpSession;
import models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {


    public boolean addUser(String name, HttpSession session){
        User user = new User();
        user.setName(name);
        user.setsessionId(session);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb", "root", "password")) {
//            String checkSql = "SELECT username FROM users WHERE username = ?";
//            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
//            checkStatement.setString(1, username);
//            ResultSet resultSet = checkStatement.executeQuery();
//
//            if (resultSet.next()) {
//                return false;
//            }
//            String sql = "INSERT INTO users (username, session_id) VALUES (?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, username);
//            statement.setString(2, session.getId());
//            statement.executeUpdate();
//
//            session.setAttribute("username", username);
//            response.sendRedirect("chat.jsp");
//
//        } catch (SQLException e) {
//            throw new ServletException("Database error", e);
//        }


        return true;
    }

    public boolean removeUser(String name){

        return true;
    }

}
