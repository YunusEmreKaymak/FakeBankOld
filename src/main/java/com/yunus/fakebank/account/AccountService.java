package com.yunus.fakebank.account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    public AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public void addAccount(Account account){
        Optional<Account> accountByIban = accountRepository.findAccountByIban(account.getIban());
        if (accountByIban.isPresent()){
            throw new IllegalStateException("account already added on that iban");

        }else {
            accountRepository.save(account);
        }

    }

    public void updateAccount(Long id, int balance){
        Account account1 = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException("ERROR: account cannot found on update"));
        account1.setBalance(balance);
        accountRepository.save(account1);
    }

    public void deleteAccount(Long account_id){
        if (accountRepository.existsById(account_id)){
            accountRepository.deleteById(account_id);
        }else {
            throw new IllegalStateException("ERROR: account not found on delete");
        }
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }
}
