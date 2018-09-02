package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "officies")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
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
    @JoinTable(name = "users_officies", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id"))
    private List<User> users = new ArrayList<>();

    public Office() {
    }

    public Office(Company company, String name) {
        this.company = company;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
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
        return Objects.equals(id, office.id) &&
                Objects.equals(company, office.company) &&
                Objects.equals(name, office.name) &&
                Objects.equals(address, office.address) &&
                Objects.equals(phones, office.phones) &&
                Objects.equals(emails, office.emails) &&
                Objects.equals(users, office.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, name, address, phones, emails, users);
    }
}
