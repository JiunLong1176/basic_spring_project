package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "trans")
@Data
@EqualsAndHashCode(callSuper = false)
public class Trans {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "custid", referencedColumnName = "id", nullable = true)
    private Customer customer;

    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Column(name = "amount", nullable = true, precision = 10, scale = 2)
    private BigDecimal amount;
}
