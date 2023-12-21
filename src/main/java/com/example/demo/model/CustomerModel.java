package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerModel{
    private Long id;
    private String name;
    private String ic;
}
