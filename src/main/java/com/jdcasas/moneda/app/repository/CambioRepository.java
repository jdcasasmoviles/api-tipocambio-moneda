package com.jdcasas.moneda.app.repository;
import com.jdcasas.moneda.app.entity.Cambio;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CambioRepository extends R2dbcRepository<Cambio,Long>{

}
