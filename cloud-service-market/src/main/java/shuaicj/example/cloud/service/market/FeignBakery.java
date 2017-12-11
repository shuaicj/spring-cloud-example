package shuaicj.example.cloud.service.market;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Call bakery service via netflix feign.
 *
 * @author shuaicj 2017/06/14
 */
@FeignClient(
        name = "${market.feign.bakery.name}",
        path = "${market.feign.bakery.path}",
        fallback = FeignBakery.Fallback.class)
public interface FeignBakery {

    @GetMapping("/breads/{name}")
    String getBread(@RequestParam("customer") String customer, @PathVariable("name") String name);

    @Component
    class Fallback implements FeignBakery {
        @Override
        public String getBread(String customer, String name) {
            return "[fallback] market call bakery\n";
        }
    }
}
