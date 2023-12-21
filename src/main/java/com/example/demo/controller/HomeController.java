package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CustomerModel;
import com.example.demo.model.TransModel;
import com.example.demo.service.CommonService;

@Controller
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private CommonService service;

    @GetMapping("/customer")
    public ResponseEntity<Object> getCustomer(@RequestParam Long id) {
        CustomerModel result = service.getCustomerById(id);

        return new ResponseEntity<>(result == null ? "Customer not found" : result,
                HttpStatus.OK);
    }

    @GetMapping("/all/customer")
    public ResponseEntity<Object> getAllCustomer() {

        return new ResponseEntity<>(service.getAllCustomer(),
                HttpStatus.OK);
    }

    @PostMapping("/save/customer")
    public ResponseEntity<Object> saveUpdateCustomer(@RequestBody CustomerModel customerModel) {
        CustomerModel result = service.saveUpdateCustomer(customerModel);

        return new ResponseEntity<>(result != null ? "Customer saved successfully" : "Failed to save customer",
                HttpStatus.OK);
    }

    @GetMapping("/delete/customer")
    public ResponseEntity<Object> deleteCustomer(@RequestParam Long id) {
        Boolean result = service.delCustomer(id);

        return new ResponseEntity<>(
                Boolean.TRUE.equals(result) ? "Customer deleted successfully" : "Failed to delete customer",
                HttpStatus.OK);
    }

    @GetMapping("/trans")
    public ResponseEntity<Object> getTrans(@RequestParam Long id) {
        TransModel result = service.getTransById(id);

        return new ResponseEntity<>(result == null ? "Transaction not found" : result,
                HttpStatus.OK);
    }

    @GetMapping("/all/trans")
    public ResponseEntity<Object> getAllTrans() {

        return new ResponseEntity<>(service.getAllTrans(),
                HttpStatus.OK);
    }

    @PostMapping("/save/trans")
    public ResponseEntity<Object> saveUpdateTrans(@RequestBody TransModel transModel) {

        try {
            TransModel result = service.saveUpdateTrans(transModel);
            return new ResponseEntity<>(
                    result != null ? "Transaction saved successfully" : "Failed to save transaction",
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to save transaction or customer does not exist",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/delete/trans")
    public ResponseEntity<Object> deleteTrans(@RequestParam Long id) {
        Boolean result = service.delTrans(id);

        return new ResponseEntity<>(
                Boolean.TRUE.equals(result) ? "Transaction deleted successfully" : "Failed to delete transaction",
                HttpStatus.OK);
    }
}
