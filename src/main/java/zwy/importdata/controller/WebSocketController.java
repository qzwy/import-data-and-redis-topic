package zwy.importdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@EnableScheduling
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @Scheduled(fixedRate = 1000)
//    public void send(){
//        try{
//            simpMessagingTemplate.convertAndSend("/topic/test","111");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}
