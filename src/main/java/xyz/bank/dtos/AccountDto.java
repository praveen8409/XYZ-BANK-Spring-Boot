package xyz.bank.dtos;

import lombok.*;
import xyz.bank.entities.Customer;
import xyz.bank.entities.CustomerAddress;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Long accountNumber;


    private String accountType;

    private float balance;
    private Date openDate;


    private CustomerDto customerDto;
    //

    private CustomerAddressDto customerAddressDto;
}
