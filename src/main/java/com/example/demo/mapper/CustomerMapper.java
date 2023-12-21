package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.base.BaseMapper;
import com.example.demo.entity.Customer;
import com.example.demo.model.CustomerModel;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerModel>{
    
}
