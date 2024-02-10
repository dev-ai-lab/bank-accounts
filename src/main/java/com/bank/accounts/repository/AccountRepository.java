package com.bank.accounts.repository;

import com.bank.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);

    @Query(value = "SELECT a.account_number FROM account a WHERE a.customer_id = (:customerId) FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
    Long getAccountNumberFromCustomerId(@Param("customerId") Long customerId);
    @Query(value = "SELECT a.accountNumber FROM Account a WHERE a.customerId = (:customerId)")
    List<Long> getAccountNumbersFromCustomerId(@Param("customerId") Long customerId);

}
