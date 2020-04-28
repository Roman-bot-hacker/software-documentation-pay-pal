package com.kruk.paypal.service;

import com.kruk.paypal.domain.PaymentSystem;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link PaymentSystem}.
 */
public interface PaymentSystemService {

    /**
     * Save a paymentSystem.
     *
     * @param paymentSystem the entity to save.
     * @return the persisted entity.
     */
    PaymentSystem save(PaymentSystem paymentSystem);

    /**
     * Get all the paymentSystems.
     *
     * @return the list of entities.
     */
    List<PaymentSystem> findAll();

    /**
     * Get the "id" paymentSystem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentSystem> findOne(Long id);

    /**
     * Delete the "id" paymentSystem.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
