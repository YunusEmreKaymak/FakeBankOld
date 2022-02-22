package com.yunus.fakebank.customer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {
    @Id
    private int ssn;
    private String email;
    private String name_surname;
    private String password;
    private String phone;
}
