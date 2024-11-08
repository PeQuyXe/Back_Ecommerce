package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String displayName;

    // Getters and Setters
}
