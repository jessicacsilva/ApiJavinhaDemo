package com.example.apidemo.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer newCustomer = this.customerService.createCustomer(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomerService() {
        return this.customerService.findAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getProductById(@PathVariable Long id) {
        Optional<Customer> customer = Optional.ofNullable(this.customerService.findCustomerById(id));
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateProduct(@PathVariable Long id, @RequestBody Customer product) {
        Customer updatedCustomer = this.customerService.updateCustomer(id, product);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
