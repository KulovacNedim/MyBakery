package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long addressId;

    @Column(name = "adressStreet")
    private String adressStreet;

    @Column(name = "addressState")
    private String addressState;

    @Column(name = "addressCity")
    private String addressCity;

    @Column(name = "addresZIPcode")
    private String addresZIPcode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeid")
    private Office office;

    public Address(String adressStreet, String addressState, String addressCity, String addresZIPcode) {
        this.adressStreet = adressStreet;
        this.addressState = addressState;
        this.addressCity = addressCity;
        this.addresZIPcode = addresZIPcode;
    }

    public Address() {

    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddresZIPcode() {
        return addresZIPcode;
    }

    public void setAddresZIPcode(String addresZIPcode) {
        this.addresZIPcode = addresZIPcode;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", adressStreet='" + adressStreet + '\'' +
                ", addressState='" + addressState + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addresZIPcode='" + addresZIPcode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressId, address.addressId) &&
                Objects.equals(adressStreet, address.adressStreet) &&
                Objects.equals(addressState, address.addressState) &&
                Objects.equals(addressCity, address.addressCity) &&
                Objects.equals(addresZIPcode, address.addresZIPcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, adressStreet, addressState, addressCity, addresZIPcode);
    }
}
