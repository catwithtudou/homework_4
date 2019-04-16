package red.rock.homework4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Homework4Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework4Application.class, args);
    }

}
