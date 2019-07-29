package zwy.importdata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zwy.importdata.config.EnergyProperties;
import zwy.importdata.model.PassengerODDay;
import zwy.importdata.repository.PassengerODDayRepo;

@Service
public class ImportOD {

  private final EnergyProperties energyProperties;
  private final PassengerODDayRepo passengerODDayRepo;

  @Autowired
  public ImportOD(EnergyProperties energyProperties, PassengerODDayRepo passengerODDayRepo) {
    this.energyProperties = energyProperties;
    this.passengerODDayRepo = passengerODDayRepo;
  }

  public void odImport() {
    Map<String, List<String>> line2stations = energyProperties.getLine2stations();
    List<String> allStations = new ArrayList<>();
    for (String line : line2stations.keySet()){
      List<String> list = line2stations.get(line);
      for (String station : list){
        allStations.add(station);
      }
    }
    List<PassengerODDay> passengerODDays = new ArrayList<>();
    for(String o : allStations){
      for(String d : allStations){
        PassengerODDay passengerODDay = new PassengerODDay();
        passengerODDay.setOrigin(o);
        passengerODDay.setDestination(d);
        passengerODDay.setValue(Math.random()*300);
        passengerODDay.setDataTime(new Date());
        passengerODDays.add(passengerODDay);
      }
    }
    passengerODDayRepo.saveAll(passengerODDays);
  }
}
