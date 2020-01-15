package zwy.importdata.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping
@RestController
public class SpidersController {

    private final StringRedisTemplate stringRedisTemplate;

    public SpidersController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * speed: int, spiders: int, distance: int
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveSpider(@RequestBody JSONObject params) {
        System.out.println("params = " + params);
        stringRedisTemplate.opsForValue().set("speed",params.get("speed").toString());
        stringRedisTemplate.opsForValue().set("distance",params.get("distance").toString());
        stringRedisTemplate.opsForValue().set("spiders",params.get("spiders").toString());
        return ResponseEntity.ok("save successfully");
    }

    @GetMapping("/test")
    public void genFiveMinutes() throws Exception{
        //init time
        String time = "00:00:00";
        //format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date first = simpleDateFormat.parse(time);
        //gen
        for(int i = 1; i <= 288; i++ ) {
            Date afterDate = new Date(first.getTime() + 300000);
            System.out.printf("i: %d, after: %s \n", i, simpleDateFormat.format(afterDate));
            //todo 数据库保存
            first = afterDate;
        }
    }
}