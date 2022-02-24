package com.yunus.fakebank.loan;

import com.yunus.fakebank.account.Account;
import com.yunus.fakebank.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "amount")
    private int amount;

    @ManyToOne
    private Account account;
}
