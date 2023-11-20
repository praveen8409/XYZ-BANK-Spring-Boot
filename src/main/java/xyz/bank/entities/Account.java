package xyz.bank.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_number", length = 15)
    private Long accountNumber;

    @Column(name = "account_type")
    @NonNull
    private String accountType;

    private float balance;
    private Date openDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
//
    @OneToOne
    @JoinColumn(name = "address_id")
    private CustomerAddress customerAddress;
}
