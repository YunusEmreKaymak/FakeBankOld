package com.yunus.fakebank.customer;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="customer")
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
    private Long ssn;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String name_surname;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private int salary;
}
