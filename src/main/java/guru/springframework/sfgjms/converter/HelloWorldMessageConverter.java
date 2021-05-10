package guru.springframework.sfgjms.converter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class HelloWorldMessageConverter
    implements MessageConverter
{
  private final ObjectMapper mapper;

  @Override
  public Message toMessage(Object object, Session session)
      throws JMSException
  {
    HelloWorldMessage tempMessage = (HelloWorldMessage) object;
    String payload = null;
    try {
      payload = mapper.writeValueAsString(tempMessage);
      log.debug("outbound json='{}'", payload);
    }
    catch (JsonProcessingException e) {
      log.error("error converting form tempMessage", e);
    }

    TextMessage message = session.createTextMessage();
    message.setText(payload);

    return message;
  }

  @Override
  public Object fromMessage(Message message) throws JMSException {
    TextMessage textMessage = (TextMessage) message;
    String payload = textMessage.getText();
    log.debug("inbound json='{}'", payload);

    HelloWorldMessage tempMessage = null;
    try {
      tempMessage = mapper.readValue(payload, HelloWorldMessage.class);
    }
    catch (Exception e) {
      log.error("error converting to tempMessage", e);
    }

    return tempMessage;
  }
}
