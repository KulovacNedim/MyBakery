package com.bakery.model;



import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "socialmedia")
@NaturalIdCache
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class SocialMediaAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smId")
    private Long smId;

    @NaturalId
    @Column(name = "socialMedia")
    private String socialMedia;

    @Column(name = "smImage")
    private String smImage;

    @OneToMany(
            mappedBy = "socialMediaAccount",
//            cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST},
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CompanySocialMedia> companySocialMediaList = new ArrayList<>();

    public SocialMediaAccount() {
    }

    public SocialMediaAccount(String socialMedia, String smImage) {
        this.socialMedia = socialMedia;
        this.smImage = smImage;
    }

    public Long getSmId() {
        return smId;
    }

    public void setSmId(Long smId) {
        this.smId = smId;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getSmImage() {
        return smImage;
    }

    public void setSmImage(String smImage) {
        this.smImage = smImage;
    }

    public List<CompanySocialMedia> getCompanySocialMediaList() {
        return companySocialMediaList;
    }

    public void setCompanySocialMediaList(List<CompanySocialMedia> companySocialMediaList) {
        this.companySocialMediaList = companySocialMediaList;
    }

    @Override
    public String toString() {
        return "SocialMediaAccount{" +
                "smId=" + smId +
                ", socialMedia='" + socialMedia + '\'' +
                ", smImage='" + smImage + '\'' +
                ", companySocialMediaList=" + companySocialMediaList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialMediaAccount that = (SocialMediaAccount) o;
        return Objects.equals(smId, that.smId) &&
                Objects.equals(socialMedia, that.socialMedia) &&
                Objects.equals(smImage, that.smImage) &&
                Objects.equals(companySocialMediaList, that.companySocialMediaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smId, socialMedia, smImage, companySocialMediaList);
    }
}
