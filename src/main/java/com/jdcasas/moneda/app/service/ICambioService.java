package com.jdcasas.moneda.app.service;
import com.jdcasas.moneda.app.domain.response.TipoCambioMonedaResponse;
import com.jdcasas.moneda.app.entity.Cambio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICambioService {
	Mono<TipoCambioMonedaResponse>   initFlow(Cambio cambioMoneda);
	Flux<Cambio> findAll();
	Mono<TipoCambioMonedaResponse>  covertMoneda(Cambio cambio);
}
