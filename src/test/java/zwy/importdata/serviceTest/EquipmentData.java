package zwy.importdata.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EquipmentData {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void lineRatio() throws Exception{
        String collectRateKey = "tf:cmn:14:iscs:*.0000.line_device_rate";
        Set<String> keys = stringRedisTemplate.keys(collectRateKey);
        //total
        List<Map<String, String >> collectRate = new ArrayList<>();
        for (String key : keys){
            Map<String, String> Rate= new HashMap<>();
            Rate.put("lineId",key.substring(15,17));
            Rate.put("breakRate",stringRedisTemplate.opsForValue().get(key));
            collectRate.add(Rate);
        }
        String collectNumKey = "tf:cmn:14:iscs:*.0000.line_fault_nums";
        Set<String> keys2 = stringRedisTemplate.keys(collectNumKey);
        for (String key : keys2){
            for (Map<String, String> i : collectRate){
                if (key.substring(15,17).equals(i.get("lineId"))){
                    i.put("breakNum",stringRedisTemplate.opsForValue().get(key));
                }
            }
        }
        LinkedHashSet<Map<String, String >> hashSet = new LinkedHashSet<>(collectRate);
        System.out.println("hashSet = " + hashSet);
    }

    //afc
    @Test
    public void afc() {
        String afcRateKey = "tf:cmn:14:iscs:*.0000.sys_device_rate";
        Set<String> keys = stringRedisTemplate.keys(afcRateKey);
        List<Map<String, String>> afcList = new ArrayList<>();
        //total
        for (String key : keys){
            Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
            Map<String, String> afcObject = new HashMap<>();
            afcObject.put("lineId", key.substring(15,17));
            afcObject.put("breakRate", entries.get("afc").toString());
            afcList.add(afcObject);
        }
        String afcNumKey = "tf:cmn:14:iscs:*.0000.sys_fault_nums";
        Set<String> keys2 = stringRedisTemplate.keys(afcNumKey);
        for (String key : keys2){
            for (Map<String, String> i : afcList){
                if (key.substring(15,17).equals(i.get("lineId"))){
                    i.put("breakNum",stringRedisTemplate.opsForHash().entries(key).get("afc").toString());
                }
            }
        }
        LinkedHashSet<Map<String, String >> hashSet = new LinkedHashSet<>(afcList);
        System.out.println("afcList = " + hashSet);
    }
}
