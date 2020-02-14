package zwy.importdata.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InsetDataToRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void insertIntoRedis() {
        //key
        String key = "tf:cmn:14:iscs:02.0226.line_fault_nums";
        //value
        double value = Math.random()*10000;

        //save
        stringRedisTemplate.opsForValue().set(key, String.valueOf((int)value));
    }

    @Test
    public void findData() {
        //key
        String key = "tf:cmn:14:iscs:00.0000.line_fault_nums";

        //save
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println("s = " + s);
    }
}
