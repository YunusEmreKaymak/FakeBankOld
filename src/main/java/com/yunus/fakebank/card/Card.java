package com.yunus.fakebank.card;

import com.yunus.fakebank.account.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNumber;
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "password")
    private String password;
    @Column(name = "card_type")
    private String cardType;

    @ManyToOne
    private Account account;
}
