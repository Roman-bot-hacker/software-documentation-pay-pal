package com.kruk.paypal.service;

import com.kruk.paypal.domain.PaymentAccount;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link PaymentAccount}.
 */
public interface PaymentAccountService {

    /**
     * Save a paymentAccount.
     *
     * @param paymentAccount the entity to save.
     * @return the persisted entity.
     */
    PaymentAccount save(PaymentAccount paymentAccount);

    /**
     * Get all the paymentAccounts.
     *
     * @return the list of entities.
     */
    List<PaymentAccount> findAll();

    /**
     * Get the "id" paymentAccount.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentAccount> findOne(Long id);

    /**
     * Delete the "id" paymentAccount.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
