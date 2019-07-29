package zwy.importdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zwy.importdata.model.PassengerInBoundDay;

@Repository
public interface PassengerInBoundRepoDay extends JpaRepository<PassengerInBoundDay, Long> {

}
