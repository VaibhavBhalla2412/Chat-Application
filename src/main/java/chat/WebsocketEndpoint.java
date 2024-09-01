package chat;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/WebsocketEndpoint/{roomId}/{username}")
public class  WebsocketEndpoint{

    // Map to store the session and roomId of the user
    private static Map<Session, String> sessionUserMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId) {
        sessionUserMap.put(session, roomId);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        String[] parts = message.split(":");

        for (Map.Entry<Session, String> entry : sessionUserMap.entrySet()) {
            if (entry.getValue().equals(parts[1])) {
                entry.getKey().getBasicRemote().sendText(parts[0] + ":" + parts[2]);
            }
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) throws IOException {

        String roomId = sessionUserMap.remove(session);
        if (roomId != null) {
            for (Map.Entry<Session, String> entry : sessionUserMap.entrySet()) {
                if (entry.getValue().equals(roomId)) {
                    entry.getKey().getBasicRemote().sendText("Admin:" + username +  " left the chat.");
//                    socket.send("Admin:"+ roomId + ":" + userName + " left the chat.");
                }

            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
