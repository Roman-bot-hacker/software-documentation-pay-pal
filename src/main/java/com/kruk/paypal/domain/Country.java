package com.kruk.paypal.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Country.
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "country_id", nullable = false, unique = true)
    private Long countryId;

    @Size(max = 50)
    @Column(name = "country_name", length = 50)
    private String countryName;

    @OneToMany(mappedBy = "bankCountry")
    private Set<Bank> banks = new HashSet<>();

    @OneToMany(mappedBy = "userCountry")
    private Set<UserAccount> users = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Country countryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public Country countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public Country banks(Set<Bank> banks) {
        this.banks = banks;
        return this;
    }

    public Country addBanks(Bank bank) {
        this.banks.add(bank);
        bank.setBankCountry(this);
        return this;
    }

    public Country removeBanks(Bank bank) {
        this.banks.remove(bank);
        bank.setBankCountry(null);
        return this;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    public Set<UserAccount> getUsers() {
        return users;
    }

    public Country users(Set<UserAccount> userAccounts) {
        this.users = userAccounts;
        return this;
    }

    public Country addUsers(UserAccount userAccount) {
        this.users.add(userAccount);
        userAccount.setUserCountry(this);
        return this;
    }

    public Country removeUsers(UserAccount userAccount) {
        this.users.remove(userAccount);
        userAccount.setUserCountry(null);
        return this;
    }

    public void setUsers(Set<UserAccount> userAccounts) {
        this.users = userAccounts;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        return id != null && id.equals(((Country) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Country{" +
            "id=" + getId() +
            ", countryId=" + getCountryId() +
            ", countryName='" + getCountryName() + "'" +
            "}";
    }
}
