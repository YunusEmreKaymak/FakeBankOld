package com.yunus.fakebank.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
    @DeleteMapping("/{ssn}")
    public void deleteCustomer(@PathVariable("ssn") int ssn){
        customerService.deleteCustomer(ssn);
    }
    @PutMapping("/{ssn}/{nameSurname}/{email}")
    public void updateCustomer(@PathVariable("ssn") int ssn,@PathVariable("nameSurname") String nameSurname,@PathVariable("email") String email){
        customerService.updateCustomer(ssn, nameSurname, email);
    }

}
