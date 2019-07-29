package zwy.importdata.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "passenger_out_bound_d")
@EqualsAndHashCode(callSuper = false)
public class PassengerOutBoundDay extends BaseEntity{

}
