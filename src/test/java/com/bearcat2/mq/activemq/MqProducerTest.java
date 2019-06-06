package com.bearcat2.mq.activemq;

import com.bearcat2.SpringBootMqApplicationTests;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;
import javax.jms.JMSException;

/**
 * <p> Description: activemq 生产者测试类 </p>
 * <p> Title: MqProducerTest </p>
 * <p> Create Time: 2019/5/8 10:34 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class MqProducerTest extends SpringBootMqApplicationTests {

    @Autowired
    private ActivemqProducer activemqProducer;

    /**
     * 测试发送消息到队列
     *
     * @throws JMSException
     */
    @Test
    public void sendMessageUseQueue() throws JMSException {
        String queueName = "spring-boot-activemq-queue";
        Destination destination = new ActiveMQQueue(queueName);
        for (int i = 0; i < 10; i++) {
            String message = "hello world" + i;
            this.activemqProducer.sendMessage(destination, message);
        }
    }

    /**
     * 测试发送消息到主题
     *
     * @throws JMSException
     */
    @Test
    public void sendMessageUseTopic() throws JMSException {
        String topicName = "spring-boot-activemq-topic";
        Destination destination = new ActiveMQTopic(topicName);
        for (int i = 0; i < 10; i++) {
            String message = "hello world" + i;
            this.activemqProducer.sendMessage(destination, message);
        }
    }
}