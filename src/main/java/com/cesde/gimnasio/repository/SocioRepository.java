package com.cesde.gimnasio.repository;

import com.cesde.gimnasio.model.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
