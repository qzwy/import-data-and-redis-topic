package zwy.importdata.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

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

    //全线网、线路设备数
    @Test
    public void insertIntoRedis2() {
        //key
        String key = "tf:cmn:14:iscs:03.0000.line_device_rate";
        //value
        double value = Math.random();

        //save
        stringRedisTemplate.opsForValue().set(key, String.format("%.2f", value));
    }


    @Test
    public void insertIntoRedis3() {
        //key
        String key = "tf:cmn:14:iscs:00.0000.energy_line_type_day";

//        stringRedisTemplate.opsForHash().delete(key,"0220|traction");
        //save
//        stringRedisTemplate.opsForHash().put(key,"all",String.valueOf( Math.random()*100000+500000));
        Object all = stringRedisTemplate.opsForHash().get(key, "all");
        stringRedisTemplate.opsForHash().put(key,"traction",String.valueOf(Double.parseDouble(all.toString())*0.2));
        stringRedisTemplate.opsForHash().put(key,"light",String.valueOf(Double.parseDouble(all.toString())*0.3));
        stringRedisTemplate.opsForHash().put(key,"other",String.valueOf(Double.parseDouble(all.toString())*0.5));
        Map<Object, Object> hashValue = stringRedisTemplate.opsForHash().entries(key);
        System.out.println("value = " + hashValue);
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
