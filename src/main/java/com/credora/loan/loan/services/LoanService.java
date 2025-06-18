package com.credora.loan.loan.services;

import com.credora.loan.common.dto.StringResponseDto;
import com.credora.loan.loan.dto.LoanApplicationDto;

import java.util.UUID;

public interface LoanService {
   StringResponseDto loanApply(LoanApplicationDto request, UUID userId);
}
