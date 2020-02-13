package com.cortes.stock.stockservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cortes.stock.stockservice.model.StockQuote;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

	String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/byusername/{username}")
	public List<StockQuote> getStock(@PathVariable("username") final String username){
//		List<String> quotes = restTemplate.getForObject("http://localhost:8082/rest/db/byusername/"+username, List.class);
		ResponseEntity<List<String>> quotesResponse = restTemplate.exchange("http://localhost:8082/rest/db/byusername/"+username, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
		List<String> quotes = quotesResponse.getBody();
		return null;
	}
}
