package shuaicj.hello.cloud.service.bakery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/06/06
 */
@RestController
@RefreshScope
public class BakeryController {

    @Value("#{T(java.net.InetAddress).getLocalHost().getHostName()}")
    private String host;

    @Value("#{T(java.net.InetAddress).getLocalHost().getHostAddress()}")
    private String ip;

    @Value("${server.port}")
    private int port;

    @Value("${bakery.name}")
    private String bakeryName;

    @GetMapping("/breads/{bread-name}")
    public String getBread(@RequestParam String customer, @PathVariable("bread-name") String breadName) {
        return host + ":" + ip + ":" + port + " " + bakeryName + " [" + customer + "] get bread [" + breadName + "]";
    }
}
