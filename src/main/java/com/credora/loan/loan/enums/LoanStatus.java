package com.credora.loan.loan.enums;

public enum LoanStatus {
  PENDING,
  APPROVED,
  REJECTED,
  ACTIVE,
  OVERDUE,
  REPAID,
  DEFAULTED, // Loans long overdue and at risk of not being paid
  CANCELLED
}
