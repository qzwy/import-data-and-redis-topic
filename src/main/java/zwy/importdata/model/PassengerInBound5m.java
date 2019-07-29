package zwy.importdata.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Zhao Wenyue
 * @Date 2019/7/10
 */
@Entity
@Table(name = "passenger_in_bound_5m")
@Data
@EqualsAndHashCode(callSuper = false)
public class PassengerInBound5m extends BaseEntity{

}
