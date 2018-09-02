package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneId")
    private Long phoneId;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "office")
    private Office office;

    public Phone() {
    }

    public Phone(String phoneNumber, Office office) {
        this.phoneNumber = phoneNumber;
        this.office = office;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Office getOfficePhone() {
        return office;
    }

    public void setOfficePhone(Office officePhone) {
        this.office = officePhone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(phoneId, phone.phoneId) &&
                Objects.equals(phoneNumber, phone.phoneNumber) &&
                Objects.equals(office, phone.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneId, phoneNumber, office);
    }
}
