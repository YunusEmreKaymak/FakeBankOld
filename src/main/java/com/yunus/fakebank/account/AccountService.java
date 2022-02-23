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

    public void updateAccount(Account account){
        if (accountRepository.existsById(account.getAccount_id())){
            Account account1 = accountRepository.findById(account.getAccount_id()).orElseThrow(() -> new IllegalStateException("ERROR: account cannot found on update"));
            if (account1.getAccount_id().equals(account.getAccount_id())){
                account1.setBalance(account.getBalance());
            }
        }
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
