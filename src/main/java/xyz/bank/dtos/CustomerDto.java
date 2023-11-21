package xyz.bank.dtos;

import lombok.*;
import xyz.bank.entities.Account;
import xyz.bank.entities.CustomerAddress;


import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {

    private int customerId;

    private String customerName;


    private String customerEmailId;


    private String customerDOB;


    private String customerPhoneNumber;


    private String customerPassword;


    private CustomerAddressDto customerAddressDto;


    private List<AccountDto> accounts = new ArrayList<AccountDto>();
}
