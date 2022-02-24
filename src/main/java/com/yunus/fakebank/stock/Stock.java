package com.yunus.fakebank.stock;

import com.yunus.fakebank.account.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "value")
    private int value;
    @Column(name = "stock_name")
    private String stockName;

    @ManyToOne
    private Account account;
}
