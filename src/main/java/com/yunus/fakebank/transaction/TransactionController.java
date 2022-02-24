package com.yunus.fakebank.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.getTransactions();
    }
    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
    }
    @DeleteMapping
    public void deleteTransaction(@RequestBody TransactionPKId transactionPKId){
        transactionService.deleteTransaction(transactionPKId);
    }

    // The transactions cannot be changeable

//    @PutMapping
//    public void updateTransaction(@RequestBody Transaction transaction){
//        transactionService.updateTransaction(transaction);
//    }

}
