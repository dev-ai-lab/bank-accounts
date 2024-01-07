package com.bank.accounts.service.client;

import com.bank.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Method signature and return should be the same as defined in bank-cards microservice.
 * What happens in @FeignClient("bank-cards"), is that behind the scenes, feign client connects to the eureka server and fetches all the instances registered
 * with the logical name bank-cards. Remember is Feign Client name and logical name of the service in Eureka are the same, and we don't mention service URL. It will use this for 30 seconds
 * and will not connect with eureka server
 */
//@FeignClient(name = "bank-cards", fallback = CardsFallback.class) // UNCOMMENT for EUREKA Setup: This configuration work with Eureka as we provide integration details of Eureka (location, port etc)
@FeignClient(name="bank-cards", url = "http://bank-cards:9000", fallback = CardsFallback.class) // UNCOMMENT for K8S service discovery. We need to provide complete URL and there is no integration details added to bank-accounts
public interface CardsFeignClient {
    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("bank-correlation-id")
                                                         String correlationId, @RequestParam String mobileNumber);

}
