package com.jdcasas.moneda.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.jdcasas.moneda.app.domain.response.TipoCambioMonedaResponse;
import com.jdcasas.moneda.app.entity.Cambio;
import com.jdcasas.moneda.app.infrastructure.IApiTipoCambio;
import com.jdcasas.moneda.app.repository.CambioRepository;
import com.jdcasas.moneda.app.utils.Utility;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jboss.logging.Logger;
import com.jdcasas.moneda.app.utils.Constants;

@Service
public class CambioService implements ICambioService{
	private static final  Logger log = Logger.getLogger(CambioService.class);
	
	@Autowired
	private CambioRepository repository;
	
	@Autowired
	private IApiTipoCambio  apiTipoCambio;
	
	@Override
	 public Mono<TipoCambioMonedaResponse>  initFlow(Cambio cambio) {	
		if(Utility.validateMoneda(cambio.getMonedaOrigen())  && Utility.validateMoneda(cambio.getMonedaDestino())) { 
			return  covertMoneda(cambio);
		}else {
			return  Mono.just(TipoCambioMonedaResponse.builder().build()); 
		}
	}
	
	@Override
	public Mono<TipoCambioMonedaResponse>  covertMoneda(Cambio cambio) {
	return  Mono.just(apiTipoCambio.obtenerTipoCambio(cambio.getMonedaOrigen()))
			.flatMap(res->{
				log.info("Response cliente  "+Utility.objectToJson(res));
				cambio.setTipoCambio( res.getRates().get(cambio.getMonedaDestino()));
				cambio.setMontoTipoCambio(cambio.getMonto()*cambio.getTipoCambio());
				cambio.setFechaOperacion(LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.FORMAT_DATE)));
				 return  repository.save(cambio);
			}).flatMap(x->{
				log.info("Transaction "+x.getId()+"  Monto "+x.getMonto()+" Fecha "+x.getFechaOperacion());			 
				 return  Mono.just(TipoCambioMonedaResponse.builder()
				 .monto(x.getMonto())
				 .montoTipoDeCambio(x.getMontoTipoCambio())
				 .monedaOrigen(x.getMonedaOrigen())
				 .monedaDestino(x.getMonedaDestino())
				 .tipoCambio(x.getTipoCambio())
				 .build()); 
	 });
}

@Override
public Flux<Cambio> findAll() {
	return repository.findAll();
}
	
}