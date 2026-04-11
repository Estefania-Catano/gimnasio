package com.cesde.gimnasio.repository;

import com.cesde.gimnasio.model.entity.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {

    List<Suscripcion> findBySocioId(Long socioId);

    List<Suscripcion> findByPlanId(Long planId);
}
