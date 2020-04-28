package com.kruk.paypal.repository;

import com.kruk.paypal.domain.PaymentAccount;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PaymentAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Long> {
}
