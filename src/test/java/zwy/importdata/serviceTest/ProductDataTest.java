package zwy.importdata.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import zwy.importdata.repository.PassengerInBoundRepo5m;
import zwy.importdata.service.CalculateDay;
import zwy.importdata.service.ImportOD;
import zwy.importdata.service.ProductData5Min;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDataTest {

  @Autowired
  private ProductData5Min productData;

  @Autowired
  private PassengerInBoundRepo5m passengerInBoundRepo5m;

  @Autowired
  private CalculateDay calculateDay;

  @Autowired
  private ImportOD importOD;



//  @Test
//  public void testProductData() {
//    List<PassengerInBound5m> passengerInBoundDays = productData.inBoundData();
//    productData.save5m(passengerInBoundDays);
//  }

  @Test
  public void test() {

    System.out.println("list = " + passengerInBoundRepo5m.total());
  }

  @Test
  public void calculate() {
    calculateDay.sumPassengerInBound();
    calculateDay.sumPassengerOutBound();
  }

  @Test
  public void importOd() {
    importOD.odImport();
  }
}
