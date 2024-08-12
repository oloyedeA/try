package org.example.finalexam.repository;

import org.example.finalexam.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;




@Repository
public class Repo {
    private List<Customer> list1 = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    // Constructor to initialize with some data
    public Repo() {
        // Initialize with sample data
        Customer cc = new Customer();
        cc.setId(idCounter.getAndIncrement());
        cc.setIdepo(0.0);
        cc.setCname("");
        cc.setNoy(0);
        cc.setNumber("");
        cc.setTos("");


        list1.add(cc);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(list1);
    }

    public Customer findById(int id) {
        return list1.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void addCustomer(Customer customer) {
        customer.setId(idCounter.getAndIncrement());
        list1.add(customer);
    }

    public void updateCustomer(Customer customer) {
        Customer existingCustomer = findById(customer.getId());
        if (existingCustomer != null) {
            existingCustomer.setNumber(customer.getNumber());
            existingCustomer.setCname(customer.getCname());
            existingCustomer.setNoy(customer.getNoy());
            existingCustomer.setIdepo(customer.getIdepo());
            existingCustomer.setTos(customer.getTos());


        }

    }

    public void deleteCustomer(int id) {
        list1.removeIf(c -> c.getId() == id);

    }
}
