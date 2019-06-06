package com.bearcat2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * <p> Description: activemq 配置类 </p>
 * <p> Title: ActivemqConfig </p>
 * <p> Create Time: 2019/5/27 17:52 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Configuration
public class ActivemqConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //true为topic，false为queue
        factory.setPubSubDomain(true);
        return factory;
    }

}
