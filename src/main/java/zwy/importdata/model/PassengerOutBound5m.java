package zwy.importdata.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "passenger_out_bound_5m")
@Data
@EqualsAndHashCode(callSuper = false)
public class PassengerOutBound5m extends BaseEntity{

}
