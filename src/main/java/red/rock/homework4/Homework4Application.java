package red.rock.homework4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@MapperScan("red.rock.homework4.Mapper")
@EnableScheduling
@SpringBootApplication
public class Homework4Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework4Application.class, args);
    }

}
