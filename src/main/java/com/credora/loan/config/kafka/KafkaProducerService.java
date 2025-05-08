package com.credora.loan.config.kafka;


import com.credora.loan.config.kafka.dto.LoanApplicationNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {
  private final KafkaTemplate<String, LoanApplicationNotificationRequest> kafkaTemplate;

  public void sendOnboardingConfirmationNotification(LoanApplicationNotificationRequest request) {
    log.info("Sending loan application notification event: {}", request);

    try {
      // Send message directly to the topic instead of using headers
      CompletableFuture<SendResult<String, LoanApplicationNotificationRequest>> future =
              kafkaTemplate.send("loan-application-notification", request);

      future.whenComplete((result, ex) -> {
        if (ex == null) {
          log.info("Message sent successfully to topic: {}, partition: {}, offset: {}",
                  result.getRecordMetadata().topic(),
                  result.getRecordMetadata().partition(),
                  result.getRecordMetadata().offset());
        } else {
          log.error("Unable to send message due to: {}", ex.getMessage());
        }
      });
    } catch (Exception e) {
      log.error("Error sending message to Kafka: {}", e.getMessage(), e);
      throw e; // Re-throw to let the caller handle it
    }
  }
}
