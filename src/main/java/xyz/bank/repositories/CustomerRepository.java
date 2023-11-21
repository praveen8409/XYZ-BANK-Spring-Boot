package xyz.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.bank.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
