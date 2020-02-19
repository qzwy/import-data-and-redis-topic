package zwy.importdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class EnergyController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //各线路各能耗量
    @GetMapping("/energy")
    public ResponseEntity<?> lineEnergy() {
        String originalKey = "tf:cmn:14:iscs:*.0000.energy_line_type_day";
        Set<String> keys = stringRedisTemplate.keys(originalKey);
        LinkedHashSet<Map<Object, Object>> hashSet = new LinkedHashSet<>();
        assert keys != null;
        for (String key : keys) {
            Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
            entries.put("lineId",key.substring(15, 17));
            entries.put("lineName", key.substring(15,17)+"号线");
            hashSet.add(entries);

        }
        return ResponseEntity.ok(hashSet);
    }
}
