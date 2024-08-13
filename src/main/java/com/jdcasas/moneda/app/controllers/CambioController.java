package com.jdcasas.moneda.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jdcasas.moneda.app.domain.request.TipoCambioMonedaRequest;
import com.jdcasas.moneda.app.domain.response.TipoCambioMonedaResponse;
import com.jdcasas.moneda.app.entity.Cambio;
import com.jdcasas.moneda.app.service.CambioService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/cambio")
public class CambioController {
	
	@Autowired
	private CambioService service;
	
	@PostMapping("/tipoCambio")
	public Mono<TipoCambioMonedaResponse> tipoCambio(@Valid @RequestBody TipoCambioMonedaRequest request) {
		return service.initFlow(Cambio.builder()
				.monto(request.getMonto())
				.monedaOrigen(request.getMonedaOrigen())
				.monedaDestino(request.getMonedaDestino())
				.build());
	}
	
	@GetMapping("/findAll")
	public Flux<Cambio> findAllPosts() {
		return service.findAll();
	}
	
}