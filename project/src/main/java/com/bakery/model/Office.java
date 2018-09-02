package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeid")
    private Long officeId;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "office", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(
            mappedBy = "office",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(
            mappedBy = "office",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Email> emails = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_office", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "officeId"))
    private List<User> users = new ArrayList<>();

    public Office() {
    }

    public Office(Company company, String name, Address address) {
        this.company = company;
        this.name = name;
        this.address = address;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phones=" + phones +
                ", emails=" + emails +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return Objects.equals(officeId, office.officeId) &&
                Objects.equals(company, office.company) &&
                Objects.equals(name, office.name) &&
                Objects.equals(address, office.address) &&
                Objects.equals(phones, office.phones) &&
                Objects.equals(emails, office.emails) &&
                Objects.equals(users, office.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId, company, name, address, phones, emails, users);
    }
}
