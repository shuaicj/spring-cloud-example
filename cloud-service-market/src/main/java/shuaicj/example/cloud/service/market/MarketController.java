package shuaicj.example.cloud.service.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/06/14
 */
@RestController
@RefreshScope
@RequestMapping("/market")
public class MarketController {

    @Value("#{T(java.net.InetAddress).getLocalHost().getHostName()}")
    private String host;

    @Value("#{T(java.net.InetAddress).getLocalHost().getHostAddress()}")
    private String ip;

    @Value("${server.port}")
    private int port;

    @Value("${market.bread.price}")
    private int price;

    @Autowired
    private FeignBakery bakery;

    @GetMapping("/breads/{name}")
    public String getBread(@RequestParam String customer, @PathVariable String name) {
        return "[" + host + " " + ip + ":" + port + " market] "
                + customer + " spend $" + price + " on " + name
                + "\n  --> " + bakery.getBread("market", name);
    }
}
