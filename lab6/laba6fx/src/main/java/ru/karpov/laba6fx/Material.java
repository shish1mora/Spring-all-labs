package ru.karpov.laba6fx;

import java.math.BigDecimal;

public class Material {
    private Long id;
    private String type;
    private String color;
    private String size;


    // Конструкторы, геттеры и сеттеры
    public Material() {}

    public Material(Long id, String type, String color, String size) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.size = size;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}

