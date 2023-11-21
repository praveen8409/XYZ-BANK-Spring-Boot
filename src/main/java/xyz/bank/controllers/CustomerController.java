package xyz.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.bank.dtos.ApiResponseMessage;
import xyz.bank.dtos.CustomerDto;
import xyz.bank.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public  ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") int customerId){
        CustomerDto customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }


    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody CustomerDto customerDto){
        CustomerDto customerDto1 = customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(customerDto1, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponseMessage> deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        ApiResponseMessage message
                = ApiResponseMessage
                .builder()
                .message("User is deleted Successfully !!")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
