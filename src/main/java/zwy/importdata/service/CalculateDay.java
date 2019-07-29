package zwy.importdata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zwy.importdata.model.BaseType;
import zwy.importdata.model.PassengerInBoundDay;
import zwy.importdata.model.PassengerOutBoundDay;
import zwy.importdata.repository.PassengerInBoundRepo5m;
import zwy.importdata.repository.PassengerInBoundRepoDay;
import zwy.importdata.repository.PassengerOutBoundRepo5m;
import zwy.importdata.repository.PassengerOutBoundRepoDay;

@Service
public class CalculateDay {

  private final PassengerInBoundRepo5m passengerInBoundRepo5m;

  private final PassengerOutBoundRepo5m passengerOutBoundRepo5m;

  private final PassengerInBoundRepoDay passengerInBoundRepoDay;

  private final PassengerOutBoundRepoDay passengerOutBoundRepoDay;


  @Autowired
  public CalculateDay(PassengerInBoundRepo5m passengerInBoundRepo5m,PassengerOutBoundRepo5m passengerOutBoundRepo5m,
      PassengerInBoundRepoDay passengerInBoundRepoDay, PassengerOutBoundRepoDay passengerOutBoundRepoDay) {
    this.passengerInBoundRepo5m = passengerInBoundRepo5m;
    this.passengerInBoundRepoDay = passengerInBoundRepoDay;
    this.passengerOutBoundRepoDay = passengerOutBoundRepoDay;
    this.passengerOutBoundRepo5m = passengerOutBoundRepo5m;
  }

  /**
   * 1. sum()  group by stationId where time = ?
   * 2. save
   */
  public void sumPassengerInBound() {
    Date currentTime = new Date();
    List<BaseType> total = passengerInBoundRepo5m.total();
    List<PassengerInBoundDay> inBoundDaysList = new ArrayList<>();
    for (BaseType i : total){
      PassengerInBoundDay inBoundDay = new PassengerInBoundDay();
      inBoundDay.setStationId(i.getStationId());
      inBoundDay.setLineId(i.getLineId());
      inBoundDay.setDataTime(currentTime);
      inBoundDay.setValue(i.getValue());
      inBoundDaysList.add(inBoundDay);
    }
    passengerInBoundRepoDay.saveAll(inBoundDaysList);
  }

  public void sumPassengerOutBound() {
    Date currentTime = new Date();
    List<BaseType> total = passengerOutBoundRepo5m.total();
    List<PassengerOutBoundDay> outBoundDaysList = new ArrayList<>();
    for (BaseType i : total){
      PassengerOutBoundDay outBoundDay = new PassengerOutBoundDay();
      outBoundDay.setStationId(i.getStationId());
      outBoundDay.setLineId(i.getLineId());
      outBoundDay.setDataTime(currentTime);
      outBoundDay.setValue(i.getValue());
      outBoundDaysList.add(outBoundDay);
    }
    passengerOutBoundRepoDay.saveAll(outBoundDaysList);
  }


}
