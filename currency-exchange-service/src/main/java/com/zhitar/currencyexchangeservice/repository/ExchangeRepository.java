package com.zhitar.currencyexchangeservice.repository;

import com.zhitar.currencyexchangeservice.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    @Query("select e from Exchange e where e.from = upper(?1) and e.to = upper(?2)")
    Optional<Exchange> findByFromEqualsAndToEquals(String from, String to);
}
