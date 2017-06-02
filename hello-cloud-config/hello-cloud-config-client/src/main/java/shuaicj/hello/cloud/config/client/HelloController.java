package shuaicj.hello.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple spring boot rest controller.
 *
 * @author shuaicj 2017/06/02
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${hello.author}")
    private String author;

    @GetMapping("/hello")
    public String hello() {
        return "Hello " + author + "!";
    }
}

