package com.bearcat2.mq.rabbit;

import com.bearcat2.SpringBootMqApplicationTests;
import com.bearcat2.config.RabbitmqConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> Description: rabbitmq 测试类 </p>
 * <p> Title: RabbitmqProducerTest </p>
 * <p> Create Time: 2019/6/6 10:33 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class RabbitmqProducerTest extends SpringBootMqApplicationTests {

    @Autowired
    private RabbitmqProducer rabbitmqProducer;

    @Test
    public void sendMessageByFanoutExchange() {
        String msg = "welcome rabbitmq !! ";
        rabbitmqProducer.sendMessageByFanoutExchange(msg);
    }

    @Test
    public void sendMessageByDirectExchange() {
        rabbitmqProducer.sendMessageByDirectExchange(RabbitmqConfig.DIRECT_A_ROUTING, "11111 ");
        rabbitmqProducer.sendMessageByDirectExchange(RabbitmqConfig.DIRECT_B_ROUTING, "222222");
    }
}