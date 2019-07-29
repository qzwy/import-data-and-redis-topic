package zwy.importdata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zwy.importdata.config.EnergyProperties;
import zwy.importdata.model.PassengerInBound5m;
import zwy.importdata.model.PassengerOutBound5m;
import zwy.importdata.repository.PassengerInBoundRepo5m;
import zwy.importdata.repository.PassengerOutBoundRepo5m;


/**
 * @author Zhao Wenyue
 *
 * 数据生成
 */
@Service
public class ProductData5Min {

  private final org.slf4j.Logger log = LoggerFactory.getLogger(ProductData5Min.class);

  private final PassengerInBoundRepo5m passengerInBoundRepo5m;
  private final PassengerOutBoundRepo5m passengerOutBoundRepo5m;

  private final EnergyProperties energyProperties;

  @Autowired
  public ProductData5Min(PassengerInBoundRepo5m passengerInBoundRepo5m,
      PassengerOutBoundRepo5m passengerOutBoundRepo5m,
      EnergyProperties energyProperties) {
    this.passengerInBoundRepo5m = passengerInBoundRepo5m;
    this.passengerOutBoundRepo5m = passengerOutBoundRepo5m;
    this.energyProperties = energyProperties;
  }

  /**
   * 1.获取当前时间 2.轮流为所有站点线路线网赋值 3.ok
   */
  public List<PassengerInBound5m> inBoundData() {
    List<PassengerInBound5m> result = new ArrayList<>();
    //当前时间
    Date currentTime = new Date();
    Map<String, List<String>> line2stations = energyProperties.getLine2stations();
    double netValue = 0;
    //获取每条线路编号
    for (String line : line2stations.keySet()) {
      double lineValue = 0;
      //获取线路中的车站编号
      List<String> stations = line2stations.get(line);
      //对每个车站赋值
      for (String station : stations) {
        String lineId = line;
        String stationId = station;
        if (lineId.length() == 1) {
          lineId = "0" + lineId;
        }
        if (stationId.length() == 1) {
          stationId = "0" + stationId;
        }
        PassengerInBound5m passengerInBoundDay = new PassengerInBound5m();
        passengerInBoundDay.setDataTime(currentTime);
        passengerInBoundDay.setLineId(lineId);
        passengerInBoundDay.setStationId(stationId);
        double value = Math.random() * 100 + 300;
        passengerInBoundDay.setValue(value);
        result.add(passengerInBoundDay);
        lineValue = lineValue + value;
      }
      //对每条线路赋值
      PassengerInBound5m passengerInBoundDay = new PassengerInBound5m();
      String lineId = line;
      if (lineId.length() == 1) {
        lineId = "0" + lineId;
      }
      passengerInBoundDay.setDataTime(currentTime);
      passengerInBoundDay.setLineId(lineId);
      passengerInBoundDay.setStationId(lineId);
      passengerInBoundDay.setValue(lineValue);
      result.add(passengerInBoundDay);
      netValue = netValue + lineValue;
    }
    //对全网赋值
    PassengerInBound5m passengerInBoundDay = new PassengerInBound5m();
    passengerInBoundDay.setDataTime(currentTime);
    passengerInBoundDay.setLineId("FF");
    passengerInBoundDay.setStationId("FF");
    passengerInBoundDay.setValue(netValue);
    result.add(passengerInBoundDay);
    return result;
  }

  /**
   * 5分钟出站
   * @return
   */
  public List<PassengerOutBound5m> outBoundData() {
    List<PassengerOutBound5m> result = new ArrayList<>();
    //当前时间
    Date currentTime = new Date();
    Map<String, List<String>> line2stations = energyProperties.getLine2stations();
    double netValue = 0;
    //获取每条线路编号
    for (String line : line2stations.keySet()) {
      double lineValue = 0;
      //获取线路中的车站编号
      List<String> stations = line2stations.get(line);
      //对每个车站赋值
      for (String station : stations) {
        String lineId = line;
        String stationId = station;
        if (lineId.length() == 1) {
          lineId = "0" + lineId;
        }
        if (stationId.length() == 1) {
          stationId = "0" + stationId;
        }
        PassengerOutBound5m passengerOutBound5m = new PassengerOutBound5m();
        passengerOutBound5m.setDataTime(currentTime);
        passengerOutBound5m.setLineId(lineId);
        passengerOutBound5m.setStationId(stationId);
        double value = Math.random() * 100 + 300;
        passengerOutBound5m.setValue(value);
        result.add(passengerOutBound5m);
        lineValue = lineValue + value;
      }
      //对每条线路赋值
      PassengerOutBound5m passengerOutBound5m = new PassengerOutBound5m();
      String lineId = line;
      if (lineId.length() == 1) {
        lineId = "0" + lineId;
      }
      passengerOutBound5m.setDataTime(currentTime);
      passengerOutBound5m.setLineId(lineId);
      passengerOutBound5m.setStationId(lineId);
      passengerOutBound5m.setValue(lineValue);
      result.add(passengerOutBound5m);
      netValue = netValue + lineValue;
    }
    //对全网赋值
    PassengerOutBound5m passengerOutBound5m = new PassengerOutBound5m();
    passengerOutBound5m.setDataTime(currentTime);
    passengerOutBound5m.setLineId("FF");
    passengerOutBound5m.setStationId("FF");
    passengerOutBound5m.setValue(netValue);
    result.add(passengerOutBound5m);
    return result;
  }


  public void save5m(List<PassengerInBound5m> dataIn, List<PassengerOutBound5m> dataOut) {
     passengerInBoundRepo5m.saveAll(dataIn);
     passengerOutBoundRepo5m.saveAll(dataOut);
  }
}
