package zwy.importdata.config;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * EnergyProperties
 */
@Component
@ConfigurationProperties(prefix = "energy")
public class EnergyProperties {

  private Map<String, List<String>> table2codes;
  private Map<String, List<String>> line2stations;

  public Map<String, List<String>> getTable2codes() {
    return table2codes;
  }

  public List<String> getCodeList(String tableBaseName) {return table2codes.get(tableBaseName); }

  public void setTable2codes(Map<String, List<String>> table2codes) {
    this.table2codes = table2codes;
  }

  public Map<String, List<String>> getLine2stations() {
    return line2stations;
  }

  public void setLine2stations(
      Map<String, List<String>> line2stations) {
    this.line2stations = line2stations;
  }

  public List<String> getStationsByLine(String line) {
    return line2stations.get(line);
  }
}
