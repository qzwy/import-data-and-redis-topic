package zwy.importdata.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zwy.importdata.model.BaseType;
import zwy.importdata.model.PassengerInBound5m;

/**
 * @author Zhao Wenyue
 */
@Repository
public interface PassengerInBoundRepo5m extends JpaRepository<PassengerInBound5m, Long> {

  @Query(value = "SELECT line_id lineId, station_id stationId, sum(`value`) `value` FROM `passenger_in_bound_5m` WHERE  DATE(data_time) = DATE_SUB(CURRENT_DATE,INTERVAL 1 DAY) GROUP BY station_id, line_id", nativeQuery = true)
  List<BaseType> total();
}
