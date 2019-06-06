package com.bearcat2.mq.rabbit;

import com.bearcat2.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p> Description: rabbitmq 消费者 </p>
 * <p> Title: RabbitMqConsumer </p>
 * <p> Create Time: 2019/6/6 11:12 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
@Component
public class RabbitMqConsumer {

    @RabbitListener(queues = RabbitmqConfig.FANOUT_A_QUEUE)
    public void receivedQueueA(String msg) {
        log.info("【RabbitMqConsumer】 队列名 = {} ,接收到的消息 = {}", RabbitmqConfig.FANOUT_A_QUEUE, msg);
    }

    @RabbitListener(queues = RabbitmqConfig.FANOUT_B_QUEUE)
    public void receivedQueueB(String msg) {
        log.info("【RabbitMqConsumer】 队列名 = {} ,接收到的消息 = {}", RabbitmqConfig.DIRECT_A_QUEUE, msg);
    }

    @RabbitListener(queues = RabbitmqConfig.FANOUT_C_QUEUE)
    public void receivedQueueC(String msg) {
        log.info("【RabbitMqConsumer】 队列名 = {} ,接收到的消息 = {}", RabbitmqConfig.DIRECT_B_QUEUE, msg);
    }


    @RabbitListener(queues = RabbitmqConfig.DIRECT_A_QUEUE)
    public void receivedQueueAByDirect(String msg) {
        log.info("【RabbitMqConsumer】 队列名 = {} ,接收到的消息 = {}", RabbitmqConfig.DIRECT_A_QUEUE, msg);
    }

    @RabbitListener(queues = RabbitmqConfig.DIRECT_B_QUEUE)
    public void receivedQueueBByDirect(String msg) {
        log.info("【RabbitMqConsumer】 队列名 = {} ,接收到的消息 = {}", RabbitmqConfig.DIRECT_B_QUEUE, msg);
    }


}
