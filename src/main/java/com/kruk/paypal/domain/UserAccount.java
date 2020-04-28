package com.kruk.paypal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A UserAccount.
 */
@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_account_id", nullable = false, unique = true)
    private Long userAccountId;

    @Size(max = 50)
    @Column(name = "user_email", length = 50)
    private String userEmail;

    @Size(max = 256)
    @Column(name = "user_password", length = 256)
    private String userPassword;

    @Size(max = 256)
    @Column(name = "user_first_name", length = 256)
    private String userFirstName;

    @Size(max = 256)
    @Column(name = "user_last_name", length = 256)
    private String userLastName;

    @Size(max = 13)
    @Column(name = "user_phone_number", length = 13)
    private String userPhoneNumber;

    @OneToMany(mappedBy = "userCreditCard")
    private Set<CreditCard> userAccountCreditCards = new HashSet<>();

    @OneToMany(mappedBy = "paymentTransactionInitiator")
    private Set<PaymentTransaction> userTransactions = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_account_payment_accounts",
               joinColumns = @JoinColumn(name = "user_account_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "payment_accounts_id", referencedColumnName = "id"))
    private Set<PaymentAccount> paymentAccounts = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("users")
    private Country userCountry;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public UserAccount userAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
        return this;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UserAccount userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserAccount userPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public UserAccount userFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
        return this;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public UserAccount userLastName(String userLastName) {
        this.userLastName = userLastName;
        return this;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public UserAccount userPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
        return this;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Set<CreditCard> getUserAccountCreditCards() {
        return userAccountCreditCards;
    }

    public UserAccount userAccountCreditCards(Set<CreditCard> creditCards) {
        this.userAccountCreditCards = creditCards;
        return this;
    }

    public UserAccount addUserAccountCreditCards(CreditCard creditCard) {
        this.userAccountCreditCards.add(creditCard);
        creditCard.setUserCreditCard(this);
        return this;
    }

    public UserAccount removeUserAccountCreditCards(CreditCard creditCard) {
        this.userAccountCreditCards.remove(creditCard);
        creditCard.setUserCreditCard(null);
        return this;
    }

    public void setUserAccountCreditCards(Set<CreditCard> creditCards) {
        this.userAccountCreditCards = creditCards;
    }

    public Set<PaymentTransaction> getUserTransactions() {
        return userTransactions;
    }

    public UserAccount userTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.userTransactions = paymentTransactions;
        return this;
    }

    public UserAccount addUserTransactions(PaymentTransaction paymentTransaction) {
        this.userTransactions.add(paymentTransaction);
        paymentTransaction.setPaymentTransactionInitiator(this);
        return this;
    }

    public UserAccount removeUserTransactions(PaymentTransaction paymentTransaction) {
        this.userTransactions.remove(paymentTransaction);
        paymentTransaction.setPaymentTransactionInitiator(null);
        return this;
    }

    public void setUserTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.userTransactions = paymentTransactions;
    }

    public Set<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public UserAccount paymentAccounts(Set<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
        return this;
    }

    public UserAccount addPaymentAccounts(PaymentAccount paymentAccount) {
        this.paymentAccounts.add(paymentAccount);
        paymentAccount.getUserAccounts().add(this);
        return this;
    }

    public UserAccount removePaymentAccounts(PaymentAccount paymentAccount) {
        this.paymentAccounts.remove(paymentAccount);
        paymentAccount.getUserAccounts().remove(this);
        return this;
    }

    public void setPaymentAccounts(Set<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public Country getUserCountry() {
        return userCountry;
    }

    public UserAccount userCountry(Country country) {
        this.userCountry = country;
        return this;
    }

    public void setUserCountry(Country country) {
        this.userCountry = country;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserAccount)) {
            return false;
        }
        return id != null && id.equals(((UserAccount) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
            "id=" + getId() +
            ", userAccountId=" + getUserAccountId() +
            ", userEmail='" + getUserEmail() + "'" +
            ", userPassword='" + getUserPassword() + "'" +
            ", userFirstName='" + getUserFirstName() + "'" +
            ", userLastName='" + getUserLastName() + "'" +
            ", userPhoneNumber='" + getUserPhoneNumber() + "'" +
            "}";
    }
}
