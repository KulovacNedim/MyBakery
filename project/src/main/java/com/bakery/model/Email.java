package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private Long emailId;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "office")
    private Office office;

    public Email() {
    }

    public Email(String email, Office office) {
        this.email = email;
        this.office = office;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(emailId, email1.emailId) &&
                Objects.equals(email, email1.email) &&
                Objects.equals(office, email1.office);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId, email, office);
    }
}