package com.bank.accounts.service.client;

import com.bank.accounts.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Method signature and return should be the same as defined in bank-loans microservice.
 * What happens in @FeignClient("bank-loans"), is that behind the scenes, feign client connects to the eureka server and fetches all the instances registered
 * with the logical name bank-loans. Remember is Feign Client name and logical name of the service in Eureka are the same, and we don't mention service URL.
 * It will then cache those details for 30 seconds. It will use this for 30 seconds
 * and will not connect with eureka server
 */
//@FeignClient(name = "bank-loans", fallback = LoansFallback.class) // UNCOMMENT for EUREKA Setup: This configuration work with Eureka as we provide integration details of Eureka (location, port etc)
@FeignClient(name="bank-loans", url = "http://bank-loans:8090", fallback = LoansFallback.class) // UNCOMMENT for K8S service discovery. We need to provide complete URL and there is no integration details added to bank-accounts
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("bank-correlation-id")
                                                         String correlationId, @RequestParam String mobileNumber);
}
