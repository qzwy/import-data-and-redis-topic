package zwy.importdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EnergyController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //各线路各能耗量
    @GetMapping("/energy/first")
    public ResponseEntity<?> lineEnergy(String lineId) {
        String originalKey = "tf:cmn:14:iscs:" + lineId + ".0000.energy_line_type_day";
        Set<String> keys = stringRedisTemplate.keys(originalKey);
        System.out.println("keys = " + keys);
        List<Map<Object, Object>> list = new ArrayList<>();
        assert keys != null;

        for (String key : keys) {
            Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
//            for (Object objectK:entries.keySet()){
//                entries.put(objectK,String.format("%.2f",Double.parseDouble(entries.get(objectK).toString())));
//            }
//            entries.put("lineId",key.substring(15, 17));
//            entries.put("lineName", key.substring(15,17)+"号线");
            list.add(entries);
        }
        List<Map<String, String>> hashSet = new ArrayList<>();
        Map<Object, Object> objectObjectMap = list.get(0);
        System.out.println("objectObjectMap = " + objectObjectMap);
        for (Object object : objectObjectMap.keySet()) {
            Map<String, String> result = new HashMap<>();
            switch (object.toString()) {
                case "all":
                    result.put("name", "总能耗");
                    result.put("value", String.format("%.2f", Double.parseDouble(objectObjectMap.get(object).toString())));
                    break;
                case "traction":
                    result.put("name", "牵引能耗");
                    result.put("value", String.format("%.2f", Double.parseDouble(objectObjectMap.get(object).toString())));
                    break;
                case "light":
                    result.put("name", "动力照明");
                    result.put("value", String.format("%.2f", Double.parseDouble(objectObjectMap.get(object).toString())));
                    break;
                case "other":
                    result.put("name", "线损能耗");
                    result.put("value", String.format("%.2f", Double.parseDouble(objectObjectMap.get(object).toString())));
                    break;
            }
            hashSet.add(result);
        }
        return ResponseEntity.ok(hashSet);
    }

    //各线路 各能耗
    @GetMapping("/energy/second")
    public ResponseEntity<?> lineEnergy2() {
        String originalKey = "tf:cmn:14:iscs:*.0000.energy_line_type_day";
        Set<String> keys = stringRedisTemplate.keys(originalKey);
        System.out.println("keys = " + keys);
        List<Map<Object, Object>> list = new ArrayList<>();
        assert keys != null;
        for (String key : keys) {
            if (!key.substring(15, 17).equals("00")) {
                Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
                for (Object objectK : entries.keySet()) {
                    entries.put(objectK, String.format("%.2f", Double.parseDouble(entries.get(objectK).toString())));
//                Map<String, String> result = new HashMap<>();
//                switch (objectK.toString()) {
//                    case "all":
//                        result.put("all", "总能耗");
//                        result.put("value", String.format("%.2f", Double.parseDouble(entries.get(objectK).toString())));
//                        entries.put(objectK, result);
//                        break;
//                    case "traction":
//                        result.put("name", "牵引能耗");
//                        result.put("value", String.format("%.2f", Double.parseDouble(entries.get(objectK).toString())));
//                        entries.put(objectK, result);
//                        break;
//                    case "light":
//                        result.put("name", "动力照明");
//                        result.put("value", String.format("%.2f", Double.parseDouble(entries.get(objectK).toString())));
//                        entries.put(objectK, result);
//                        break;
//                    case "other":
//                        result.put("name", "线损能耗");
//                        result.put("value", String.format("%.2f", Double.parseDouble(entries.get(objectK).toString())));
//                        entries.put(objectK, result);
//                        break;
//                }
                }
                entries.put("lineId", key.substring(15, 17));
                entries.put("lineName", key.substring(15, 17) + "号线");
                list.add(entries);
            }
        }
        List<Map<String, String>> hashSet = new ArrayList<>();
        return ResponseEntity.ok(list);
    }

    //各线路 各能耗
    @GetMapping("/energy/third")
    public ResponseEntity<?> lineEnergy3() {
        String originalKey = "tf:cmn:14:iscs:*.0000.energy_line_type_day";
        Set<String> keys = stringRedisTemplate.keys(originalKey);
        System.out.println("keys = " + keys);
        List<Map<Object, Object>> list = new ArrayList<>();
        assert keys != null;
        for (String key : keys) {
            if (!key.substring(15, 17).equals("00")) {
                Map<Object, Object> result = new HashMap<>();
                Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
                for (Object objectK : entries.keySet()) {

                    if (objectK.toString().equals("all")) {
                        result.put(objectK,String.format("%.2f", Double.parseDouble(entries.get(objectK).toString())));
                    }
                }
                result.put("lineId", key.substring(15, 17));
                result.put("lineName", key.substring(15, 17) + "号线");
                list.add(result);
            }
        }
        List<Map<String, String>> hashSet = new ArrayList<>();
        return ResponseEntity.ok(list);
    }
}
