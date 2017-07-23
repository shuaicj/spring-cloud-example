package shuaicj.example.cloud.service.market;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Call bakery service via netflix feign.
 *
 * @author shuaicj 2017/06/14
 */
@FeignClient(name = "${market.feign.bakery.name}", path = "${market.feign.bakery.path}")
public interface FeignBakery {

    @GetMapping("/breads/{name}")
    String getBread(@RequestParam("customer") String customer, @PathVariable("name") String name);
}
