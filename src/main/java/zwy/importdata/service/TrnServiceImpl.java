package zwy.importdata.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class TrnServiceImpl implements TrnService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //线路晚点车辆信息
    public List<Map<Object, Object>> DelayMsg() {
        String originalKey = "tf:cmn:02:trn:*.0000.arr_delay_msg";

        Set<String> keys = stringRedisTemplate.keys(originalKey);
        List<Map<Object,Object>> DelayInfo = new ArrayList<>();
        for (String key : keys){
            Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
            entries.forEach((k,v)->{
                entries.put(k,JSONObject.parse(v.toString()));
            });
            System.out.println("entries = " + entries);
            DelayInfo.add(entries);
        }
        return DelayInfo;
    }

    //运行列车信息
    public List<Map<Object, Object>> operationMsg() {
        String originalKey = "tf:cmn:02:trn:*.0000.train_operation_msg";

        Set<String> keys = stringRedisTemplate.keys(originalKey);
        List<Map<Object,Object>> operationInfo = new ArrayList<>();
        for (String key : keys){
            Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
            entries.forEach((k,v)->{
                entries.put(k,JSONObject.parse(v.toString()));
            });
            System.out.println("entries = " + entries);
            operationInfo.add(entries);
        }
        return operationInfo;
    }
}
