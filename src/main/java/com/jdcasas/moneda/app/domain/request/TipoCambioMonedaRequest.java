package com.jdcasas.moneda.app.domain.request;
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
public class TipoCambioMonedaRequest  implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@NotNull
	private Float monto ;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String monedaOrigen;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String monedaDestino;
}
