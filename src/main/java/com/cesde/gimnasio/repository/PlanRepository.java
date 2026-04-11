package com.cesde.gimnasio.repository;

import com.cesde.gimnasio.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
