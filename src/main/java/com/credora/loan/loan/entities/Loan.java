package com.credora.loan.loan.entities;

import com.credora.loan.loan.enums.Currency;
import com.credora.loan.loan.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "loans",
        indexes = {
                @Index(name = "idx_user_id", columnList = "user_id")
        }
)
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(nullable = false, precision = 15, scale = 2)
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  @Builder.Default
  private Currency currency = Currency.NAIRA;

  @Column(nullable = false)
  private Integer duration;

  @Column(nullable = false, length = 255)
  private String purpose;

  @Column(name = "payment_date")
  private LocalDateTime paymentDate;

  @Column(name = "payed_on")
  private LocalDateTime payedOn;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  @Builder.Default
  private LoanStatus status = LoanStatus.PENDING;

  @Column(name = "amount_paid", precision = 15, scale = 2)
  private BigDecimal amountPaid;

  @Column(name = "outstanding_balance", precision = 15, scale = 2)
  private BigDecimal outstandingBalance;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private LocalDateTime updatedAt;
}
