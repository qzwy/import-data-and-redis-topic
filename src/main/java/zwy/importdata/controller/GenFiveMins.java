package zwy.importdata.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GenFiveMins {

  public  Map<String, String> genFiveMins() throws Exception{
    String time = "00:00:00";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    Date first  = simpleDateFormat.parse(time);
    Map<String, String> map = new HashMap<>();
    for(int i = 0; i<= 288; i++){
      Date afterDate = new Date(first.getTime() + 300000);
      first = afterDate;
      map.put(String.valueOf(i+1),simpleDateFormat.format(first));
    }
    map.remove("289");
  return map;
  }
}
