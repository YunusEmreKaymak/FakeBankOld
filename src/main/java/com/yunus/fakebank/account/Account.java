package com.yunus.fakebank.account;

import com.yunus.fakebank.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName="account_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "account_sequence"
    )
    @Column(name = "account_id")
    private Long account_id;
    @Column(name = "ssn",updatable = false)
    private Long ssn;
    private String accountType;
    private String iban;
    private int balance;

    @ManyToOne
//    @JoinColumn(name = "ssn")
    private Customer customer;
}
