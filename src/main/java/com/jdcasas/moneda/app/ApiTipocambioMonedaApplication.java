package com.jdcasas.moneda.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.web.reactive.config.EnableWebFlux;
import com.jdcasas.moneda.app.utils.Constants;

@EnableFeignClients
@SpringBootApplication
@EnableWebFlux
public class ApiTipocambioMonedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTipocambioMonedaApplication.class, args);
	}

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource(Constants.SCRIPT_SQL)));
		return initializer;
	}
	
	@Bean
	public Decoder decoder(ObjectMapper objectMapper) {
	    return new JacksonDecoder(objectMapper);
	}

	@Bean
	public Encoder encoder(ObjectMapper objectMapper) {
	    return new JacksonEncoder(objectMapper);
	}
	
}
