package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messegeId;
    private String content;
    private LocalDateTime timeStamp;
    private String sender;
    private int roomId;


    public Message() {
        super();
    }


    public Message( String content, String sender, int roomId) {
        super();
        this.content = content;
        this.sender = sender;
        this.roomId = roomId;
    }

    @PrePersist
    protected void onCreate() {
        timeStamp = LocalDateTime.now();
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


    public LocalDateTime getTimeStamp() {
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


    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }


    public void setSender(String sender) {
        this.sender = sender;
    }


    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


}