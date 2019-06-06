package com.bearcat2.mq.rabbit;

import com.bearcat2.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p> Description: rabbitmq生产者 </p>
 * <p> Title: RabbitmqProducer </p>
 * <p> Create Time: 2019/5/29 9:54 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
@Component
public class RabbitmqProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 使用 fanout 类型交换机发送消息
     *
     * @param msg 等待发送的消息
     */
    public void sendMessageByFanoutExchange(String msg) {
        // fanoutExchange 交换无需路由key,将消息发送到绑定的所有队列
        amqpTemplate.convertAndSend(RabbitmqConfig.FANOUT_EXCHANGE, null, msg);
    }


    /**
     * 使用 direct 类型交换机发送消息
     *
     * @param msg 等待发送的消息
     */
    public void sendMessageByDirectExchange(String routingKey, String msg) {
        // fanoutExchange 交换无需路由key,将消息发送到绑定的所有队列
        amqpTemplate.convertAndSend(RabbitmqConfig.DIRECT_EXCHANGE, routingKey, msg);
    }

}
