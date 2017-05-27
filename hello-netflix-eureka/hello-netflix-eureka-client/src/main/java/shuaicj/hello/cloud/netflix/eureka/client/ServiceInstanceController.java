package shuaicj.hello.cloud.netflix.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Get the info for service instances.
 *
 * @author shuaicj 2017/05/27
 */
@RestController
public class ServiceInstanceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{name}")
    public List<ServiceInstance> list(@PathVariable String name) {
        return this.discoveryClient.getInstances(name);
    }
}
