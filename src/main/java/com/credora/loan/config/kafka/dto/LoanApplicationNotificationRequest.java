package com.credora.loan.config.kafka.dto;

import com.credora.loan.loan.enums.LoanStatus;

import java.util.UUID;

public record LoanApplicationNotificationRequest(
        UUID loanApplicationId,
        UUID customerId,
        LoanStatus status,
        String message
) {
}
