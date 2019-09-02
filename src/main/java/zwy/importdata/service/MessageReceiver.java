package zwy.importdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 接收消息
 */
@Component
public class MessageReceiver {
  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  /**接收消息的方法*/
  public void receiveMessage(String message){
    simpMessagingTemplate.convertAndSend("/topic/test",message);
  }

}

