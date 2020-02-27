package zwy.importdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zwy.importdata.service.TrnService;

import java.util.*;

@RestController
public class TrnController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TrnService trnService;

    @GetMapping("/trn")
    public ResponseEntity<?> delay2min(){
        //todo today is No.?
        String originalKey = "tf:cmn:02:trn:*_num";
        Set<String> keys = stringRedisTemplate.keys(originalKey);
        String rateKey = "tf:cmn:02:trn:*.0000.implement_ratio";
        Set<String> rateKeys = stringRedisTemplate.keys(rateKey);
        assert keys != null;
        assert rateKeys != null;
        keys.addAll(rateKeys);
        List<Map<String, String>> totalInfo = new ArrayList<>();
        for (String key : keys){
            String s = stringRedisTemplate.opsForValue().get(key);
            Map<String, String> oneLine =new HashMap<>();
            oneLine.put("lineId", key.substring(14,16));
            oneLine.put(key.split("\\.")[2],s);
            totalInfo.add(oneLine);
        }

        for (Map<String, String > content : totalInfo){
            for (int i =0; i < totalInfo.size();i++){
                if (totalInfo.get(i).containsValue(content.get("lineId"))){
                    for (Map.Entry<String, String> key : totalInfo.get(i).entrySet()){
                        content.put(key.getKey(),key.getValue());
                    }
                }
            }
        }
        //去重
        LinkedHashSet<Map<String, String >> hashSet = new LinkedHashSet<>(totalInfo);
        return ResponseEntity.ok(hashSet);
    }


    //晚点列车信息
    @GetMapping("/trn2")
    public ResponseEntity<?> delayInfo(){
        List<Map<Object, Object>> maps = trnService.DelayMsg();
        return ResponseEntity.ok(maps);
    }

    //运行列车信息
    @GetMapping("/trn3")
    public ResponseEntity<?> operatingInfo(){
        List<Map<Object, Object>> maps = trnService.operationMsg();
        return ResponseEntity.ok(maps);
    }
}
