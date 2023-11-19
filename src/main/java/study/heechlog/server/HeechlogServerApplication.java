package study.heechlog.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import study.heechlog.server.config.AppConfig;

@EnableConfigurationProperties(AppConfig.class)
@SpringBootApplication
public class HeechlogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeechlogServerApplication.class, args);
    }

}
