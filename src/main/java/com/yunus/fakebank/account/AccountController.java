package com.yunus.fakebank.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
    }
    @PostMapping
    public void addAccound(@RequestBody Account account){
        accountService.addAccount(account);
    }
    @PutMapping("/{id}/{balance}")
    public void updateAccount(@PathVariable("id") Long id, @PathVariable("balance") int balance){
        accountService.updateAccount(id, balance);
    }


}
