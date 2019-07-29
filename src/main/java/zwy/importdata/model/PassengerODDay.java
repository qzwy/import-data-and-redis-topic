package zwy.importdata.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "passenger_od_d")
@Data
public class PassengerODDay {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "o_station_id")
  private String origin;

  @Column(name = "d_station_id")
  private String destination;

  @Column(name = "value")
  private Double value;

  @Column(name = "data_time")
  private Date dataTime;

}
