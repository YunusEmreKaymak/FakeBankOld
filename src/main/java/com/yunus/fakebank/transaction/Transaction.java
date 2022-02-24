package com.yunus.fakebank.transaction;

import com.yunus.fakebank.account.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@Data
@IdClass(TransactionPKId.class)
public class Transaction {
    @Id
    @Column(name = "given_id")
    private Long givenId;
    @Id
    @Column(name = "receiven_id")
    private Long receivenId;
    @Id
    @Column(name = "date_time")
    private String dateTime;
    @Column(name = "amount")
    private int amount;

    @ManyToOne
    private Account account;

}
