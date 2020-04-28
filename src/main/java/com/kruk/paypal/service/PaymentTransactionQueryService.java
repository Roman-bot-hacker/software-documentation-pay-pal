package com.kruk.paypal.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.kruk.paypal.domain.PaymentTransaction;
import com.kruk.paypal.domain.*; // for static metamodels
import com.kruk.paypal.repository.PaymentTransactionRepository;
import com.kruk.paypal.service.dto.PaymentTransactionCriteria;

/**
 * Service for executing complex queries for {@link PaymentTransaction} entities in the database.
 * The main input is a {@link PaymentTransactionCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PaymentTransaction} or a {@link Page} of {@link PaymentTransaction} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PaymentTransactionQueryService extends QueryService<PaymentTransaction> {

    private final Logger log = LoggerFactory.getLogger(PaymentTransactionQueryService.class);

    private final PaymentTransactionRepository paymentTransactionRepository;

    public PaymentTransactionQueryService(PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    /**
     * Return a {@link List} of {@link PaymentTransaction} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PaymentTransaction> findByCriteria(PaymentTransactionCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<PaymentTransaction> specification = createSpecification(criteria);
        return paymentTransactionRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link PaymentTransaction} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PaymentTransaction> findByCriteria(PaymentTransactionCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<PaymentTransaction> specification = createSpecification(criteria);
        return paymentTransactionRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PaymentTransactionCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<PaymentTransaction> specification = createSpecification(criteria);
        return paymentTransactionRepository.count(specification);
    }

    /**
     * Function to convert {@link PaymentTransactionCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PaymentTransaction> createSpecification(PaymentTransactionCriteria criteria) {
        Specification<PaymentTransaction> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), PaymentTransaction_.id));
            }
            if (criteria.getPaymentTransactionId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPaymentTransactionId(), PaymentTransaction_.paymentTransactionId));
            }
            if (criteria.getPaymentTransactionDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPaymentTransactionDate(), PaymentTransaction_.paymentTransactionDate));
            }
            if (criteria.getPaymentTransactionStartTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPaymentTransactionStartTime(), PaymentTransaction_.paymentTransactionStartTime));
            }
            if (criteria.getPaymentTransactionEndTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPaymentTransactionEndTime(), PaymentTransaction_.paymentTransactionEndTime));
            }
            if (criteria.getPaymentTransactionValue() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPaymentTransactionValue(), PaymentTransaction_.paymentTransactionValue));
            }
            if (criteria.getPaymentTransactionDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPaymentTransactionDescription(), PaymentTransaction_.paymentTransactionDescription));
            }
            if (criteria.getPaymentTransactionStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getPaymentTransactionStatus(), PaymentTransaction_.paymentTransactionStatus));
            }
            if (criteria.getPaymentTransactionInitiatorId() != null) {
                specification = specification.and(buildSpecification(criteria.getPaymentTransactionInitiatorId(),
                    root -> root.join(PaymentTransaction_.paymentTransactionInitiator, JoinType.LEFT).get(UserAccount_.id)));
            }
            if (criteria.getPaymentTransactionAddresserId() != null) {
                specification = specification.and(buildSpecification(criteria.getPaymentTransactionAddresserId(),
                    root -> root.join(PaymentTransaction_.paymentTransactionAddresser, JoinType.LEFT).get(PaymentAccount_.id)));
            }
            if (criteria.getPaymentTransactionAddresseeId() != null) {
                specification = specification.and(buildSpecification(criteria.getPaymentTransactionAddresseeId(),
                    root -> root.join(PaymentTransaction_.paymentTransactionAddressee, JoinType.LEFT).get(PaymentAccount_.id)));
            }
        }
        return specification;
    }
}
