package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long customerId);
    @Transactional // Execute this method in a transaction. In transaction if there is any failure and database
    // changes done before the failure will be rollbacked.
    @Modifying // This annotation tell Spring Data Framework that this method will make changes in the database
    void deleteByCustomerId(Long customerId);
}
