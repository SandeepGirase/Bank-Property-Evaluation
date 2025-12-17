package com.bankPropertyApplication.propertyEvaluation.property;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PropertyService {

    private final PropertyRepository repository;

    public PropertyService(PropertyRepository repository) {
        this.repository = repository;
    }

    public Property create(Property property) {
        return repository.save(property);
    }

    public List<Property> list() {
        return repository.findAll();
    }

    public Optional<Property> get(Long id) {
        return repository.findById(id);
    }

    public Property update(Long id, Property updated) {
        return repository.findById(id).map(existing -> {
            existing.setAddress(updated.getAddress());
            existing.setOwner(updated.getOwner());
            existing.setPrice(updated.getPrice());
            existing.setBedrooms(updated.getBedrooms());
            existing.setBathrooms(updated.getBathrooms());
            existing.setArea(updated.getArea());
            return repository.save(existing);
        }).orElseThrow(() -> new IllegalArgumentException("Property not found: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
