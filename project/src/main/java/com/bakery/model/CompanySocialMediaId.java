package com.bakery.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompanySocialMediaId implements Serializable {

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "sm_id")
    private Long smId;

    public CompanySocialMediaId() {
    }

    public CompanySocialMediaId(Long companyId, Long smId) {
        this.companyId = companyId;
        this.smId = smId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getSmId() {
        return smId;
    }

    public void setSmId(Long smId) {
        this.smId = smId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySocialMediaId that = (CompanySocialMediaId) o;
        return Objects.equals(companyId, that.companyId) &&
                Objects.equals(smId, that.smId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, smId);
    }
}
