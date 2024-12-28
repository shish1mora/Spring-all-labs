package ru.karpov.laba6fx;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.List;

public class MaterialService {
    private final String BASE_URL = "http://localhost:8080/api/materials"; // URL вашего API
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Material> getAllMaterials() {
        return Arrays.asList(restTemplate.getForObject(BASE_URL, Material[].class));
    }

    public Material getMaterialById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Material.class);
    }

    public Material createMaterial(Material material) {
        return restTemplate.postForObject(BASE_URL, material, Material.class);
    }

    public void updateMaterial(Long id, Material material) {
        restTemplate.put(BASE_URL + "/" + id, material);
    }

    public void deleteMaterial(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}

