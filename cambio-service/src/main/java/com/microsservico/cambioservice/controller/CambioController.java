package com.microsservico.cambioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservico.cambioservice.model.Cambio;
import com.microsservico.cambioservice.repository.CambioRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/cambio-service")
public class CambioController {
	
	private Logger logger = LoggerFactory.getLogger(CambioController.class);

    @Autowired
    private Environment environment;
    
    @Autowired
    private CambioRepository repository;

    //http://localhost:8000/cambio-service/5/USD/BRL
    @Operation(summary = "Get cambio from currency")
    @GetMapping("/{amount}/{from}/{to}")
    public ResponseEntity<Cambio> getCambio(
        @PathVariable BigDecimal amount,
        @PathVariable String from,
        @PathVariable String to
    ){

    	logger.info("getCambio is called with -> {}, {} and {} ", amount, from, to);
    	Cambio retornoCambio = repository.findByFromAndTo(from, to);
    	if(retornoCambio == null) {
    		throw new RuntimeException("Currency Unsupported");
    	}
    	
        var port = environment.getProperty("local.server.port");
        
        BigDecimal convertedValue = retornoCambio.getConversionFactor().multiply(amount);
        
        retornoCambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        retornoCambio.setEnvironment(port);
        //Cambio cambio = new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);

        return ResponseEntity.ok().body(retornoCambio);
    }
    
}
