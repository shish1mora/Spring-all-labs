package com.example.laba6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public List<Material> getAllMaterials() {
        return materialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        return materialService.findById(id)
                .map(material -> ResponseEntity.ok().body(material))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material savedMaterial = materialService.save(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material material) {
        if (!materialService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        material.setId(id); // Устанавливаем ID для обновления
        Material updatedMaterial = materialService.save(material);
        return ResponseEntity.ok().body(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        if (!materialService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        materialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

