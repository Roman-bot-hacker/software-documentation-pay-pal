package com.kruk.paypal.web.rest;

import com.kruk.paypal.domain.PaymentTransaction;
import com.kruk.paypal.service.PaymentTransactionService;
import com.kruk.paypal.web.rest.errors.BadRequestAlertException;
import com.kruk.paypal.service.dto.PaymentTransactionCriteria;
import com.kruk.paypal.service.PaymentTransactionQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.kruk.paypal.domain.PaymentTransaction}.
 */
@RestController
@RequestMapping("/api")
public class PaymentTransactionResource {

    private final Logger log = LoggerFactory.getLogger(PaymentTransactionResource.class);

    private static final String ENTITY_NAME = "paymentTransaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaymentTransactionService paymentTransactionService;

    private final PaymentTransactionQueryService paymentTransactionQueryService;

    public PaymentTransactionResource(PaymentTransactionService paymentTransactionService, PaymentTransactionQueryService paymentTransactionQueryService) {
        this.paymentTransactionService = paymentTransactionService;
        this.paymentTransactionQueryService = paymentTransactionQueryService;
    }

    /**
     * {@code POST  /payment-transactions} : Create a new paymentTransaction.
     *
     * @param paymentTransaction the paymentTransaction to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paymentTransaction, or with status {@code 400 (Bad Request)} if the paymentTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/payment-transactions")
    public ResponseEntity<PaymentTransaction> createPaymentTransaction(@Valid @RequestBody PaymentTransaction paymentTransaction) throws URISyntaxException {
        log.debug("REST request to save PaymentTransaction : {}", paymentTransaction);
        if (paymentTransaction.getId() != null) {
            throw new BadRequestAlertException("A new paymentTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PaymentTransaction result = paymentTransactionService.save(paymentTransaction);
        return ResponseEntity.created(new URI("/api/payment-transactions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /payment-transactions} : Updates an existing paymentTransaction.
     *
     * @param paymentTransaction the paymentTransaction to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paymentTransaction,
     * or with status {@code 400 (Bad Request)} if the paymentTransaction is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paymentTransaction couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/payment-transactions")
    public ResponseEntity<PaymentTransaction> updatePaymentTransaction(@Valid @RequestBody PaymentTransaction paymentTransaction) throws URISyntaxException {
        log.debug("REST request to update PaymentTransaction : {}", paymentTransaction);
        if (paymentTransaction.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PaymentTransaction result = paymentTransactionService.save(paymentTransaction);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, paymentTransaction.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /payment-transactions} : get all the paymentTransactions.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTransactions in body.
     */
    @GetMapping("/payment-transactions")
    public ResponseEntity<List<PaymentTransaction>> getAllPaymentTransactions(PaymentTransactionCriteria criteria, Pageable pageable) {
        log.debug("REST request to get PaymentTransactions by criteria: {}", criteria);
        Page<PaymentTransaction> page = paymentTransactionQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-transactions/count} : count all the paymentTransactions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/payment-transactions/count")
    public ResponseEntity<Long> countPaymentTransactions(PaymentTransactionCriteria criteria) {
        log.debug("REST request to count PaymentTransactions by criteria: {}", criteria);
        return ResponseEntity.ok().body(paymentTransactionQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /payment-transactions/:id} : get the "id" paymentTransaction.
     *
     * @param id the id of the paymentTransaction to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTransaction, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/payment-transactions/{id}")
    public ResponseEntity<PaymentTransaction> getPaymentTransaction(@PathVariable Long id) {
        log.debug("REST request to get PaymentTransaction : {}", id);
        Optional<PaymentTransaction> paymentTransaction = paymentTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTransaction);
    }

    /**
     * {@code DELETE  /payment-transactions/:id} : delete the "id" paymentTransaction.
     *
     * @param id the id of the paymentTransaction to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/payment-transactions/{id}")
    public ResponseEntity<Void> deletePaymentTransaction(@PathVariable Long id) {
        log.debug("REST request to delete PaymentTransaction : {}", id);
        paymentTransactionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
