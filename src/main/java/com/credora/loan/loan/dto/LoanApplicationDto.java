package com.credora.loan.loan.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record LoanApplicationDto(
        @NotNull(message = "Amount is required")
        @DecimalMin(value = "1000.00", inclusive = true, message = "Amount must be at least 1000")
        @Digits(integer = 10, fraction = 2, message = "Amount must be a valid monetary value")
        BigDecimal amount,

        @NotNull(message = "Duration is required")
        @Min(value = 1, message = "Duration must be at least 1 month")
        @Max(value = 60, message = "Duration must not exceed 60 months")
        int duration,

        @NotBlank(message = "Purpose is required")
        @Size(max = 255, message = "Purpose must not exceed 255 characters")
        String purpose
) {
}
