package com.yunus.fakebank.loan;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LoanService {
    LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository){
        this.loanRepository=loanRepository;
    }

    List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    void deleteLoan(Long loanId){
        loanRepository.deleteById(loanId);
    }

    void updateLoan(Long id,int amount){
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new IllegalStateException("Loan not found"));
        loan.setAmount(amount);
        loanRepository.save(loan);
    }

    void addLoan(Loan loan){
        if (loanRepository.existsById(loan.getLoanId())){
            throw new IllegalStateException("Loan not found with that id");
        }else {
            loanRepository.save(loan);
        }
    }
}
