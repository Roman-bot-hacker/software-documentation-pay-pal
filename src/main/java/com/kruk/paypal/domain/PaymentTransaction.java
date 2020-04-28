package com.kruk.paypal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

import com.kruk.paypal.domain.enumeration.PaymentStatus;

/**
 * A PaymentTransaction.
 */
@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "payment_transaction_id", nullable = false, unique = true)
    private Long paymentTransactionId;

    @Column(name = "payment_transaction_date")
    private LocalDate paymentTransactionDate;

    @Column(name = "payment_transaction_start_time")
    private LocalDate paymentTransactionStartTime;

    @Column(name = "payment_transaction_end_time")
    private LocalDate paymentTransactionEndTime;

    @Column(name = "payment_transaction_value")
    private Double paymentTransactionValue;

    @Size(max = 256)
    @Column(name = "payment_transaction_description", length = 256)
    private String paymentTransactionDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_transaction_status")
    private PaymentStatus paymentTransactionStatus;

    @ManyToOne
    @JsonIgnoreProperties("userTransactions")
    private UserAccount paymentTransactionInitiator;

    @ManyToOne
    @JsonIgnoreProperties("addresserTransactions")
    private PaymentAccount paymentTransactionAddresser;

    @ManyToOne
    @JsonIgnoreProperties("addresseeTransactions")
    private PaymentAccount paymentTransactionAddressee;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public PaymentTransaction paymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
        return this;
    }

    public void setPaymentTransactionId(Long paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public LocalDate getPaymentTransactionDate() {
        return paymentTransactionDate;
    }

    public PaymentTransaction paymentTransactionDate(LocalDate paymentTransactionDate) {
        this.paymentTransactionDate = paymentTransactionDate;
        return this;
    }

    public void setPaymentTransactionDate(LocalDate paymentTransactionDate) {
        this.paymentTransactionDate = paymentTransactionDate;
    }

    public LocalDate getPaymentTransactionStartTime() {
        return paymentTransactionStartTime;
    }

    public PaymentTransaction paymentTransactionStartTime(LocalDate paymentTransactionStartTime) {
        this.paymentTransactionStartTime = paymentTransactionStartTime;
        return this;
    }

    public void setPaymentTransactionStartTime(LocalDate paymentTransactionStartTime) {
        this.paymentTransactionStartTime = paymentTransactionStartTime;
    }

    public LocalDate getPaymentTransactionEndTime() {
        return paymentTransactionEndTime;
    }

    public PaymentTransaction paymentTransactionEndTime(LocalDate paymentTransactionEndTime) {
        this.paymentTransactionEndTime = paymentTransactionEndTime;
        return this;
    }

    public void setPaymentTransactionEndTime(LocalDate paymentTransactionEndTime) {
        this.paymentTransactionEndTime = paymentTransactionEndTime;
    }

    public Double getPaymentTransactionValue() {
        return paymentTransactionValue;
    }

    public PaymentTransaction paymentTransactionValue(Double paymentTransactionValue) {
        this.paymentTransactionValue = paymentTransactionValue;
        return this;
    }

    public void setPaymentTransactionValue(Double paymentTransactionValue) {
        this.paymentTransactionValue = paymentTransactionValue;
    }

    public String getPaymentTransactionDescription() {
        return paymentTransactionDescription;
    }

    public PaymentTransaction paymentTransactionDescription(String paymentTransactionDescription) {
        this.paymentTransactionDescription = paymentTransactionDescription;
        return this;
    }

    public void setPaymentTransactionDescription(String paymentTransactionDescription) {
        this.paymentTransactionDescription = paymentTransactionDescription;
    }

    public PaymentStatus getPaymentTransactionStatus() {
        return paymentTransactionStatus;
    }

    public PaymentTransaction paymentTransactionStatus(PaymentStatus paymentTransactionStatus) {
        this.paymentTransactionStatus = paymentTransactionStatus;
        return this;
    }

    public void setPaymentTransactionStatus(PaymentStatus paymentTransactionStatus) {
        this.paymentTransactionStatus = paymentTransactionStatus;
    }

    public UserAccount getPaymentTransactionInitiator() {
        return paymentTransactionInitiator;
    }

    public PaymentTransaction paymentTransactionInitiator(UserAccount userAccount) {
        this.paymentTransactionInitiator = userAccount;
        return this;
    }

    public void setPaymentTransactionInitiator(UserAccount userAccount) {
        this.paymentTransactionInitiator = userAccount;
    }

    public PaymentAccount getPaymentTransactionAddresser() {
        return paymentTransactionAddresser;
    }

    public PaymentTransaction paymentTransactionAddresser(PaymentAccount paymentAccount) {
        this.paymentTransactionAddresser = paymentAccount;
        return this;
    }

    public void setPaymentTransactionAddresser(PaymentAccount paymentAccount) {
        this.paymentTransactionAddresser = paymentAccount;
    }

    public PaymentAccount getPaymentTransactionAddressee() {
        return paymentTransactionAddressee;
    }

    public PaymentTransaction paymentTransactionAddressee(PaymentAccount paymentAccount) {
        this.paymentTransactionAddressee = paymentAccount;
        return this;
    }

    public void setPaymentTransactionAddressee(PaymentAccount paymentAccount) {
        this.paymentTransactionAddressee = paymentAccount;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentTransaction)) {
            return false;
        }
        return id != null && id.equals(((PaymentTransaction) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
            "id=" + getId() +
            ", paymentTransactionId=" + getPaymentTransactionId() +
            ", paymentTransactionDate='" + getPaymentTransactionDate() + "'" +
            ", paymentTransactionStartTime='" + getPaymentTransactionStartTime() + "'" +
            ", paymentTransactionEndTime='" + getPaymentTransactionEndTime() + "'" +
            ", paymentTransactionValue=" + getPaymentTransactionValue() +
            ", paymentTransactionDescription='" + getPaymentTransactionDescription() + "'" +
            ", paymentTransactionStatus='" + getPaymentTransactionStatus() + "'" +
            "}";
    }
}
