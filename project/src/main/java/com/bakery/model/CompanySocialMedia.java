package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "company_smaccounts")
public class CompanySocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long csmId;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "smId")
    private SocialMediaAccount socialMediaAccount;

    @Column(name = "sm_mark_name")
    private String smMarkName;

    @Column(name = "sm_path")
    private String smPath;

    public CompanySocialMedia() {
    }

    public Long getCsmId() {
        return csmId;
    }

    public void setCsmId(Long csmId) {
        this.csmId = csmId;
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

    public String getSmMarkName() {
        return smMarkName;
    }

    public void setSmMarkName(String smMarkName) {
        this.smMarkName = smMarkName;
    }

    public String getSmPath() {
        return smPath;
    }

    public void setSmPath(String smPath) {
        this.smPath = smPath;
    }

    public CompanySocialMedia(Company company, SocialMediaAccount socialMediaAccount, String smMarkName, String smPath) {
        this.company = company;
        this.socialMediaAccount = socialMediaAccount;
        this.smMarkName = smMarkName;
        this.smPath = smPath;
    }

    @Override
    public String toString() {
        return "CompanySocialMedia{" +
                "csmId=" + csmId +
//                ", company=" + company +
                ", socialMediaAccount=" + socialMediaAccount +
                ", smMarkName='" + smMarkName + '\'' +
                ", smPath='" + smPath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySocialMedia that = (CompanySocialMedia) o;
        return Objects.equals(csmId, that.csmId) &&
                Objects.equals(company, that.company) &&
                Objects.equals(socialMediaAccount, that.socialMediaAccount) &&
                Objects.equals(smMarkName, that.smMarkName) &&
                Objects.equals(smPath, that.smPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csmId, company, socialMediaAccount, smMarkName, smPath);
    }

}
