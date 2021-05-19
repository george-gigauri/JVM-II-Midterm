package com.example.Giorgi_Gigauri_davaleba_2;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/weatherBot")
public class WeatherBotController {

    @OnOpen
    public void handleOpen() {

    }

    @OnMessage
    public String handleMessage(String message) {
        return WeatherBotService.respond(message);
    }

    @OnClose
    public void handleClose() {
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

}
