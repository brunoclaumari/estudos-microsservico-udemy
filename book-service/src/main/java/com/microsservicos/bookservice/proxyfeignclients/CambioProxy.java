package com.microsservicos.bookservice.proxyfeignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microsservicos.bookservice.response.Cambio;


@Component
//@FeignClient(name = "cambio-service", url = "localhost:8000") //sem o Load Balancer eureka
@FeignClient(name = "cambio-service") //com load balancer eureka
public interface CambioProxy {
	
	@GetMapping("/cambio-service/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> getCambio(
        @PathVariable Double amount,
        @PathVariable String from,
        @PathVariable String to
    );
	
}
