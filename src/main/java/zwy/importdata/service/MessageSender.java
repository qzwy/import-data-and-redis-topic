package zwy.importdata.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import zwy.importdata.config.EnergyProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Wenyue
 */
@EnableScheduling //开启定时器功能
@Component
public class MessageSender {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EnergyProperties energyProperties;

//  @Scheduled(fixedRate = 2000) //间隔2s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
//  public void sendMessage() {
//    String jo =
//        "{\"averagePowerLine\":{\"id\":\"p2-t3-04-mm\",\"name\":\"平均功率线路对比\",\"data\":[{\"main_code\":\"02\",\"name\":\"2号线\",\"value\":"
//            + (Math.random() * 100 + 400) + "},{\"main_code\":\"03\",\"name\":\"3号线\",\"value\":"
//            + (Math.random() * 100 + 420) + "},{\"main_code\":\"11\",\"name\":\"11号线\",\"value\":"
//            + (Math.random() * 100 + 400)
//            + "}],\"node\":\"averagePowerLine\",\"tag\":null,\"vert\":false,\"index\":0}}";
//    stringRedisTemplate.convertAndSend("chat", jo);
//  }

    @Scheduled(fixedRate = 5000) //间隔5s 通过StringRedisTemplate对象向redis消息队列chat频道发布消息
    public void sendMessage() {
        stringRedisTemplate.convertAndSend("line", "{\n" +
                "    {\"id\":\"02\",\"inboundCapacity\":200,\"outboundCapacity\":300,\"chainRatio\":0.5,\"shijifache\":200,\"jihuafache\":200,\"zhengdian\":0.2,\"duixian\":0.5,\"passengerFlow\":[{\"stationName\":\"李村公园站\",\"flow\":200},{\"stationName\":\"李村站\",\"flow\":200},{\"stationName\":\"枣山路站\",\"flow\":200},{\"stationName\":\"华楼山路站\",\"flow\":200},{\"stationName\":\"东韩站\",\"flow\":200},{\"stationName\":\"辽阳东路站\",\"flow\":200},{\"stationName\":\"同安路站\",\"flow\":200},{\"stationName\":\"苗岭路站\",\"flow\":200},{\"stationName\":\"石老人浴场站\",\"flow\":200},{\"stationName\":\"海安路站\",\"flow\":200},{\"stationName\":\"海川路站\",\"flow\":200},{\"stationName\":\"麦岛站\",\"flow\":200},{\"stationName\":\"高雄路站\",\"flow\":200},{\"stationName\":\"燕儿岛路站\",\"flow\":200},{\"stationName\":\"浮山所站\",\"flow\":200},{\"stationName\":\"五四广场站\",\"flow\":200},{\"stationName\":\"芝泉路站\",\"flow\":200}]},\n" +
                "    {\"id\":\"03\",\"inboundCapacity\":200,\"outboundCapacity\":300,\"chainRatio\":0.5,\"shijifache\":200,\"jihuafache\":200,\"zhengdian\":0.2,\"duixian\":0.5,\"passengerFlow\":[{\"stationName\":\"青岛站\",\"flow\":200},{\"stationName\":\"人民会堂站\",\"flow\":200},{\"stationName\":\"汇泉广场站\",\"flow\":200},{\"stationName\":\"中山公园站\",\"flow\":200},{\"stationName\":\"太平角公园站\",\"flow\":200},{\"stationName\":\"延安三路站\",\"flow\":200},{\"stationName\":\"五四广场站\",\"flow\":200},{\"stationName\":\"江西路站\",\"flow\":200},{\"stationName\":\"宁夏路站\",\"flow\":200},{\"stationName\":\"敦化路站\",\"flow\":200},{\"stationName\":\"错埠岭站\",\"flow\":200},{\"stationName\":\"清江路站\",\"flow\":200},{\"stationName\":\"双山站\",\"flow\":200},{\"stationName\":\"长沙路站\",\"flow\":200},{\"stationName\":\"地铁大厦站\",\"flow\":200},{\"stationName\":\"海尔路站\",\"flow\":200},{\"stationName\":\"万年泉路站\",\"flow\":200},{\"stationName\":\"李村站\",\"flow\":200},{\"stationName\":\"君峰路站\",\"flow\":200},{\"stationName\":\"振华路站\",\"flow\":200},{\"stationName\":\"永平路站\",\"flow\":200},{\"stationName\":\"青岛北站\",\"flow\":200}]},\n" +
                "    {\"id\":\"11\",\"inboundCapacity\":200,\"outboundCapacity\":300,\"chainRatio\":0.5,\"shijifache\":200,\"jihuafache\":200,\"zhengdian\":0.2,\"duixian\":0.5,\"passengerFlow\":[{\"stationName\":\"苗岭路站\",\"flow\":200},{\"stationName\":\"会展中心站\",\"flow\":200},{\"stationName\":\"青岛二中站\",\"flow\":200},{\"stationName\":\"青岛科大站\",\"flow\":200},{\"stationName\":\"张村站\",\"flow\":200},{\"stationName\":\"枯桃站\",\"flow\":200},{\"stationName\":\"海洋大学站\",\"flow\":200},{\"stationName\":\"世博园站\",\"flow\":200},{\"stationName\":\"北宅站\",\"flow\":200},{\"stationName\":\"北九水站\",\"flow\":200},{\"stationName\":\"庙石站\",\"flow\":200},{\"stationName\":\"浦里站\",\"flow\":200},{\"stationName\":\"鳌山卫站\",\"flow\":200},{\"stationName\":\"山东大学站\",\"flow\":200},{\"stationName\":\"蓝色硅谷站\",\"flow\":200},{\"stationName\":\"水泊站\",\"flow\":200},{\"stationName\":\"博览中心站\",\"flow\":200},{\"stationName\":\"温泉东站\",\"flow\":200},{\"stationName\":\"皋虞站\",\"flow\":200},{\"stationName\":\"臧村站\",\"flow\":200},{\"stationName\":\"钱谷山站\",\"flow\":200},{\"stationName\":\"鳌山湾站\",\"flow\":200}]},\n" +
                "    {\"id\":\"13\",\"inboundCapacity\":200,\"outboundCapacity\":300,\"chainRatio\":0.5,\"shijifache\":200,\"jihuafache\":200,\"zhengdian\":0.2,\"duixian\":0.5,\"passengerFlow\":[{\"stationName\":\"嘉陵江路站\",\"flow\":200},{\"stationName\":\"香江路站\",\"flow\":200},{\"stationName\":\"井冈山路站\",\"flow\":200},{\"stationName\":\"积米崖站\",\"flow\":200},{\"stationName\":\"积米崖站\",\"flow\":200},{\"stationName\":\"学院路站\",\"flow\":200},{\"stationName\":\"朝阳山站\",\"flow\":200},{\"stationName\":\"辛屯（灵山湾站）\",\"flow\":200},{\"stationName\":\"两河站\",\"flow\":200},{\"stationName\":\"隐珠站\",\"flow\":200},{\"stationName\":\"凤凰山路站\",\"flow\":200},{\"stationName\":\"双珠路站\",\"flow\":200},{\"stationName\":\"世纪大道站\",\"flow\":200},{\"stationName\":\"盛海路（世博城站）\",\"flow\":200},{\"stationName\":\"大珠山站\",\"flow\":200},{\"stationName\":\"张家楼站\",\"flow\":200},{\"stationName\":\"古镇口站\",\"flow\":200},{\"stationName\":\"龙湾站\",\"flow\":200},{\"stationName\":\"琅琊站\",\"flow\":200},{\"stationName\":\"贡口湾站\",\"flow\":200},{\"stationName\":\"董家口港站\",\"flow\":200},{\"stationName\":\"泊里站\",\"flow\":200},{\"stationName\":\"董家口火车站\",\"flow\":200}]}\n" +
                "｝");
        stringRedisTemplate.convertAndSend("analyse", "{\n"
                + "    {\"id\":\"01\",\"inboundCapacity\":2000,\"outboundCapacity\":300,\"chainRatio\":0.5,\"transfer\":200,\"totalMileage\":1000,\"kilometerEnergyConsumption\":500,\n"
                + "     \"passengerTrafficVolume\":[{\"monthid\":01,\"volum\":100},{\"monthid\":02,\"volum\":100},{\"monthid\":03,\"volum\":100},{\"monthid\":04,\"volum\":100},{\"monthid\":05,\"volum\":100},{\"monthid\":06,\"volum\":100},{\"monthid\":07,\"volum\":100},      {\"monthid\":08,\"volum\":100},{\"monthid\":09,\"volum\":100},{\"monthid\":10,\"volum\":100},{\"monthid\":11,\"volum\":100},{\"monthid\":12,\"volum\":100}],\n"
                + "     \"eightMonthsActual\":[{\"monthid\":01,\"actual\":100},{\"monthid\":02,\"actual\":100},{\"monthid\":03,\"actual\":100},{\"monthid\":04,\"actual\":100},{\"monthid\":05,\"actual\":100},{\"monthid\":06,\"actual\":100},{\"monthid\":07,\"actual\":100},     {\"monthid\":08,\"actual\":100}],\n"
                + "    \"eightMonthsChainRatio\":[{\"monthid\":01,\"chainRatio\":100},{\"monthid\":02,\"chainRatio\":100},{\"monthid\":03,\"chainRatio\":100},{\"monthid\":04,\"chainRatio\":100},{\"monthid\":05,\"chainRatio\":100},{\"monthid\":06,\"chainRatio\":100},        {\"monthid\":07,\"chainRatio\":100},{\"monthid\":08,\"chainRatio\":100}],\n"
                + "   \"fourMonthsChainRatio\":[{\"monthid\":09,\"chainRatio\":100},{\"monthid\":10,\"chainRatio\":100},{\"monthid\":11,\"chainRatio\":100},{\"monthid\":12,\"chainRatio\":100}]\n"
                + "   },\n"
                + "   {\"id\":\"02\",\"inboundCapacity\":2000,\"outboundCapacity\":300,\"chainRatio\":0.5,\"transfer\":200,\"totalMileage\":1000,\"kilometerEnergyConsumption\":500,\n"
                + "     \"passengerTrafficVolume\":[{\"monthid\":01,\"volum\":100},{\"monthid\":02,\"volum\":100},{\"monthid\":03,\"volum\":100},{\"monthid\":04,\"volum\":100},{\"monthid\":05,\"volum\":100},{\"monthid\":06,\"volum\":100},{\"monthid\":07,\"volum\":100},      {\"monthid\":08,\"volum\":100},{\"monthid\":09,\"volum\":100},{\"monthid\":10,\"volum\":100},{\"monthid\":11,\"volum\":100},{\"monthid\":12,\"volum\":100}],\n"
                + "     \"eightMonthsActual\":[{\"monthid\":01,\"actual\":100},{\"monthid\":02,\"actual\":100},{\"monthid\":03,\"actual\":100},{\"monthid\":04,\"actual\":100},{\"monthid\":05,\"actual\":100},{\"monthid\":06,\"actual\":100},{\"monthid\":07,\"actual\":100},     {\"monthid\":08,\"actual\":100}],\n"
                + "    \"eightMonthsChainRatio\":[{\"monthid\":01,\"chainRatio\":100},{\"monthid\":02,\"chainRatio\":100},{\"monthid\":03,\"chainRatio\":100},{\"monthid\":04,\"chainRatio\":100},{\"monthid\":05,\"chainRatio\":100},{\"monthid\":06,\"chainRatio\":100},        {\"monthid\":07,\"chainRatio\":100},{\"monthid\":08,\"chainRatio\":100}],\n"
                + "   \"fourMonthsChainRatio\":[{\"monthid\":09,\"chainRatio\":100},{\"monthid\":10,\"chainRatio\":100},{\"monthid\":11,\"chainRatio\":100},{\"monthid\":12,\"chainRatio\":100}]\n"
                + "   },\n"
                + "   {\"id\":\"03\",\"inboundCapacity\":2000,\"outboundCapacity\":300,\"chainRatio\":0.5,\"transfer\":200,\"totalMileage\":1000,\"kilometerEnergyConsumption\":500,\n"
                + "     \"passengerTrafficVolume\":[{\"monthid\":01,\"volum\":100},{\"monthid\":02,\"volum\":100},{\"monthid\":03,\"volum\":100},{\"monthid\":04,\"volum\":100},{\"monthid\":05,\"volum\":100},{\"monthid\":06,\"volum\":100},{\"monthid\":07,\"volum\":100},      {\"monthid\":08,\"volum\":100},{\"monthid\":09,\"volum\":100},{\"monthid\":10,\"volum\":100},{\"monthid\":11,\"volum\":100},{\"monthid\":12,\"volum\":100}],\n"
                + "     \"eightMonthsActual\":[{\"monthid\":01,\"actual\":100},{\"monthid\":02,\"actual\":100},{\"monthid\":03,\"actual\":100},{\"monthid\":04,\"actual\":100},{\"monthid\":05,\"actual\":100},{\"monthid\":06,\"actual\":100},{\"monthid\":07,\"actual\":100},     {\"monthid\":08,\"actual\":100}],\n"
                + "    \"eightMonthsChainRatio\":[{\"monthid\":01,\"chainRatio\":100},{\"monthid\":02,\"chainRatio\":100},{\"monthid\":03,\"chainRatio\":100},{\"monthid\":04,\"chainRatio\":100},{\"monthid\":05,\"chainRatio\":100},{\"monthid\":06,\"chainRatio\":100},        {\"monthid\":07,\"chainRatio\":100},{\"monthid\":08,\"chainRatio\":100}],\n"
                + "   \"fourMonthsChainRatio\":[{\"monthid\":09,\"chainRatio\":100},{\"monthid\":10,\"chainRatio\":100},{\"monthid\":11,\"chainRatio\":100},{\"monthid\":12,\"chainRatio\":100}]\n"
                + "   },\n"
                + "   {\"id\":\"04\",\"inboundCapacity\":2000,\"outboundCapacity\":300,\"chainRatio\":0.5,\"transfer\":200,\"totalMileage\":1000,\"kilometerEnergyConsumption\":500,\n"
                + "     \"passengerTrafficVolume\":[{\"monthid\":01,\"volum\":100},{\"monthid\":02,\"volum\":100},{\"monthid\":03,\"volum\":100},{\"monthid\":04,\"volum\":100},{\"monthid\":05,\"volum\":100},{\"monthid\":06,\"volum\":100},{\"monthid\":07,\"volum\":100},      {\"monthid\":08,\"volum\":100},{\"monthid\":09,\"volum\":100},{\"monthid\":10,\"volum\":100},{\"monthid\":11,\"volum\":100},{\"monthid\":12,\"volum\":100}],\n"
                + "     \"eightMonthsActual\":[{\"monthid\":01,\"actual\":100},{\"monthid\":02,\"actual\":100},{\"monthid\":03,\"actual\":100},{\"monthid\":04,\"actual\":100},{\"monthid\":05,\"actual\":100},{\"monthid\":06,\"actual\":100},{\"monthid\":07,\"actual\":100},     {\"monthid\":08,\"actual\":100}],\n"
                + "    \"eightMonthsChainRatio\":[{\"monthid\":01,\"chainRatio\":100},{\"monthid\":02,\"chainRatio\":100},{\"monthid\":03,\"chainRatio\":100},{\"monthid\":04,\"chainRatio\":100},{\"monthid\":05,\"chainRatio\":100},{\"monthid\":06,\"chainRatio\":100},        {\"monthid\":07,\"chainRatio\":100},{\"monthid\":08,\"chainRatio\":100}],\n"
                + "   \"fourMonthsChainRatio\":[{\"monthid\":09,\"chainRatio\":100},{\"monthid\":10,\"chainRatio\":100},{\"monthid\":11,\"chainRatio\":100},{\"monthid\":12,\"chainRatio\":100}]\n"
                + "   }\n"
                + "}");

        stringRedisTemplate.convertAndSend("historyValue", "{\n" +
                 "     \"dayPeakValue\":29,\"passengerTrafficCapacity\":20000,\"inboundCapacity\":2000,\"outboundCapacity\":20000,\"sectionPeakValue\":2000,\"stationPeekValue\":[{\"id\":02,\"peekValue\":[{\"stationName\":\"李村公园站\",\"value\":200},{\"stationName\":\"李村站\",\"value\":200},{\"stationName\":\"枣山路站\",\"value\":200},{\"stationName\":\"华楼山路站\",\"value\":200},{\"stationName\":\"东韩站\",\"value\":200},{\"stationName\":\"辽阳东路站\",\"value\":200},{\"stationName\":\"同安路站\",\"value\":200},{\"stationName\":\"苗岭路站\",\"value\":200},{\"stationName\":\"石老人浴场站\",\"value\":200},{\"stationName\":\"海安路站\",\"value\":200},{\"stationName\":\"海川路站\",\"value\":200},{\"stationName\":\"麦岛站\",\"value\":200},{\"stationName\":\"高雄路站\",\"value\":200},{\"stationName\":\"燕儿岛路站\",\"value\":200},{\"stationName\":\"浮山所站\",\"value\":200},{\"stationName\":\"五四广场站\",\"value\":200},{\"stationName\":\"芝泉路站\",\"value\":200}]},\n"+
                 "{\"id\":03,\"peekValue\":[{\"stationName\":\"青岛站\",\"flow\":200},{\"stationName\":\"人民会堂站\",\"flow\":200},{\"stationName\":\"汇泉广场站\",\"flow\":200},{\"stationName\":\"中山公园站\",\"flow\":200},{\"stationName\":\"太平角公园站\",\"flow\":200},{\"stationName\":\"延安三路站\",\"value\":200},{\"stationName\":\"五四广场站\",\"value\":200},{\"stationName\":\"江西路站\",\"value\":200},{\"stationName\":\"宁夏路站\",\"value\":200},{\"stationName\":\"敦化路站\",\"value\":200},{\"stationName\":\"错埠岭站\",\"value\":200},{\"stationName\":\"清江路站\",\"value\":200},{\"stationName\":\"双山站\",\"value\":200},{\"stationName\":\"长沙路站\",\"value\":200},{\"stationName\":\"地铁大厦站\",\"value\":200},{\"stationName\":\"海尔路站\",\"value\":200},{\"stationName\":\"万年泉路站\",\"value\":200},{\"stationName\":\"李村站\",\"value\":200},{\"stationName\":\"君峰路站\",\"value\":200},{\"stationName\":\"振华路站\",\"value\":200},{\"stationName\":\"永平路站\",\"value\":200},{\"stationName\":\"青岛北站\",\"value\":200}]},\n"+
                 "{\"id\":11\"peekValue\":[{\"stationName\":\"苗岭路站\",\"value\":200},{\"stationName\":\"会展中心站\",\"value\":200},{\"stationName\":\"青岛二中站\",\"value\":200},{\"stationName\":\"青岛科大站\",\"value\":200},{\"stationName\":\"张村站\",\"value\":200},{\"stationName\":\"枯桃站\",\"value\":200},{\"stationName\":\"海洋大学站\",\"value\":200},{\"stationName\":\"世博园站\",\"value\":200},{\"stationName\":\"北宅站\",\"value\":200},{\"stationName\":\"北九水站\",\"value\":200},{\"stationName\":\"庙石站\",\"value\":200},{\"stationName\":\"浦里站\",\"value\":200},{\"stationName\":\"鳌山卫站\",\"value\":200},{\"stationName\":\"山东大学站\",\"value\":200},{\"stationName\":\"蓝色硅谷站\",\"value\":200},{\"stationName\":\"水泊站\",\"value\":200},{\"stationName\":\"博览中心站\",\"value\":200},{\"stationName\":\"温泉东站\",\"value\":200},{\"stationName\":\"皋虞站\",\"value\":200},{\"stationName\":\"臧村站\",\"value\":200},{\"stationName\":\"钱谷山站\",\"value\":200},{\"stationName\":\"鳌山湾站\",\"value\":200}]},\n"+
                 "{\"id\":13,\"peekValue\":[{\"stationName\":\"嘉陵江路站\",\"value\":200},{\"stationName\":\"香江路站\",\"value\":200},{\"stationName\":\"井冈山路站\",\"value\":200},{\"stationName\":\"积米崖站\",\"value\":200},{\"stationName\":\"积米崖站\",\"value\":200},{\"stationName\":\"学院路站\",\"value\":200},{\"stationName\":\"朝阳山站\",\"value\":200},{\"stationName\":\"辛屯（灵山湾站）\",\"value\":200},{\"stationName\":\"两河站\",\"value\":200},{\"stationName\":\"隐珠站\",\"value\":200},{\"stationName\":\"凤凰山路站\",\"value\":200},{\"stationName\":\"双珠路站\",\"value\":200},{\"stationName\":\"世纪大道站\",\"value\":200},{\"stationName\":\"盛海路（世博城站）\",\"value\":200},{\"stationName\":\"大珠山站\",\"value\":200},{\"stationName\":\"张家楼站\",\"value\":200},{\"stationName\":\"古镇口站\",\"value\":200},{\"stationName\":\"龙湾站\",\"value\":200},{\"stationName\":\"琅琊站\",\"value\":200},{\"stationName\":\"贡口湾站\",\"value\":200},{\"stationName\":\"董家口港站\",\"value\":200},{\"stationName\":\"泊里站\",\"value\":200},{\"stationName\":\"董家口火车站\",\"value\":200}]},]\n"+
                 " }");
    }

    //  public List<FrontData> productData() {
//    List<FrontData> result = new ArrayList<>();
//
//    Map<String, List<String>> line2stations = energyProperties.getLine2stations();
//    double netValue = 0;
//    //获取每条线路编号
//    for (String line : line2stations.keySet()) {
//      //获取线路中的车站编号
//      List<String> stations = line2stations.get(line);
//      //对每个车站赋值
//      for (String station : stations) {
//        String lineId = line;
//        String stationId = station;
//        if (lineId.length() == 1) {
//          lineId = "0" + lineId;
//        }
//        if (stationId.length() == 1) {
//          stationId = "0" + stationId;
//        }
//        FrontData frontData = new FrontData(lineId, stationId, Math.random() * 10 + 200,
//            Math.random() * 10 + 200, Math.random() * 10 + 200, Math.random() * 10 + 200);
//        result.add(frontData);
//      }
//    }
//    return result;
//  }
    private JSONObject productTotalData() {
        JSONObject totalInfo = new JSONObject();
        totalInfo.put("operationalMileage", (int) (Math.random() * 100 + 50));
        totalInfo.put("onlineRanking", (int) (Math.random() * 100 + 50));
        totalInfo.put("peopleNumber", (int) (Math.random() * 100));
        return totalInfo;

    }

    private List<JSONObject> productLineData() {
        List<JSONObject> jsonObjects = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            JSONObject lineInfo = new JSONObject();
            lineInfo.put("id", "0" + i);
            lineInfo.put("inBoundCapacity", (int) (Math.random() * 100 + 100));
            lineInfo.put("outBoundCapacity", (int) (Math.random() * 100 + 100));
            lineInfo.put("chainRatio", Math.random());
            lineInfo.put("shijifache", (int) (Math.random() * 100 + 100));
            lineInfo.put("jihuafache", (int) (Math.random() * 100 + 100));
            lineInfo.put("shijifache", (int) (Math.random() * 100 + 100));
            lineInfo.put("zhengdian", Math.random());
            lineInfo.put("duixian", Math.random());
            jsonObjects.add(lineInfo);
        }
        return jsonObjects;
    }
}
