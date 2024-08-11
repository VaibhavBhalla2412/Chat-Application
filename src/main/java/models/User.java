package models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = -5161680823918839255L;

    @Id
    private String name;
    private String sessionId;
//    private String status;
//
//    public static final String ONLINE="online";
//    public static final String OFFLINE="offline";

    public User() {
        super();
    }

    public User(String name, HttpSession sessionId){
        super();
        this.name = name;
        this.sessionId = sessionId.getId();
    }
    public User(HttpServletRequest request) {
        extractFormData(request);
    }
    private void extractFormData(HttpServletRequest request) {

        if(!request.getParameter("name").equals(""))
            name = request.getParameter("name");
    }


    public String getName() {
        return name;
    }
    public String getsessionId() {
        return sessionId;
    }
//    public String getStatus() {
//        return status;
//    }

    public void setName(String name) {
        this.name = name;
    }
    public void setsessionId(HttpSession sessionId) {
        this.sessionId = (String)sessionId.getId();
    }
//    public void setStatus(String status) {
//        this.status = status;
//    }
    @Override
    public String toString() {
        return " {name:\"" + name + "\"}";
//        return " {name:\"" + name + "\", status:\"" + status + "\"}";

    }

}