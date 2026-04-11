package com.cesde.gimnasio.controller;

import com.cesde.gimnasio.model.entity.Socio;
import com.cesde.gimnasio.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/socios")
@RequiredArgsConstructor
public class SocioController {

    private final SocioRepository socioRepository;

    @GetMapping
    public List<Socio> listar() {
        return socioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Socio obtenerPorId(@PathVariable Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Socio no encontrado con id: " + id));
    }

    @PostMapping
    public ResponseEntity<Socio> crear(@RequestBody Socio socio) {
        socio.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(socioRepository.save(socio));
    }

    @PutMapping("/{id}")
    public Socio actualizar(@PathVariable Long id, @RequestBody Socio socio) {
        if (!socioRepository.existsById(id)) {
            throw new NoSuchElementException("Socio no encontrado con id: " + id);
        }
        socio.setId(id);
        return socioRepository.save(socio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!socioRepository.existsById(id)) {
            throw new NoSuchElementException("Socio no encontrado con id: " + id);
        }
        socioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
