package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyId")
    private Long companyId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "shortName")
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
                "companyId=" + companyId +
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
                Objects.equals(companyId, company.companyId) &&
                Objects.equals(fullName, company.fullName) &&
                Objects.equals(shortName, company.shortName) &&
                Objects.equals(offices, company.offices) &&
                Objects.equals(companySocialMediaList, company.companySocialMediaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, fullName, shortName, isActive, offices, companySocialMediaList);
    }
}