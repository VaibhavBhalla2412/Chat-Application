//package chat;
//
//import java.io.IOException;
//import java.io.StringReader;
//import java.io.StringWriter;
//import java.sql.SQLException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//import jakarta.json.Json;
//import jakarta.json.JsonBuilderFactory;
//import jakarta.json.JsonObject;
//import jakarta.json.JsonObjectBuilder;
//import jakarta.json.JsonReader;
//import jakarta.json.JsonValue;
//import jakarta.json.JsonWriter;
//import jakarta.json.stream.JsonParser;
//import jakarta.json.stream.JsonParser.Event;
//import jakarta.json.stream.JsonParserFactory;
//import jakarta.websocket.EndpointConfig;
//import jakarta.websocket.OnClose;
//import jakarta.websocket.OnError;
//import jakarta.websocket.OnMessage;
//import jakarta.websocket.OnOpen;
//import jakarta.websocket.Session;
//import jakarta.websocket.server.ServerEndpoint;
//
//import models.Message;
//import userDAO.UserDAO;
////import exceptions.ChatDbFailure;
//
//@ServerEndpoint("/sendMessage")
//public class ChatEndpoint {
//    static Set<Session> chatRoomUsers = Collections.synchronizedSet(new HashSet<Session>());
//    static String currUserName;
//
//    static Map<String,Session> chatRoomUsersMap= Collections.synchronizedMap(new HashMap<String,Session>());;
//    static int userCount=0;
//    static Map<String, String> msgJsonMap;
//    private boolean initial= true;
//
//    @OnOpen
//    public void onOpen(Session userSession) throws IOException{
//        userCount++;
//        chatRoomUsers.add(userSession);
//        initial = true;
//
//
//        broadcastAMsg("new_user_loggedin");
//
//    }
//    @OnMessage
//    public void handleMessage(String msgJsonStr, Session userSession) throws IOException
//    {
//        if(initial){
//
//            System.out.println("User is connected with name : "+ msgJsonStr);
//            currUserName = msgJsonStr; // First time it will send user name - manisha
//            chatRoomUsersMap.put(currUserName, userSession);
//            initial = false;
//        }
//        else{
//            msgJsonMap = parseJsonMsg(msgJsonStr);
//            String message =  msgJsonMap.get("message");
//            int senderId =  Integer.parseInt(msgJsonMap.get("senderId"));
//            String senderName =  msgJsonMap.get("senderName");
//            String sendTo = msgJsonMap.get("sendTo");
//
//            try {
//                Message newMsg = new Message(message,senderId);
//                ChatDbOperations.sendMessege(newMsg);
//            } catch (SQLException | ChatDbFailure e) {
//                e.printStackTrace();
//            }
//
//            Session receiverSession = chatRoomUsersMap.get(sendTo);
//            receiverSession.getBasicRemote().sendText(buildJSONData(sendTo,message,senderId,senderName));
//
//        }
//
//
//    }
//    private String buildJSONData(String sendTo, String message, int senderId, String senderName) {
//        JsonObject jsonObj = (Json.createObjectBuilder()
//                .add("sendTo",sendTo)
//                .add("message",message)
//                .add("senderId",senderId)
//                .add("senderName",senderName)).build();
//
//        StringWriter srtingWriter = new StringWriter();
//        try(JsonWriter jsonWriter = Json.createWriter(srtingWriter))
//        {
//            jsonWriter.write(jsonObj);
//        }
//        //	System.out.println("Here is ready "+srtingWriter.toString());
//        return srtingWriter.toString();
//    }
//    @OnClose
//    public String handleClose( Session userSession) throws IOException
//    {
//        userCount--;
//        chatRoomUsers.remove(userSession);
//        System.out.print("Connectin is closed");
//        return("a_user_leaving");
//    }
//    @OnError
//    public void handleError(Throwable e)
//    {
//        e.printStackTrace();
//    }
//
//    private Map<String,String> parseJsonMsg(String message){
//
//        JsonReader reader = Json.createReader(new StringReader(message));
//        JsonObject bookListObj = reader.readObject();
//
//        System.out.println("Reading "+bookListObj);
//        JsonParserFactory factory = Json.createParserFactory(null);
//        JsonParser parser = factory.createParser(new StringReader(message));
//        Map<String, String> map = new HashMap<String, String>();
//
//        while (parser.hasNext()) {
//            Event event = parser.next();
//
//            switch (event) {
//                case KEY_NAME:
//                    if(parser.getString().equals("message"))
//                    {
//                        event = parser.next();
//                        String msgStr = parser.getString();
//                        //System.out.print("message =" + parser.getString());
//
//                        map.put("message",msgStr);
//                    }
//                    else if(parser.getString().equals("senderId"))
//                    {
//                        event = parser.next();
//                        String msgStr = parser.getString();
//                        //	System.out.print("senderId =" + parser.getString());
//
//                        map.put("senderId",msgStr);
//                    }
//                    else if(parser.getString().equals("senderName"))
//                    {
//                        event = parser.next();
//                        String msgStr = parser.getString();
//                        //System.out.print("senderName =" + parser.getString());
//
//                        map.put("senderName",msgStr);
//                    }
//                    else if(parser.getString().equals("sendTo"))
//                    {
//                        event = parser.next();
//                        String msgStr = parser.getString();
//                        //System.out.print("sendTo =" + parser.getString());
//
//                        map.put("sendTo",msgStr);
//                    }
//                    break;
//                default:
//                    break;
//            }
//
//        }
//        return map;
//    }
//
//
//
//    private void broadcastAMsg(String msg) throws IOException{
//        Iterator<Session> iterator = chatRoomUsers.iterator();
//        while(iterator.hasNext()){
//            iterator.next().getBasicRemote().sendText(msg);
//        }
//    }
//}