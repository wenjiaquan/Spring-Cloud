package com.wenjiaquan.springcloud.order.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    /**
     * restTemplate发送请求
     * LoadBalanced 注解可以负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 负债均衡的算法
     * @return
     */
    @Bean
    public IRule iRule(){
        //随机算法
        return new RandomRule();
        //轮训算法
        //return new RoundRobinRule();
    }
}
