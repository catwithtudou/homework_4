package red.rock.homework4.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 *  TODO
 * @author  tudou
 * @date  2019/4/16 16:28
 * @version  1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public AuthExceptionResolver authExceptionResolver(){
        return new AuthExceptionResolver();
    }
}
