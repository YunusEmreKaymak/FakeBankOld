package com.yunus.fakebank.customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(customer.getEmail());
        // Checking "customerByEmail" is null
        if (customerByEmail.isPresent()){
            throw new IllegalStateException("ERROR: this customer already exist");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(int ssn){
        if (customerRepository.existsById(ssn)){
            customerRepository.deleteById(ssn);
        }else {
            throw new IllegalStateException("customer with ssn:"+ssn+"not exist");
        }
    }
    @Transactional
    public void updateCustomer(int ssn,String nameSurname,String email){
        Customer customer=customerRepository.findById(ssn).orElseThrow(() ->new IllegalStateException("customer with ssn:"+ssn+"not exist"));

        if (nameSurname != null && nameSurname.length() > 0 && !Objects.equals(customer.getName_surname(),nameSurname)){
            customer.setName_surname(nameSurname);
        }
        if (email != null && nameSurname.length() > 0 && !Objects.equals(customer.getEmail(),email)){
            Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(email);
            if (customerByEmail.isPresent()){
                throw new IllegalStateException("Email: "+email+" is already taken");
            }
            customer.setEmail(email);
        }
    }



}
