package com.credora.loan.loan;

import com.credora.loan.common.dto.StringResponseDto;
import com.credora.loan.loan.dto.LoanApplicationDto;
import com.credora.loan.loan.services.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {
  private final LoanService loanService;

  @PostMapping("apply")
  @ResponseBody
  public ResponseEntity<StringResponseDto> loanApplication(@Valid @RequestBody LoanApplicationDto request) {
      StringResponseDto responseDto = this.loanService.loanApply(request, UUID.fromString("e8692709-7243-48c5-be32-09a2999db3ad"));
      return ResponseEntity
               .status(HttpStatus.OK)
               .body(responseDto);
  }
}
