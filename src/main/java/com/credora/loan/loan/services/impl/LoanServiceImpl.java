package com.credora.loan.loan.services.impl;

import com.credora.loan.common.dto.StringResponseDto;
import com.credora.loan.config.kafka.KafkaProducerService;
import com.credora.loan.config.kafka.dto.LoanApplicationNotificationRequest;
import com.credora.loan.loan.dto.LoanApplicationDto;
import com.credora.loan.loan.enums.LoanStatus;
import com.credora.loan.loan.repositories.LoanRepository;
import com.credora.loan.loan.services.LoanService;
import com.credora.loan.user.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
  private final LoanRepository loanRepository;
  private final UserClient userClient;
  private final KafkaProducerService producerService;

  @Override
  public StringResponseDto loanApply(LoanApplicationDto request, UUID userId) {
    Object user = this.userClient.getUserDetailById(userId);
    System.out.println("The loan application is WIP");
    System.out.println("The user is " + user);

//    producerService.sendOnboardingConfirmationNotification(new LoanApplicationNotificationRequest(
//            UUID.randomUUID(),
//            userId,
//            LoanStatus.PENDING,
//            "The loan application is successful and would be reviewed shortly"
//    ));
    return new StringResponseDto("The loan application is successful and would be reviewed shortly");
  }
}
