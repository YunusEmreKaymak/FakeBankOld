package com.yunus.fakebank.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
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
//        int ssn, String email, String nameSurname, String password, String phone
//        Customer customer=new Customer(ssn,email,nameSurname,password,phone);
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
