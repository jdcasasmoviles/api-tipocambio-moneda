package com.jdcasas.moneda.app.infrastructure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jdcasas.moneda.app.infrastructure.model.apitipocambio.TipoCambioResponse;

@FeignClient(value = "apiTipoCambio", url = "https://open.er-api.com/v6/latest")
public interface IApiTipoCambio {
	
	  @RequestMapping(method = RequestMethod.GET, value = "/{rate}", produces = "application/json")
	  TipoCambioResponse    obtenerTipoCambio(@PathVariable String rate);
}

