package com.leonteqsecurity.WEBSOCKETS;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        // Handle connection establishment
        System.out.println("New WebSocket connection established: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming text message
        String payload = message.getPayload();
        System.out.println("Received message from frontend: " + payload);

        // Send a response back to the frontend
        session.sendMessage(new TextMessage("Server received: " + payload));
    }
}
