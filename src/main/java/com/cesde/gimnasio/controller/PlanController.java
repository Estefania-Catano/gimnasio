package com.cesde.gimnasio.controller;

import com.cesde.gimnasio.model.entity.Plan;
import com.cesde.gimnasio.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/planes")
@RequiredArgsConstructor
public class PlanController {

    private final PlanRepository planRepository;

    @GetMapping
    public List<Plan> listar() {
        return planRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plan obtenerPorId(@PathVariable Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Plan no encontrado con id: " + id));
    }

    @PostMapping
    public ResponseEntity<Plan> crear(@RequestBody Plan plan) {
        plan.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(planRepository.save(plan));
    }

    @PutMapping("/{id}")
    public Plan actualizar(@PathVariable Long id, @RequestBody Plan plan) {
        if (!planRepository.existsById(id)) {
            throw new NoSuchElementException("Plan no encontrado con id: " + id);
        }
        plan.setId(id);
        return planRepository.save(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!planRepository.existsById(id)) {
            throw new NoSuchElementException("Plan no encontrado con id: " + id);
        }
        planRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
