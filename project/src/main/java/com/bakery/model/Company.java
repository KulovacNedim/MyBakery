package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
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

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "company_smaccounts", joinColumns = @JoinColumn(name = "smId"),
//            inverseJoinColumns = @JoinColumn(name = "companyId"))
//    private List<SocialMediaAccount> socialMediaAccounts = new ArrayList<>();

    @OneToMany(
            mappedBy = "company",
//            cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST},
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

//    public List<SocialMediaAccount> getSocialMediaAccounts() {
//        return socialMediaAccounts;
//    }
//
//    public void setSocialMediaAccounts(List<SocialMediaAccount> socialMediaAccounts) {
//        this.socialMediaAccounts = socialMediaAccounts;
//    }

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

//    public void addSocialMediaAccount(SocialMediaAccount socialMediaAccount) {
//        CompanySocialMedia companySocialMedia = new CompanySocialMedia(this, socialMediaAccount);
//        companySocialMediaList.add(companySocialMedia);
//    }
//
//    public void removeSocialMediaAccount(SocialMediaAccount socialMediaAccount) {
//        for (Iterator<CompanySocialMedia> iterator = companySocialMediaList.iterator();
//             iterator.hasNext(); ) {
//            CompanySocialMedia companySocialMedia = iterator.next();
//
//            if (companySocialMedia.getCompany().equals(this) &&
//                    companySocialMedia.getSocialMediaAccount().equals(socialMediaAccount)) {
//                iterator.remove();
//                companySocialMedia.setCompany(null);
//                companySocialMedia.setSocialMediaAccount(null);
//            }
//        }
//    }
    public void addSocialMediaAccount(SocialMediaAccount socialMediaAccount) {
        CompanySocialMedia companySocialMedia = new CompanySocialMedia(this, socialMediaAccount);
        companySocialMediaList.add(companySocialMedia);
        socialMediaAccount.getCompanySocialMediaList().add(companySocialMedia);
    }

    public void removeSocialMediaAccount(SocialMediaAccount socialMediaAccount) {
        for (Iterator<CompanySocialMedia> iterator = companySocialMediaList.iterator();
             iterator.hasNext(); ) {
            CompanySocialMedia companySocialMedia = iterator.next();

            if (companySocialMedia.getCompany().equals(this) &&
                    companySocialMedia.getSocialMediaAccount().equals(socialMediaAccount)) {
                iterator.remove();
                companySocialMedia.getSocialMediaAccount().getCompanySocialMediaList().remove(companySocialMedia);
                companySocialMedia.setCompany(null);
                companySocialMedia.setSocialMediaAccount(null);
            }
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", isActive=" + isActive +
                ", offices=" + offices +
//                ", socialMediaAccounts=" + socialMediaAccounts +
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