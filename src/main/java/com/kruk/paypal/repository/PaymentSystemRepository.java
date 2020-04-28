package com.kruk.paypal.repository;

import com.kruk.paypal.domain.PaymentSystem;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PaymentSystem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentSystemRepository extends JpaRepository<PaymentSystem, Long> {
}
