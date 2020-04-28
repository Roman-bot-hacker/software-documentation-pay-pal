package com.kruk.paypal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Bank.
 */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "bank_id", nullable = false, unique = true)
    private Long bankId;

    @Size(max = 256)
    @Column(name = "bank_name", length = 256)
    private String bankName;

    @Size(max = 256)
    @Column(name = "bank_info", length = 256)
    private String bankInfo;

    @OneToMany(mappedBy = "creditCardBank")
    private Set<CreditCard> bankCreditCards = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("banks")
    private Country bankCountry;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBankId() {
        return bankId;
    }

    public Bank bankId(Long bankId) {
        this.bankId = bankId;
        return this;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public Bank bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public Bank bankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
        return this;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Set<CreditCard> getBankCreditCards() {
        return bankCreditCards;
    }

    public Bank bankCreditCards(Set<CreditCard> creditCards) {
        this.bankCreditCards = creditCards;
        return this;
    }

    public Bank addBankCreditCards(CreditCard creditCard) {
        this.bankCreditCards.add(creditCard);
        creditCard.setCreditCardBank(this);
        return this;
    }

    public Bank removeBankCreditCards(CreditCard creditCard) {
        this.bankCreditCards.remove(creditCard);
        creditCard.setCreditCardBank(null);
        return this;
    }

    public void setBankCreditCards(Set<CreditCard> creditCards) {
        this.bankCreditCards = creditCards;
    }

    public Country getBankCountry() {
        return bankCountry;
    }

    public Bank bankCountry(Country country) {
        this.bankCountry = country;
        return this;
    }

    public void setBankCountry(Country country) {
        this.bankCountry = country;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bank)) {
            return false;
        }
        return id != null && id.equals(((Bank) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Bank{" +
            "id=" + getId() +
            ", bankId=" + getBankId() +
            ", bankName='" + getBankName() + "'" +
            ", bankInfo='" + getBankInfo() + "'" +
            "}";
    }
}
