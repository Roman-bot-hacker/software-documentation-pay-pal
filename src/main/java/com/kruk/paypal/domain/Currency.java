package com.kruk.paypal.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Currency.
 */
@Entity
@Table(name = "currency")
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "currency_id", nullable = false, unique = true)
    private Long currencyId;

    @Size(max = 50)
    @Column(name = "currency_name", length = 50)
    private String currencyName;

    @Size(max = 3)
    @Column(name = "currency_abreviation", length = 3)
    private String currencyAbreviation;

    @OneToMany(mappedBy = "paymentAccountCurrency")
    private Set<PaymentAccount> currencyPaymentAccounts = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public Currency currencyId(Long currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Currency currencyName(String currencyName) {
        this.currencyName = currencyName;
        return this;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyAbreviation() {
        return currencyAbreviation;
    }

    public Currency currencyAbreviation(String currencyAbreviation) {
        this.currencyAbreviation = currencyAbreviation;
        return this;
    }

    public void setCurrencyAbreviation(String currencyAbreviation) {
        this.currencyAbreviation = currencyAbreviation;
    }

    public Set<PaymentAccount> getCurrencyPaymentAccounts() {
        return currencyPaymentAccounts;
    }

    public Currency currencyPaymentAccounts(Set<PaymentAccount> paymentAccounts) {
        this.currencyPaymentAccounts = paymentAccounts;
        return this;
    }

    public Currency addCurrencyPaymentAccounts(PaymentAccount paymentAccount) {
        this.currencyPaymentAccounts.add(paymentAccount);
        paymentAccount.setPaymentAccountCurrency(this);
        return this;
    }

    public Currency removeCurrencyPaymentAccounts(PaymentAccount paymentAccount) {
        this.currencyPaymentAccounts.remove(paymentAccount);
        paymentAccount.setPaymentAccountCurrency(null);
        return this;
    }

    public void setCurrencyPaymentAccounts(Set<PaymentAccount> paymentAccounts) {
        this.currencyPaymentAccounts = paymentAccounts;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Currency)) {
            return false;
        }
        return id != null && id.equals(((Currency) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Currency{" +
            "id=" + getId() +
            ", currencyId=" + getCurrencyId() +
            ", currencyName='" + getCurrencyName() + "'" +
            ", currencyAbreviation='" + getCurrencyAbreviation() + "'" +
            "}";
    }
}
