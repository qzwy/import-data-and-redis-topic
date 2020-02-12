package zwy.importdata.model;

public class StationFlow {

  String stationId;

  String stationName;

  String color;

  Integer inboundValue;

  Integer outBoundValue;

  public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public Integer getInboundValue() {
    return inboundValue;
  }

  public void setInboundValue(Integer inboundValue) {
    this.inboundValue = inboundValue;
  }

  public Integer getOutBoundValue() {
    return outBoundValue;
  }

  public void setOutBoundValue(Integer outBoundValue) {
    this.outBoundValue = outBoundValue;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
