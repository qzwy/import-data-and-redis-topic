package zwy.importdata.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 向redis中保存数据
 */
@EnableScheduling
@Component
public class DataToRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 电镀皮肤反应数据模拟
     * <STREAM_TYPE> <TIMESTAMP> <DATA>
     * E4_Gsr 123345627891.123 3.129
     */
    @Scheduled(fixedRate = 1000)
    public void insertIntoRedis() {
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
    }
}