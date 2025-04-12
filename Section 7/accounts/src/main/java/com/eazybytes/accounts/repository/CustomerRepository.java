package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/*
    This annotation allows Spring Data JPA framework to create a bean implementation of the CustomerRepository interface
    based on the configuration that is provided.
    Right now it is empty and thus does not create a bean.
    public interface CustomerRepository extends JpaRepository<Customer, Long> {
    }
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
