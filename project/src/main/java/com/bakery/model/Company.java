package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "active")
    private boolean isActive;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Office> offices = new ArrayList<>();

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CompanySocialMedia> companySocialMediaList = new ArrayList<>();

    public Company() {
    }

    public Company(String fullName, String shortName, boolean isActive) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.isActive = isActive;
    }

    public Company(String fullName, String shortName, boolean isActive, List<Office> offices, List<CompanySocialMedia> companySocialMediaList) {
        this.fullName = fullName;
        this.shortName = shortName;
        this.isActive = isActive;
        this.offices = offices;
        this.companySocialMediaList = companySocialMediaList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public List<CompanySocialMedia> getCompanySocialMediaList() {
        return companySocialMediaList;
    }

    public void setCompanySocialMediaList(List<CompanySocialMedia> companySocialMediaList) {
        this.companySocialMediaList = companySocialMediaList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", isActive=" + isActive +
                ", offices=" + offices +
                ", companySocialMediaList=" + companySocialMediaList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return isActive == company.isActive &&
                Objects.equals(id, company.id) &&
                Objects.equals(fullName, company.fullName) &&
                Objects.equals(shortName, company.shortName) &&
                Objects.equals(offices, company.offices) &&
                Objects.equals(companySocialMediaList, company.companySocialMediaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, isActive, offices, companySocialMediaList);
    }
}