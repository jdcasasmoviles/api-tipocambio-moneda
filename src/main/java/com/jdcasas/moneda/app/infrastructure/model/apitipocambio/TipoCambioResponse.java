package com.jdcasas.moneda.app.infrastructure.model.apitipocambio;
import java.io.Serializable;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TipoCambioResponse implements Serializable{
	 private static final long serialVersionUID = 1L;
	 @JsonProperty("result")
	private String result;
	 @JsonProperty("provider")
	private String provider;
	 @JsonProperty("documentation")
	private String documentation;
	 @JsonProperty("terms_of_use")
	private String terms_of_use;
	 @JsonProperty("time_last_update_unix")
	private Long time_last_update_unix;
	 @JsonProperty("time_last_update_utc")
	private String time_last_update_utc;
	 @JsonProperty("time_next_update_unix")
	private Long time_next_update_unix;
	 @JsonProperty("time_next_update_utc")
	private String time_next_update_utc;
	 @JsonProperty("time_eol_unix")
	private int  time_eol_unix;
	 @JsonProperty("base_code")
	private String base_code;	
    @JsonProperty("rates")
    private  LinkedHashMap<String, Float>  rates;

}
