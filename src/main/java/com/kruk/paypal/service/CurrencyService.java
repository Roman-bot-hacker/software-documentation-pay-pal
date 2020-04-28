package com.kruk.paypal.service;

import com.kruk.paypal.domain.Currency;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Currency}.
 */
public interface CurrencyService {

    /**
     * Save a currency.
     *
     * @param currency the entity to save.
     * @return the persisted entity.
     */
    Currency save(Currency currency);

    /**
     * Get all the currencies.
     *
     * @return the list of entities.
     */
    List<Currency> findAll();

    /**
     * Get the "id" currency.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Currency> findOne(Long id);

    /**
     * Delete the "id" currency.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
