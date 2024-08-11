package userDAO;
import jakarta.servlet.http.HttpSession;
import models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {


    public boolean addUser(String name, HttpSession session){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            User user = new User();
            user.setName(name);
            user.setsessionId(session);
            entityManager.getTransaction().begin();
            if(entityManager.find(models.User.class, name) != null){
                return false;
            }
            else{
                entityManager.persist(user);
            }
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return true;
    }

    public boolean removeUser(String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{

            entityManager.getTransaction().begin();
            User user = entityManager.find(models.User.class, name);
            if(user == null){
                return false;
            }
            else{

                entityManager.remove(user);
            }
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            if(entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return true;
    }

}
