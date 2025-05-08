package com.credora.loan.common.response_interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
  private boolean success;
  private T data;
}
