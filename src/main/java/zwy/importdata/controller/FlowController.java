package zwy.importdata.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zwy.importdata.model.StationFlow;

@RestController
public class FlowController {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  //各重点站进出站总量
  @GetMapping("/station_inbound")
  public ResponseEntity<?> fetchFlowData(){
    //today
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String timeNow = df.format(new Date());

    //几号
    String No = timeNow.substring(5,7);
    String station = "0220";

    String lienId = station.substring(0,2);

//    String key = Constant.BaseKey + No + Constant.TypeFlow + lienId + "." + station + "."
//        + Constant.FiveMinsIn;

    String key2 = "tf:cmn:29:flow:*:5m_in";
    Set<String> keys = stringRedisTemplate.keys(key2);
    List<StationFlow> listStationFlow = new ArrayList<>();
    for (String key : keys){
      StationFlow stationFlow = new StationFlow();
      Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
      Integer flow  = 0;
      for ( Object value : entries.values()){
        flow = flow + Integer.parseInt(value.toString());
      }
      stationFlow.setInboundValue(flow);
      stationFlow.setOutBoundValue(flow);
      stationFlow.setStationId(key.substring(18,22));
      listStationFlow.add(stationFlow);
    }
    return ResponseEntity.ok(listStationFlow);
  }

  @GetMapping("/line_inbound")
  public ResponseEntity<?> fetchFlowData2(){

    String key2 = "tf:cmn:29:flow:*:5m_in";
    Set<String> keys = stringRedisTemplate.keys(key2);
    Map<String, Integer> lineFlow = new HashMap<>();
    for (String key : keys){
      String lineId = key.substring(15,17);
      Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
      Integer flow  = 0;
      for ( Object value : entries.values()){
        flow = flow + Integer.parseInt(value.toString());
      }
      if (lineFlow.containsKey(lineId)){
        System.out.println("1111111 = " + 1111111);
        lineFlow.put(lineId,flow+lineFlow.get(lineId));
      }else{
        lineFlow.put(lineId,flow);
      }
    }
    System.out.println("lineFlow = " + lineFlow);
    return ResponseEntity.ok(lineFlow);
  }

  @GetMapping("/time_inbound")
  public ResponseEntity fetchFlowData3() throws Exception{

    String key2 = "tf:cmn:29:flow:*:5m_in";
    Set<String> keys = stringRedisTemplate.keys(key2);
    Map<String, Integer> total = new HashMap<>();
    for (String key : keys){
      Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
      for (Object tk : entries.keySet()){
        String s = tk.toString().split("\\.")[0];
        if (total.containsKey(s)){
          total.put(s,total.get(s)+Integer.parseInt(entries.get(tk).toString()));
        }else{
          total.put(s,Integer.parseInt(entries.get(tk).toString()));
        }
      }
    }
    System.out.println("total = " + total);
    Integer test = 0;
    for (Integer i : total.values()){
      test = test+i;
    }
    System.out.println("test = " + test);

    GenFiveMins genFiveMins = new GenFiveMins();
    Map<String, String> timeMap = genFiveMins.genFiveMins();

    for
    return ResponseEntity.ok(total);
  }
}
