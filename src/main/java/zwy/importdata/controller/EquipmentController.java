package zwy.importdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zwy.importdata.service.EquipmentService;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@RestController
public class EquipmentController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/equipment/total_line")
    public ResponseEntity<?> lineTotal() {
        Map<String, LinkedHashSet<Map<String, String>>> result = new HashMap<>();
        result.put("collect",equipmentService.lineRatio());
        result.put("afc",equipmentService.afc());
        return ResponseEntity.ok(result);
    }
}
