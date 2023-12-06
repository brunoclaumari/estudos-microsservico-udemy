package com.microsservicos.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.bookservice.model.Book;
import com.microsservicos.bookservice.proxyfeignclients.CambioProxy;
import com.microsservicos.bookservice.repository.BookRepository;
import com.microsservicos.bookservice.response.Cambio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping(value = "/book-service")
public class BookController {

	@Autowired
    private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy proxy; 
	
	//http://localhost:8100/book-service/14/BRL
	@Operation(summary = "Find a specific book by your ID")
	@GetMapping(value = "/{id}/{currency}")
	public ResponseEntity<Object> findBook(
			@PathVariable Long id, @PathVariable String currency){		
		
		try {
			Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
			var port = environment.getProperty("local.server.port");
			
			Cambio cambio = proxy.getCambio(book.getPrice(), "USD", currency).getBody();
			//Cambio cambio = new Cambio(1L, "USD", currency, null, 2.5, currency);
			
			book.setEnvironment("Book port: " + port + " Cambio port: " + cambio.getEnvironment());
			book.setCurrency(currency);
			book.setPrice(cambio.getConvertedValue());
			
			return ResponseEntity.ok().body(book);
			
		} catch (RuntimeException e) {
			String erro = "{ status: " + HttpStatus.NOT_FOUND.value() 
			+ ", error: "+ e.getMessage() + " }";
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(erro);
		}		
		
	}
}
