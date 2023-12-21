package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.base.BaseMapper;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Trans;
import com.example.demo.model.CustomerModel;
import com.example.demo.model.TransModel;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.TransRepo;

import jakarta.transaction.Transactional;

@Service
public class CommonService {

    @Autowired
    private CustomerRepo custRepo;

    @Autowired
    private TransRepo transRepo;

    @Autowired
    protected BaseMapper<Customer, CustomerModel> custMapper;

    @Autowired
    protected BaseMapper<Trans, TransModel> transMapper;

    public CustomerModel getCustomerById(Long id) {
        Optional<Customer> customer = custRepo.findById(id);

        if (customer.isPresent()) {
            return custMapper.mapEntityToModel(customer.get());
        }
        return null;
    }

    public List<CustomerModel> getAllCustomer() {
        Iterable<Customer> customers = custRepo.findAll();

        return custMapper.mapListToModel(StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList()));
    }

    public CustomerModel saveUpdateCustomer(CustomerModel customerModel) {
        if (customerModel.getId() == null) {
            Customer entity = custMapper.mapModelToEntity(customerModel);
            entity = custRepo.save(entity);
            return custMapper.mapEntityToModel(entity);
        } else {
            Optional<Customer> customer = custRepo.findById(customerModel.getId());

            if (customer.isPresent()) {
                custMapper.updateModelToEntity(customerModel, customer.get());
                return custMapper.mapEntityToModel(custRepo.save(customer.get()));
            }

            return null;
        }
    }

    @Transactional
    public Boolean delCustomer(Long id) {
        Optional<Customer> customer = custRepo.findById(id);

        if (customer.isPresent()) {
            custRepo.delete(customer.get());
            return true;
        }

        return false;
    }

    public TransModel getTransById(Long id) {
        Optional<Trans> trans = transRepo.findById(id);

        if (trans.isPresent()) {
            return transMapper.mapEntityToModel(trans.get());
        }

        return null;
    }

    public List<TransModel> getAllTrans() {
        Iterable<Trans> trans = transRepo.findAll();

        return transMapper.mapListToModel(StreamSupport.stream(trans.spliterator(), false)
                .collect(Collectors.toList()));
    }

    public TransModel saveUpdateTrans(TransModel transModel) {
        if (transModel.getId() == null) {
            Trans entity = transMapper.mapModelToEntity(transModel);
            entity = transRepo.save(entity);
            return transMapper.mapEntityToModel(entity);
        } else {
            Optional<Trans> trans = transRepo.findById(transModel.getId());

            if (trans.isPresent()) {
                transMapper.updateModelToEntity(transModel, trans.get());
                return transMapper.mapEntityToModel(transRepo.save(trans.get()));
            }

            return null;
        }
    }

    @Transactional
    public Boolean delTrans(Long id) {
        Optional<Trans> trans = transRepo.findById(id);

        if (trans.isPresent()) {
            transRepo.delete(trans.get());
            return true;
        }

        return false;
    }

}
