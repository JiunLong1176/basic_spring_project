package com.example.demo.model;

import java.math.BigDecimal;

import com.example.demo.entity.Customer;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TransModel {
    private Long id;
    private Customer customer;
    private String name;
    private BigDecimal amount;
}
