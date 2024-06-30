package com.ufms.progweb.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "sneaker")
@Table(name = "sneaker")
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private Integer size;

    @Column
    private BigDecimal price;

    @Column
    private String description;

}
