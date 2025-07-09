package com.petmanager.models.dto;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long petId;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(length = 45)
    private String breed;

    @Column(name = "color", length = 45)
    private String color;

    @Column(length = 45)
    private String sex;

    // Constructor vacío
    public Pet() {}

    // Constructor con parámetros
    public Pet(String name, String breed, String color, String sex) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.sex = sex;
    }

    // Getters y Setters
    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pet [petId=" + petId + ", name=" + name + ", breed=" + breed +
               ", color=" + color + ", sex=" + sex + "]";
    }
}
