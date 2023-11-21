package xyz.bank.services;

import xyz.bank.dtos.CustomerAddressDto;
import xyz.bank.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(int  customerId);

    CustomerDto updateCustomer(int customerId ,CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    void deleteCustomer(int customerId);
}
