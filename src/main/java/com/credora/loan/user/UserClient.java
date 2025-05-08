package com.credora.loan.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@FeignClient(
      name = "onboarding-service",
      url = "${application.config.onboarding-url}"
)
public interface UserClient {
  @GetMapping("/users/{userId}")
//  Optional<Object> getUserDetailById(@PathVariable("userId") UUID userId);
  Object getUserDetailById(@PathVariable("userId") UUID userId);
}