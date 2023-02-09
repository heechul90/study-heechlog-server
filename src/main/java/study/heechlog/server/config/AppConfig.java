package study.heechlog.server.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ConfigurationProperties(prefix = "heechman")
@Setter
public class AppConfig {

    public String hello;
}
