package shuaicj.example.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config server.
 *
 * @author shuaicj 2017/06/02
 */
@SpringBootApplication
@EnableConfigServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
