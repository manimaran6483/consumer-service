package com.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-client", url = "http://54.224.38.209:8081/auth")
public interface AuthClient {

	@GetMapping("/validate")
	public boolean validate(@RequestParam String token);
}
