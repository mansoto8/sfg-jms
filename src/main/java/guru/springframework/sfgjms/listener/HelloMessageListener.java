package guru.springframework.sfgjms.listener;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import guru.springframework.sfgjms.config.JmsConfig;
import guru.springframework.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HelloMessageListener
{
  private final JmsTemplate jmsTemplate;

  @JmsListener(destination = JmsConfig.MY_QUEUE, containerFactory = "myFactory")
  public void listen(HelloWorldMessage helloWorldMessage) {
    System.out.println(JmsConfig.MY_QUEUE
        + "- I got a message!: " + helloWorldMessage);
  }

  @JmsListener(destination = JmsConfig.MY_SEND_RECEIVE_QUEUE)
  public void listenForHello(
      @Payload HelloWorldMessage helloWorldMessage,
      @Headers MessageHeaders headers,
      Message message) throws JMSException
  {
    System.out.println(JmsConfig.MY_SEND_RECEIVE_QUEUE
        + "- Received message: " + helloWorldMessage);

    HelloWorldMessage payloadMessage = HelloWorldMessage
        .builder()
        .id(UUID.randomUUID())
        .message("Received your message Hello World!")
        .build();

    jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMessage);
  }
}
