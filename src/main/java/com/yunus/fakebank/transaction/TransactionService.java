package com.yunus.fakebank.transaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;
    }

    List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    void deleteTransaction(TransactionPKId transactionPKId){
        if (transactionRepository.existsById(transactionPKId)){
            transactionRepository.deleteById(transactionPKId);
        }else {
            throw new IllegalStateException("Transaction not found on delete");
        }
    }

    void updateTransaction(Transaction transaction){
        TransactionPKId transactionPKId = new TransactionPKId(transaction.getGivenId(), transaction.getReceivenId(), transaction.getDateTime());
        Transaction transactionUpdate = transactionRepository.findById(transactionPKId).orElseThrow(() -> new IllegalStateException("Transaction not found on update"));
        transactionUpdate.setAmount(transaction.getAmount());
        transactionRepository.save(transactionUpdate);
    }
}
