package guru.springframework.sfgjms.listener;

import guru.springframework.sfgjms.config.JmsConfig2;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HelloMessageListener
{
  private final JmsTemplate jmsTemplate;

  @JmsListener(destination = JmsConfig2.MY_QUEUE)
  public void listen(String message) {
    System.out.println("I got a message!");

    System.out.println(message);
  }

  /*
  @JmsListener(destination = JmsConfig.MY_QUEUE)
  public void listen(@Payload HelloWorldMessage helloWorldMessage,
                     @Headers MessageHeaders headers,
                     Message message) {
    System.out.println("I got a message!");

    System.out.println(helloWorldMessage);
  }
/*
  @JmsListener(destination = JmsConfig.MY_SEND_RECEIVE_QUEUE)
  public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                     @Headers MessageHeaders headers,
                     Message message) throws JMSException
  {
    HelloWorldMessage payloadMessage = HelloWorldMessage
        .builder()
        .id(UUID.randomUUID())
        .message("World!")
        .build();

    jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMessage);
  }
  */

}
