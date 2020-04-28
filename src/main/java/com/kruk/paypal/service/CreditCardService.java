package com.kruk.paypal.service;

import com.kruk.paypal.domain.CreditCard;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CreditCard}.
 */
public interface CreditCardService {

    /**
     * Save a creditCard.
     *
     * @param creditCard the entity to save.
     * @return the persisted entity.
     */
    CreditCard save(CreditCard creditCard);

    /**
     * Get all the creditCards.
     *
     * @return the list of entities.
     */
    List<CreditCard> findAll();

    /**
     * Get the "id" creditCard.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CreditCard> findOne(Long id);

    /**
     * Delete the "id" creditCard.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
