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
    private String timeStamp;
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
                + ", timeStamp=" + timeStamp + ", sender=" + sender + ", roomId=" + roomId + "]";
    }


    public int getMessegeId() {
        return messegeId;
    }


    public String getContent() {
        return content;
    }


    public String getTimeStamp() {
        return timeStamp;
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


    public void setTimeStamp(String date) {
        this.timeStamp = timeStamp;
    }


    public void setSender(String sender) {
        this.sender = sender;
    }


    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


}