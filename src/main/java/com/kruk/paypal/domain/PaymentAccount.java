package com.kruk.paypal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A PaymentAccount.
 */
@Entity
@Table(name = "payment_account")
public class PaymentAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "payment_account_id", nullable = false, unique = true)
    private Long paymentAccountId;

    @Column(name = "payment_account_balance")
    private Double paymentAccountBalance;

    @OneToMany(mappedBy = "paymentTransactionAddresser")
    private Set<PaymentTransaction> addresserTransactions = new HashSet<>();

    @OneToMany(mappedBy = "paymentTransactionAddressee")
    private Set<PaymentTransaction> addresseeTransactions = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("currencyPaymentAccounts")
    private Currency paymentAccountCurrency;

    @ManyToMany(mappedBy = "paymentAccounts")
    @JsonIgnore
    private Set<UserAccount> userAccounts = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentAccountId() {
        return paymentAccountId;
    }

    public PaymentAccount paymentAccountId(Long paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
        return this;
    }

    public void setPaymentAccountId(Long paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
    }

    public Double getPaymentAccountBalance() {
        return paymentAccountBalance;
    }

    public PaymentAccount paymentAccountBalance(Double paymentAccountBalance) {
        this.paymentAccountBalance = paymentAccountBalance;
        return this;
    }

    public void setPaymentAccountBalance(Double paymentAccountBalance) {
        this.paymentAccountBalance = paymentAccountBalance;
    }

    public Set<PaymentTransaction> getAddresserTransactions() {
        return addresserTransactions;
    }

    public PaymentAccount addresserTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.addresserTransactions = paymentTransactions;
        return this;
    }

    public PaymentAccount addAddresserTransactions(PaymentTransaction paymentTransaction) {
        this.addresserTransactions.add(paymentTransaction);
        paymentTransaction.setPaymentTransactionAddresser(this);
        return this;
    }

    public PaymentAccount removeAddresserTransactions(PaymentTransaction paymentTransaction) {
        this.addresserTransactions.remove(paymentTransaction);
        paymentTransaction.setPaymentTransactionAddresser(null);
        return this;
    }

    public void setAddresserTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.addresserTransactions = paymentTransactions;
    }

    public Set<PaymentTransaction> getAddresseeTransactions() {
        return addresseeTransactions;
    }

    public PaymentAccount addresseeTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.addresseeTransactions = paymentTransactions;
        return this;
    }

    public PaymentAccount addAddresseeTransactions(PaymentTransaction paymentTransaction) {
        this.addresseeTransactions.add(paymentTransaction);
        paymentTransaction.setPaymentTransactionAddressee(this);
        return this;
    }

    public PaymentAccount removeAddresseeTransactions(PaymentTransaction paymentTransaction) {
        this.addresseeTransactions.remove(paymentTransaction);
        paymentTransaction.setPaymentTransactionAddressee(null);
        return this;
    }

    public void setAddresseeTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.addresseeTransactions = paymentTransactions;
    }

    public Currency getPaymentAccountCurrency() {
        return paymentAccountCurrency;
    }

    public PaymentAccount paymentAccountCurrency(Currency currency) {
        this.paymentAccountCurrency = currency;
        return this;
    }

    public void setPaymentAccountCurrency(Currency currency) {
        this.paymentAccountCurrency = currency;
    }

    public Set<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public PaymentAccount userAccounts(Set<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
        return this;
    }

    public PaymentAccount addUserAccounts(UserAccount userAccount) {
        this.userAccounts.add(userAccount);
        userAccount.getPaymentAccounts().add(this);
        return this;
    }

    public PaymentAccount removeUserAccounts(UserAccount userAccount) {
        this.userAccounts.remove(userAccount);
        userAccount.getPaymentAccounts().remove(this);
        return this;
    }

    public void setUserAccounts(Set<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentAccount)) {
            return false;
        }
        return id != null && id.equals(((PaymentAccount) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
            "id=" + getId() +
            ", paymentAccountId=" + getPaymentAccountId() +
            ", paymentAccountBalance=" + getPaymentAccountBalance() +
            "}";
    }
}
