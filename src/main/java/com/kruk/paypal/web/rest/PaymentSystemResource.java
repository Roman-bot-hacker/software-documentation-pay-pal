package com.kruk.paypal.web.rest;

import com.kruk.paypal.domain.PaymentSystem;
import com.kruk.paypal.service.PaymentSystemService;
import com.kruk.paypal.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.kruk.paypal.domain.PaymentSystem}.
 */
@RestController
@RequestMapping("/api")
public class PaymentSystemResource {

    private final Logger log = LoggerFactory.getLogger(PaymentSystemResource.class);

    private static final String ENTITY_NAME = "paymentSystem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaymentSystemService paymentSystemService;

    public PaymentSystemResource(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    /**
     * {@code POST  /payment-systems} : Create a new paymentSystem.
     *
     * @param paymentSystem the paymentSystem to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paymentSystem, or with status {@code 400 (Bad Request)} if the paymentSystem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/payment-systems")
    public ResponseEntity<PaymentSystem> createPaymentSystem(@Valid @RequestBody PaymentSystem paymentSystem) throws URISyntaxException {
        log.debug("REST request to save PaymentSystem : {}", paymentSystem);
        if (paymentSystem.getId() != null) {
            throw new BadRequestAlertException("A new paymentSystem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PaymentSystem result = paymentSystemService.save(paymentSystem);
        return ResponseEntity.created(new URI("/api/payment-systems/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /payment-systems} : Updates an existing paymentSystem.
     *
     * @param paymentSystem the paymentSystem to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paymentSystem,
     * or with status {@code 400 (Bad Request)} if the paymentSystem is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paymentSystem couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/payment-systems")
    public ResponseEntity<PaymentSystem> updatePaymentSystem(@Valid @RequestBody PaymentSystem paymentSystem) throws URISyntaxException {
        log.debug("REST request to update PaymentSystem : {}", paymentSystem);
        if (paymentSystem.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PaymentSystem result = paymentSystemService.save(paymentSystem);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, paymentSystem.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /payment-systems} : get all the paymentSystems.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentSystems in body.
     */
    @GetMapping("/payment-systems")
    public List<PaymentSystem> getAllPaymentSystems() {
        log.debug("REST request to get all PaymentSystems");
        return paymentSystemService.findAll();
    }

    /**
     * {@code GET  /payment-systems/:id} : get the "id" paymentSystem.
     *
     * @param id the id of the paymentSystem to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentSystem, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/payment-systems/{id}")
    public ResponseEntity<PaymentSystem> getPaymentSystem(@PathVariable Long id) {
        log.debug("REST request to get PaymentSystem : {}", id);
        Optional<PaymentSystem> paymentSystem = paymentSystemService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentSystem);
    }

    /**
     * {@code DELETE  /payment-systems/:id} : delete the "id" paymentSystem.
     *
     * @param id the id of the paymentSystem to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/payment-systems/{id}")
    public ResponseEntity<Void> deletePaymentSystem(@PathVariable Long id) {
        log.debug("REST request to delete PaymentSystem : {}", id);
        paymentSystemService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
