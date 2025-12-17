package com.bankPropertyApplication.propertyEvaluation.property;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService service;

    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Property> create(@RequestBody Property property) {
        Property created = service.create(property);
        return ResponseEntity.created(URI.create("/api/properties/" + created.getId())).body(created);
    }

    @GetMapping
    public List<Property> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> get(@PathVariable Long id) {
        return service.get(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> update(@PathVariable Long id, @RequestBody Property property) {
        try {
            Property updated = service.update(id, property);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
