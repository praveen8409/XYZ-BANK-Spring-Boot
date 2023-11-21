package xyz.bank.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.bank.dtos.CustomerAddressDto;
import xyz.bank.dtos.CustomerDto;
import xyz.bank.entities.Customer;
import xyz.bank.exceptions.ResourceNotFoundException;
import xyz.bank.repositories.CustomerRepository;
import xyz.bank.services.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        customerDto.setCustomerPassword(passwordEncoder.encode(customerDto.getCustomerPassword()));
        Customer customer = mapper.map(customerDto, Customer.class);
        Customer saved = customerRepository.save(customer);
        return mapper.map(saved, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found with : "+customerId));
        return mapper.map(customer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer( int customerId ,CustomerDto customerDto) {
        Customer customer1 = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found with : "+customerId));
        CustomerDto customerDto1 = CustomerDto.builder()
                .customerId(customerId)
                .customerName(customerDto.getCustomerName())
                .customerEmailId(customerDto.getCustomerEmailId())
                .customerDOB(customerDto.getCustomerDOB())
                .customerAddressDto(customerDto.getCustomerAddressDto())
                .customerPhoneNumber(customerDto.getCustomerPhoneNumber())
                .accounts(customerDto.getAccounts())
                .build();
        if(!customer1.getCustomerPassword().equalsIgnoreCase(customerDto.getCustomerPassword())){
            customerDto1.setCustomerPassword(passwordEncoder.encode(customerDto.getCustomerPassword()));
        }
        Customer customer = mapper.map(customerDto1, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return mapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = customerList.stream().map(customer -> mapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return customerDtoList;
    }

    @Override
    public void deleteCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found with : "+customerId));
        customerRepository.delete(customer);
    }
}
