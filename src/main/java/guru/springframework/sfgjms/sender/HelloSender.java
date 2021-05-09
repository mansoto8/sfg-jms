package guru.springframework.sfgjms.sender;

import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.sfgjms.config.JmsConfig2;
import guru.springframework.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HelloSender
{
  private final JmsTemplate jmsTemplate;
  private final ObjectMapper objectMapper;

  @Scheduled(fixedRate = 2000)
  public void sendMessage() {
    System.out.println("Sending message");
    HelloWorldMessage message = HelloWorldMessage
        .builder()
        .id(UUID.randomUUID())
        .message("Hello world!")
        .build();

    jmsTemplate.convertAndSend(JmsConfig2.MY_QUEUE, "Mensaje a enviar");
  }
/*
  @Scheduled(fixedRate = 2000)
  public void sendAndReceiveMessage() throws JMSException {
    HelloWorldMessage message = HelloWorldMessage
        .builder()
        .id(UUID.randomUUID())
        .message("Hello world!")
        .build();

    Message response = jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RECEIVE_QUEUE, new MessageCreator() {
      @Override
      public Message createMessage(final Session session) throws JMSException {
        try {
          Message helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
          helloMessage.setStringProperty("_type", "guru.springframework.sfgjms.model.HelloWorldMessage");

          System.out.println("Sending hello");

          return helloMessage;
        }
        catch (JsonProcessingException e) {
          throw new JMSException(e.getMessage());
        }
      }
    });

    System.out.println("Receiving response: " + response.getBody(String.class));
  }
  */
}
