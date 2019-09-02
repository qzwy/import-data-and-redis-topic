package zwy.importdata.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestTime {

    @Test
    public void test() {

        long l = System.currentTimeMillis();
        Instant instant = Instant.ofEpochMilli(l);
        System.out.println("instant = " + instant);
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault());
        System.out.println("date = " + date);

    }
}
