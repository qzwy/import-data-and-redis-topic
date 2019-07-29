package zwy.importdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Zhao Wenyue
 */
@EnableScheduling //开启定时器功能
@Component
public class MessageSender {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Scheduled(fixedRate = 2000) //间隔2s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
  public void sendMessage(){
    String jo = "{\"averagePowerLine\":{\"id\":\"p2-t3-04-mm\",\"name\":\"平均功率线路对比\",\"data\":[{\"main_code\":\"02\",\"name\":\"2号线\",\"value\":"+ (Math.random()*100+400) +"},{\"main_code\":\"03\",\"name\":\"3号线\",\"value\":"+ ( Math.random()*100+420 ) +"},{\"main_code\":\"11\",\"name\":\"11号线\",\"value\":" + (Math.random()*100+400) + "}],\"node\":\"averagePowerLine\",\"tag\":null,\"vert\":false,\"index\":0}}";
    stringRedisTemplate.convertAndSend("chat", jo);
  }
}
