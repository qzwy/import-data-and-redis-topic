package zwy.importdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zwy.importdata.model.PassengerOutBoundDay;

@Repository
public interface PassengerOutBoundRepoDay extends JpaRepository<PassengerOutBoundDay, Long> {

}
