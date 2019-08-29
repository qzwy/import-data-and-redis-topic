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

    @Scheduled(fixedRate = 1000)
    public void FetchFromRedis() {
        String key = "E4_Gsr";
        String value = stringRedisTemplate.opsForValue().get(key);
        log.info("Data form redis : {} = {}", key,value);
    }
}
