package zwy.importdata.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("get 1111");
    }
}