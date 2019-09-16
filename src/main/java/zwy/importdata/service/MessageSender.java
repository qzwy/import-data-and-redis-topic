package zwy.importdata.service;

import com.alibaba.fastjson.JSONObject;
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

    @Scheduled(fixedRate = 500) //间隔0.5s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
    public void sendMessage() {
        //key
        String GalvanicSkinResponse = "E4_Gsr";
        //value
        double value = Math.random()+3;
        String format = String.format("%.3f", value);
        //transform to json
        JSONObject data = new JSONObject();
        data.put("timestamp",String.valueOf(System.currentTimeMillis()));
        data.put("value",format);
        //save
        stringRedisTemplate.opsForValue().set(GalvanicSkinResponse,data.toJSONString());
        stringRedisTemplate.convertAndSend("chat",data.toJSONString());
    }
}
