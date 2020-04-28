package com.kruk.paypal.service;

import com.kruk.paypal.domain.PaymentTransaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link PaymentTransaction}.
 */
public interface PaymentTransactionService {

    /**
     * Save a paymentTransaction.
     *
     * @param paymentTransaction the entity to save.
     * @return the persisted entity.
     */
    PaymentTransaction save(PaymentTransaction paymentTransaction);

    /**
     * Get all the paymentTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaymentTransaction> findAll(Pageable pageable);

    /**
     * Get the "id" paymentTransaction.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTransaction> findOne(Long id);

    /**
     * Delete the "id" paymentTransaction.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
