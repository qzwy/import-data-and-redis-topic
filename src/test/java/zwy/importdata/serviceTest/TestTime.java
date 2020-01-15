package zwy.importdata.serviceTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import zwy.importdata.controller.SpidersController;
import zwy.importdata.mongo.MongoRepo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTime {

    @Autowired
    private
    SpidersController spidersController;
    @Autowired
    private
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    private MongoRepo mongoRepo;

    @Test
    public void test() {

        long l = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(l);
        System.out.println("instant = " + instant);
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault());
        System.out.println("date = " + date);

    }

    @Test
    public void testSaveSpider() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("speed", 5);
        jsonObject.put("distance", 5);
        jsonObject.put("spiders", 5);

        System.out.println("jsonObject = " + jsonObject);
        spidersController.saveSpider(jsonObject);

        String speed = stringRedisTemplate.opsForValue().get("speed");
        String distance = stringRedisTemplate.opsForValue().get("distance");
        String spiders = stringRedisTemplate.opsForValue().get("spiders");

        Assert.assertEquals(speed,"5");
        Assert.assertEquals(distance,"5");
        Assert.assertEquals(spiders,"5");
    }

//    @Test
//    public void testMongo() {
//        List<String> byType = mongoRepo.findByType("standard", "sample_components");
//        System.out.println("byType = " + byType);
//    }
}
