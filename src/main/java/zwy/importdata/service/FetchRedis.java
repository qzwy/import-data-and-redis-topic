package zwy.importdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Fetch From redis demo
 * @author Wenyue Zhao
 */
@EnableScheduling
@Component
public class FetchRedis {
    private final Logger log = LoggerFactory.getLogger(FetchRedis.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Scheduled(fixedRate = 1000)
    public void FetchFromRedis() {
        //需要读取的key
        String key = "E4_Gsr";
        //读取操作
        String value = stringRedisTemplate.opsForValue().get(key);
        //日志打印
        log.info("Data form redis : {} = {}", key,value);
    }

//    @Scheduled(fixedRate = 1000)
    public void FetchFromRedis2() {
        //需要读取的key
        String speedKey = "speed";
        //读取操作
        String value = stringRedisTemplate.opsForValue().get(speedKey);
        //日志打印
        log.info("===Data form redis : {} = {}", speedKey,value);

        String distanceKey = "distance";
        //读取操作
        String disValue = stringRedisTemplate.opsForValue().get(distanceKey);
        //日志打印
        log.info("===Data form redis : {} = {}", distanceKey,disValue);

        String spidersKey = "spiders";
        //读取操作
        String spidersValue = stringRedisTemplate.opsForValue().get(spidersKey);
        //日志打印
        log.info("===Data form redis : {} = {}", spidersKey,spidersValue);
    }
}