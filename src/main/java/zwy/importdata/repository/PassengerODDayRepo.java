package zwy.importdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zwy.importdata.model.PassengerODDay;

@Repository
public interface PassengerODDayRepo extends JpaRepository<PassengerODDay, Long> {

}
