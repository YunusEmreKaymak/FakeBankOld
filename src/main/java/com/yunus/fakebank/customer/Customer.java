package com.yunus.fakebank.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yunus.fakebank.account.Account;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(
        name="customer",
        uniqueConstraints = {
                @UniqueConstraint(name = "customer_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "customer_phone_unique", columnNames = "phone")
        }
)
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName="customer_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "customer_sequence"
    )
    @Column(name = "ssn")
    private Long ssn;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(nullable = false)
    private String name_surname;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int salary;
    // Referenced means here
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ssn",referencedColumnName = "ssn")
    private List<Account> accounts=new ArrayList<>();
}
