package ru.karpov.laba6fx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import ru.karpov.laba6fx.Material;
import ru.karpov.laba6fx.MaterialService;

import java.math.BigDecimal;
import java.util.List;

public class MaterialController {
    @FXML
    private TextField typeField;
    @FXML
    private TextField colorField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField costField;
    @FXML
    private ListView<Material> materialListView;

    private MaterialService materialService = new MaterialService();

    @FXML
    public void initialize() {
        loadMaterials();
        materialListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                typeField.setText(newSelection.getType());
                colorField.setText(newSelection.getColor());
                sizeField.setText(newSelection.getSize());

            }
        });
    }

    private void loadMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        materialListView.getItems().clear();
        materialListView.getItems().addAll(materials);
    }

    @FXML
    public void createMaterial() {
        Material material = new Material(null, typeField.getText(), colorField.getText(), sizeField.getText());
        materialService.createMaterial(material);
        loadMaterials();
    }

    @FXML
    public void updateMaterial() {
        Material selectedMaterial = materialListView.getSelectionModel().getSelectedItem();
        if (selectedMaterial != null) {
            selectedMaterial.setType(typeField.getText());
            selectedMaterial.setColor(colorField.getText());
            selectedMaterial.setSize(sizeField.getText());
            materialService.updateMaterial(selectedMaterial.getId(), selectedMaterial);
            loadMaterials();
        }
    }

    @FXML
    public void deleteMaterial() {
        Material selectedMaterial = materialListView.getSelectionModel().getSelectedItem();
        if (selectedMaterial != null) {
            materialService.deleteMaterial(selectedMaterial.getId());
            loadMaterials();
        }
    }
}

