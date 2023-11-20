package xyz.bank.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name" , length = 50)
    @NonNull
    private String customerName;

    @Column(name = "email", unique = true)
    private String customerEmailId;

    @Column(name = "DOB")
    private String customerDOB;

    @Column(name = "phone_number")
    private Long customerPhoneNumber;

    @Column(name = "password")
    private String customerPassword;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private CustomerAddress customerAddress;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Account> accounts = new ArrayList<Account>();

}
