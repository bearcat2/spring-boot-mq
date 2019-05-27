package com.bearcat2.mq.activemq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Topic;

/**
 * <p> Description: activemq 生产者 </p>
 * <p> Title: ActivemqProducer </p>
 * <p> Create Time: 2019/5/8 10:20 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
@Component
public class ActivemqProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, Object message) throws JMSException {
        String msg = JSON.toJSONString(message);
        this.jmsMessagingTemplate.convertAndSend(destination, msg);
        String destinationName = "";
        if (destination instanceof ActiveMQQueue) {
            ActiveMQQueue queue = (ActiveMQQueue) destination;
            destinationName = queue.getQueueName();
        } else if (destination instanceof Topic) {
            Topic topic = (Topic) destination;
            destinationName = topic.getTopicName();
        }
        log.info("【ActivemqProducer】发送消息, 消息目的地 = {} , 消息内容 = {}", destinationName, msg);
    }

}
