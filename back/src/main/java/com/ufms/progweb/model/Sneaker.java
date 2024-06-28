package com.ufms.progweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table
public class Sneaker {

    @Id
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
