package com.yunus.fakebank.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    LoanService loanService;
    @GetMapping
    public List<Loan> getLoans(){
        return loanService.getLoans();
    }
    @PostMapping
    public void addLoan(@RequestBody Loan loan){
        loanService.addLoan(loan);
    }
    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable("id") Long id){
        loanService.deleteLoan(id);
    }
    @PutMapping("/{id}/{amount}")
    public void updateLoan(@PathVariable("id") Long id,@PathVariable("amount") int amount){
        loanService.updateLoan(id,amount);
    }




}
