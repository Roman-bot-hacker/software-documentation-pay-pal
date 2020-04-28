package com.kruk.paypal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 * A CreditCard.
 */
@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "credit_card_id", nullable = false, unique = true)
    private Long creditCardId;

    @Size(max = 16)
    @Column(name = "credit_card_number", length = 16)
    private String creditCardNumber;

    @Column(name = "credit_card_expiration_date")
    private LocalDate creditCardExpirationDate;

    @Size(max = 3)
    @Column(name = "credit_card_security_code", length = 3)
    private String creditCardSecurityCode;

    @ManyToOne
    @JsonIgnoreProperties("creditCards")
    private PaymentSystem creditCardPaymentSystem;

    @ManyToOne
    @JsonIgnoreProperties("bankCreditCards")
    private Bank creditCardBank;

    @ManyToOne
    @JsonIgnoreProperties("userAccountCreditCards")
    private UserAccount userCreditCard;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public CreditCard creditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
        return this;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public CreditCard creditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public LocalDate getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public CreditCard creditCardExpirationDate(LocalDate creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
        return this;
    }

    public void setCreditCardExpirationDate(LocalDate creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public String getCreditCardSecurityCode() {
        return creditCardSecurityCode;
    }

    public CreditCard creditCardSecurityCode(String creditCardSecurityCode) {
        this.creditCardSecurityCode = creditCardSecurityCode;
        return this;
    }

    public void setCreditCardSecurityCode(String creditCardSecurityCode) {
        this.creditCardSecurityCode = creditCardSecurityCode;
    }

    public PaymentSystem getCreditCardPaymentSystem() {
        return creditCardPaymentSystem;
    }

    public CreditCard creditCardPaymentSystem(PaymentSystem paymentSystem) {
        this.creditCardPaymentSystem = paymentSystem;
        return this;
    }

    public void setCreditCardPaymentSystem(PaymentSystem paymentSystem) {
        this.creditCardPaymentSystem = paymentSystem;
    }

    public Bank getCreditCardBank() {
        return creditCardBank;
    }

    public CreditCard creditCardBank(Bank bank) {
        this.creditCardBank = bank;
        return this;
    }

    public void setCreditCardBank(Bank bank) {
        this.creditCardBank = bank;
    }

    public UserAccount getUserCreditCard() {
        return userCreditCard;
    }

    public CreditCard userCreditCard(UserAccount userAccount) {
        this.userCreditCard = userAccount;
        return this;
    }

    public void setUserCreditCard(UserAccount userAccount) {
        this.userCreditCard = userAccount;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CreditCard)) {
            return false;
        }
        return id != null && id.equals(((CreditCard) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
            "id=" + getId() +
            ", creditCardId=" + getCreditCardId() +
            ", creditCardNumber='" + getCreditCardNumber() + "'" +
            ", creditCardExpirationDate='" + getCreditCardExpirationDate() + "'" +
            ", creditCardSecurityCode='" + getCreditCardSecurityCode() + "'" +
            "}";
    }
}
