package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "companysocialmedias")
public class CompanySocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companysocialmedia_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "socialmedia_id")
    private SocialMediaAccount socialMediaAccount;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    public CompanySocialMedia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public SocialMediaAccount getSocialMediaAccount() {
        return socialMediaAccount;
    }

    public void setSocialMediaAccount(SocialMediaAccount socialMediaAccount) {
        this.socialMediaAccount = socialMediaAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CompanySocialMedia(Company company, SocialMediaAccount socialMediaAccount, String name, String path) {
        this.company = company;
        this.socialMediaAccount = socialMediaAccount;
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return "CompanySocialMedia{" +
                "id=" + id +
//                ", company=" + company +
                ", socialMediaAccount=" + socialMediaAccount +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySocialMedia that = (CompanySocialMedia) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(company, that.company) &&
                Objects.equals(socialMediaAccount, that.socialMediaAccount) &&
                Objects.equals(name, that.name) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, socialMediaAccount, name, path);
    }

}
