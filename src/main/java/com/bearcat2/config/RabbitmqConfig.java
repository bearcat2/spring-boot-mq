package com.bearcat2.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Description: rabbitmq配置类 </p>
 * <p> Title: RabbitmqConfig </p>
 * <p> Create Time: 2019/6/6 9:53 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Configuration
public class RabbitmqConfig {

    public static final String FANOUT_A_QUEUE = "fanout_a_queue";
    public static final String FANOUT_B_QUEUE = "fanout_b_queue";
    public static final String FANOUT_C_QUEUE = "fanout_c_queue";
    public static final String FANOUT_EXCHANGE = "fanout_Exchange";

    public static final String DIRECT_EXCHANGE = "direct_Exchange";
    public static final String DIRECT_A_QUEUE = "direct_a_queue";
    public static final String DIRECT_B_QUEUE = "direct_b_queue";
    public static final String DIRECT_A_ROUTING = "direct_a_routing";
    public static final String DIRECT_B_ROUTING = "direct_b_routing";

    // fanout 交换机
    @Bean
    public Queue fanout_a_queue() {
        return new Queue(FANOUT_A_QUEUE);
    }

    @Bean
    public Queue fanout_b_queue() {
        return new Queue(FANOUT_B_QUEUE);
    }

    @Bean
    public Queue fanout_c_queue() {
        return new Queue(FANOUT_C_QUEUE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueA() {
        return BindingBuilder.bind(fanout_a_queue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingQueueB() {
        return BindingBuilder.bind(fanout_b_queue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingQueueC() {
        return BindingBuilder.bind(fanout_c_queue()).to(fanoutExchange());
    }

    // direct 交换机
    @Bean
    public Queue direct_a_queue() {
        return new Queue(DIRECT_A_QUEUE);
    }

    @Bean
    public Queue direct_b_queue() {
        return new Queue(DIRECT_B_QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueAUseDirectExchange() {
        return BindingBuilder.bind(direct_a_queue())
                .to(directExchange())
                .with(DIRECT_A_ROUTING);
    }

    @Bean
    public Binding bindingQueueBUseDirectExchange() {
        return BindingBuilder.bind(direct_b_queue())
                .to(directExchange())
                .with(DIRECT_B_ROUTING);
    }

    // topic 交换机和 direct 差不多，只有路由key不再是一个固定的字符串可以使用通配符（*或#）

}
