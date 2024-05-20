package com.example.apidemo.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return this.customerRepository.getReferenceById(id);
    }

    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer updateCustomer(long id, Customer customer) {
        Optional<Customer> customerOptional = this.customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            Customer customerToUpdate = customerOptional.get();
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setAge(customer.getAge());
            return this.customerRepository.save(customer);
        }else{
           throw new RuntimeException("Customer not found");
        }
    }

    public void deleteCustomer(long id) {
        this.customerRepository.deleteById(id);
    }
}
