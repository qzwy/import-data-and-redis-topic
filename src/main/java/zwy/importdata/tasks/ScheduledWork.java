package zwy.importdata.tasks;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import zwy.importdata.model.PassengerInBound5m;
import zwy.importdata.model.PassengerOutBound5m;
import zwy.importdata.service.CalculateDay;
import zwy.importdata.service.ImportOD;
import zwy.importdata.service.ProductData5Min;

/**
 * 定时任务执行
 *
 * @author Zhao Wenyue
 */
@Component
@EnableScheduling
public class ScheduledWork {

  private final ProductData5Min productData;

  private final CalculateDay calculateDay;

  private final ImportOD importOD;

  @Autowired
  public ScheduledWork(ProductData5Min productData, CalculateDay calculateDay, ImportOD importOD) {
    this.productData = productData;
    this.calculateDay = calculateDay;
    this.importOD = importOD;
  }

  /**
   * 5分钟进出站生成
   */
  @Scheduled(cron = "0 0/5 * * * ? ")
  public void productPassenger5m() {
    List<PassengerInBound5m> passengerInBound5ms = productData.inBoundData();
    List<PassengerOutBound5m> passengerOutBound5ms = productData.outBoundData();
    productData.save5m(passengerInBound5ms, passengerOutBound5ms);
  }

  /**
   * 每天进出站量统计
   */
  @Scheduled(cron = "0 0 0 1/1 * ? ")
  public void sumPassenger5Min() {
    calculateDay.sumPassengerInBound();
    calculateDay.sumPassengerOutBound();
    importOD.odImport();
  }
}
