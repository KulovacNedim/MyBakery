package com.bakery.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity()
@Table(name = "company_smaccounts")
public class CompanySocialMedia implements Serializable {

    @EmbeddedId
    private CompanySocialMediaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("company_id")
    @JoinColumn(name="company_id", insertable = false, nullable = false, updatable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sm_id")
    @JoinColumn(name="sm_id", insertable = false, nullable = false, updatable = false)
    private SocialMediaAccount socialMediaAccount;

    @Column(name = "sm_mark_name")
    private String smMarkName;

    @Column(name = "sm_path")
    private String smPath;

    public CompanySocialMedia() {
    }

    public CompanySocialMedia(Company company, SocialMediaAccount socialMediaAccount) {
        this.company = company;
        this.socialMediaAccount = socialMediaAccount;
        this.id = new CompanySocialMediaId(company.getCompanyId(), socialMediaAccount.getSmId());
    }

    public CompanySocialMedia(Company company, String smMarkName, SocialMediaAccount socialMediaAccount) {
        this.company = company;
        this.smMarkName = smMarkName;
        this.socialMediaAccount = socialMediaAccount;
        this.id = new CompanySocialMediaId(company.getCompanyId(), socialMediaAccount.getSmId());
    }

    public CompanySocialMediaId getId() {
        return id;
    }

    public void setId(CompanySocialMediaId id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getSmMarkName() {
        return smMarkName;
    }

    public void setSmMarkName(String smMarkName) {
        this.smMarkName = smMarkName;
    }

    public SocialMediaAccount getSocialMediaAccount() {
        return socialMediaAccount;
    }

    public void setSocialMediaAccount(SocialMediaAccount socialMediaAccount) {
        this.socialMediaAccount = socialMediaAccount;
    }

    public String getSmPath() {
        return smPath;
    }

    public void setSmPath(String smPath) {
        this.smPath = smPath;
    }

    @Override
    public String toString() {
        return "CompanySocialMedia{" +
                "id=" + id +
//                ", company=" + company +
//                ", socialMediaAccount=" + socialMediaAccount +
                ", smMarkName='" + smMarkName + '\'' +
                ", smPath='" + smPath + '\'' +
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
                Objects.equals(smMarkName, that.smMarkName) &&
                Objects.equals(smPath, that.smPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, socialMediaAccount, smMarkName, smPath);
    }
}
