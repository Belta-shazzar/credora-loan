package com.credora.loan.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
      name = "onboarding-service" // The name of the service by which it is fetched from the discovery service.
)
public interface UserClient {
  @GetMapping("/api/v1/users/{userId}")
//  Optional<Object> getUserDetailById(@PathVariable("userId") UUID userId);
  Object getUserDetailById(@PathVariable("userId") UUID userId);
}