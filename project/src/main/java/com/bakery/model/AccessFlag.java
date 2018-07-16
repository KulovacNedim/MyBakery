package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Access Flag
 *
 * This is com.bakery.dto object that manages access for user roles which is referenced by roleId;
 *
 * 
 */

@Entity
@Table(name = "access_flags")
public class AccessFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessFlagId")
    private Long accessFlagId;

    @Column(name = "accessFlag")
    private String accessFlag;

    public AccessFlag() {

    }

    public Long getAccessFlagId() {
        return accessFlagId;
    }

    public void setAccessFlagId(Long accessFlagId) {
        this.accessFlagId = accessFlagId;
    }

    public String getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(String accessFlag) {
        this.accessFlag = accessFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessFlag that = (AccessFlag) o;
        return Objects.equals(getAccessFlagId(), that.getAccessFlagId()) &&
                Objects.equals(getAccessFlag(), that.getAccessFlag());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAccessFlagId(), getAccessFlag());
    }

    @Override
    public String toString() {
        return "AccessFlag{" +
                "accessFlagId=" + accessFlagId +
                ", accessFlag='" + accessFlag + '\'' +
                '}';
    }
}