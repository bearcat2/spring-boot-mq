package com.bearcat2.mq.activemq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

/**
 * <p> Description: activemq 消费者 </p>
 * <p> Title: ActivemqConsumer </p>
 * <p> Create Time: 2019/5/27 16:53 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
@Component
public class ActivemqConsumer {

    /**
     * 监听queue消息
     *
     * @param message 生产者发送消息
     */
    @JmsListener(destination = "spring-boot-activemq-queue")
    public void receivedMessageUseQueue(String message) {
        log.info("【receivedMessageUseQueue】消费者接从queue接收到消息为：" + message);
    }

    /**
     * 监听topic消息
     * <p>
     * 注：JmsListener 默认只接受队列消息，无法接收topic消息 如果要接收 topic 消息 需在全局配置文件配置  spring.jms.pubSubDomain=true 配置过后，默认无法接收队列消息
     *
     * </p>
     *
     * @param message 生产者发送消息
     */
    @JmsListener(destination = "spring-boot-activemq-topic")
    public void receivedMessageUseTopic(String message) {
        log.info("【receivedMessageUseTopic】消费者接从topic接收到的消息为：" + message);
    }

    /**
     * 监听topic消息
     * <p>
     * 将spring.jms.pub-sub-domain改为true 或者 设置containerFactory 属性兼容接收队列和主题消息
     * </p>
     *
     * @param message 生产者发送消息
     * @see com.bearcat2.config.ActivemqConfig#jmsTopicListenerContainerFactory(ConnectionFactory)
     */
    @JmsListener(destination = "spring-boot-activemq-topic", containerFactory = "jmsTopicListenerContainerFactory")
    public void receivedMessageUseTopic1(String message) {
        log.info("【receivedMessageUseTopic1】消费者接从topic接收到的消息为：" + message);
    }
}
