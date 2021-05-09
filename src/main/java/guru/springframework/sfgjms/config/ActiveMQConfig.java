package guru.springframework.sfgjms.config;

import org.springframework.context.annotation.Configuration;

//@Configuration
public class ActiveMQConfig
{
  /*String BROKER_URL = "tcp://localhost:61616";

  String BROKER_USERNAME = "admin";

  String BROKER_PASSWORD = "admin";

  @Bean
  public ActiveMQConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
    connectionFactory.setPassword(BROKER_USERNAME);
    connectionFactory.setUser(BROKER_USERNAME);
    connectionFactory.setPassword(BROKER_PASSWORD);
    return connectionFactory;
  }

  @Bean
  public JmsTemplate jmsTemplate() {
    JmsTemplate template = new JmsTemplate();
    template.setConnectionFactory(connectionFactory());
    return template;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setPubSubDomain(true);
    return factory;
  }
  */

/*
  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    return factory;
  }
  */
/*
  @Bean
  public JmsListenerContainerFactory<?> myFactory(
      ConnectionFactory connectionFactory,
      DefaultJmsListenerContainerFactoryConfigurer configurer)
  {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    // This provides all boot's default to this factory, including the message converter
    configurer.configure(factory, connectionFactory);
    // You could still override some of Boot's default if necessary.
    return factory;
  }
  */
}
