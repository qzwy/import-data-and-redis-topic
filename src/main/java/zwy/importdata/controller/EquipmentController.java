package zwy.importdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipmentController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


}
