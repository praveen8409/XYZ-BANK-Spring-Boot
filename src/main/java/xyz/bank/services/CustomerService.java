package xyz.bank.services;

import xyz.bank.dtos.CustomerAddressDto;
import xyz.bank.dtos.CustomerDto;
import xyz.bank.dtos.PageableResponse;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(int  customerId);

    CustomerDto updateCustomer(int customerId ,CustomerDto customerDto);

    PageableResponse<CustomerDto> getAllCustomer(int pageNumber, int pageSize, String sortBy, String sortDir);

    void deleteCustomer(int customerId);
}
