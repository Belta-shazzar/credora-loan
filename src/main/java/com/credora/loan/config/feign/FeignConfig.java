package com.credora.loan.config.feign;

import brave.Tracer;
import brave.propagation.CurrentTraceContext;
import brave.propagation.TraceContext;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
  @Bean
  public RequestInterceptor requestInterceptor(CurrentTraceContext currentTraceContext, Tracer tracer) {

    return requestTemplate -> {
      TraceContext traceContext = currentTraceContext.get();
      if (traceContext != null) {
        requestTemplate.header("X-B3-TraceId", traceContext.traceIdString());
        requestTemplate.header("X-B3-SpanId", Long.toHexString(traceContext.spanId()));
        if (traceContext.parentId() != null) {
          requestTemplate.header("X-B3-ParentSpanId", Long.toHexString(traceContext.parentId()));
        }
      }
    };
  }
}
