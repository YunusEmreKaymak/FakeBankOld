package com.yunus.fakebank.account;

import com.yunus.fakebank.card.Card;
import com.yunus.fakebank.customer.Customer;
import com.yunus.fakebank.loan.Loan;
import com.yunus.fakebank.stock.Stock;
import com.yunus.fakebank.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    List<Loan> loans=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    List<Card> cards=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    List<Stock> stocks=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "given_id",referencedColumnName = "account_id")
    List<Transaction> transactions=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiven_id",referencedColumnName = "account_id")
    List<Transaction> transactions2= new ArrayList<>();
}
