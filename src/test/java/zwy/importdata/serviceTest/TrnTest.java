package zwy.importdata.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrnTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //线路晚点车辆信息
    @Test
    public void test1(){
        String originalKey = "tf:cmn:02:trn:*.0000.arr_delay_msg";

        Set<String> keys = stringRedisTemplate.keys(originalKey);
        List<Map<Object,Object>> list = new ArrayList<>();
        for (String key : keys){
            Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
            System.out.println("entries = " + entries);
            list.add(entries);
        }
    }
}
