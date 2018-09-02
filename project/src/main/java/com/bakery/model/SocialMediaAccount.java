package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "socialmedia")
public class SocialMediaAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smId")
    private Long smId;

    @Column(name = "socialMedia")
    private String socialMedia;

    @Column(name = "smImage")
    private String smImage;

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

    @Override
    public String toString() {
        return "SocialMediaAccount{" +
                "smId=" + smId +
                ", socialMedia='" + socialMedia + '\'' +
                ", smImage='" + smImage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialMediaAccount that = (SocialMediaAccount) o;
        return Objects.equals(smId, that.smId) &&
                Objects.equals(socialMedia, that.socialMedia) &&
                Objects.equals(smImage, that.smImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smId, socialMedia, smImage);
    }

}
