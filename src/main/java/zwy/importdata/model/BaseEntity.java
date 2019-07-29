package zwy.importdata.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Zhao Wenyue
 * @Date 2019/7/10
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "line_id")
  private String lineId;

  @Column(name = "station_id")
  private String stationId;

  @Column(name = "value")
  private Double value;

  @Column(name = "data_time")
  private Date dataTime;
}
