package com.kruk.paypal.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A PaymentSystem.
 */
@Entity
@Table(name = "payment_system")
public class PaymentSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "payment_system_id", nullable = false, unique = true)
    private Long paymentSystemId;

    @Size(max = 50)
    @Column(name = "payment_system_name", length = 50)
    private String paymentSystemName;

    @Size(max = 256)
    @Column(name = "payment_system_info", length = 256)
    private String paymentSystemInfo;

    @OneToMany(mappedBy = "creditCardPaymentSystem")
    private Set<CreditCard> creditCards = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentSystemId() {
        return paymentSystemId;
    }

    public PaymentSystem paymentSystemId(Long paymentSystemId) {
        this.paymentSystemId = paymentSystemId;
        return this;
    }

    public void setPaymentSystemId(Long paymentSystemId) {
        this.paymentSystemId = paymentSystemId;
    }

    public String getPaymentSystemName() {
        return paymentSystemName;
    }

    public PaymentSystem paymentSystemName(String paymentSystemName) {
        this.paymentSystemName = paymentSystemName;
        return this;
    }

    public void setPaymentSystemName(String paymentSystemName) {
        this.paymentSystemName = paymentSystemName;
    }

    public String getPaymentSystemInfo() {
        return paymentSystemInfo;
    }

    public PaymentSystem paymentSystemInfo(String paymentSystemInfo) {
        this.paymentSystemInfo = paymentSystemInfo;
        return this;
    }

    public void setPaymentSystemInfo(String paymentSystemInfo) {
        this.paymentSystemInfo = paymentSystemInfo;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public PaymentSystem creditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
        return this;
    }

    public PaymentSystem addCreditCards(CreditCard creditCard) {
        this.creditCards.add(creditCard);
        creditCard.setCreditCardPaymentSystem(this);
        return this;
    }

    public PaymentSystem removeCreditCards(CreditCard creditCard) {
        this.creditCards.remove(creditCard);
        creditCard.setCreditCardPaymentSystem(null);
        return this;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentSystem)) {
            return false;
        }
        return id != null && id.equals(((PaymentSystem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PaymentSystem{" +
            "id=" + getId() +
            ", paymentSystemId=" + getPaymentSystemId() +
            ", paymentSystemName='" + getPaymentSystemName() + "'" +
            ", paymentSystemInfo='" + getPaymentSystemInfo() + "'" +
            "}";
    }
}
