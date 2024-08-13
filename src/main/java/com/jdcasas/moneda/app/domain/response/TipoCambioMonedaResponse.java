package com.jdcasas.moneda.app.domain.response;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@NotNull
public class TipoCambioMonedaResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Float monto ;
	
	@NotNull
	private Float montoTipoDeCambio;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String monedaOrigen;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String monedaDestino;
	
	@NotNull
	private Float tipoCambio ;
}
