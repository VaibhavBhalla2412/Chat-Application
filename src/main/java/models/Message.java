package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messegeId;
    private String content;
    private String date;
    private String sender;
    private int roomId;


    public Message() {
        super();
    }


    public Message( String content, int senderId) {
        super();
        this.content = content;
        this.sender = sender;
        this.roomId = roomId;
    }


    @Override
    public String toString() {
        return "Message [messegeId=" + messegeId + ", content=" + content
                + ", date=" + date + ", sender=" + sender + ", roomId=" + roomId + "]";
    }


    public int getMessegeId() {
        return messegeId;
    }


    public String getContent() {
        return content;
    }


    public String getDate() {
        return date;
    }


    public String getSender() {
        return sender;
    }

    public int getRoomId() {
        return roomId;
    }


    public void setMessegeId(int messegeId) {
        this.messegeId = messegeId;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public void setSender(String sender) {
        this.sender = sender;
    }


    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


}