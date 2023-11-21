package xyz.bank.dtos;

import lombok.*;
import xyz.bank.entities.Customer;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerAddressDto {
    private String houseNo;


    private String address;


    private String city;


    private String state;


    private int pincode;


    private CustomerDto customerDto;
}
