package com.jfb.jsonconsumer.repository;

import com.jfb.jsonconsumer.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonConsumerRepository extends JpaRepository<Payment, Long> {
}
