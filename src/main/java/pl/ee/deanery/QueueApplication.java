package pl.ee.deanery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class QueueApplication {

  public static void main(String[] args) {
    SpringApplication.run(QueueApplication.class, args);
  }

}
