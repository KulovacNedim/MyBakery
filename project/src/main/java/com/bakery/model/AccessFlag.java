package com.bakery.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "access_flags")
public class AccessFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessFlagId")
    private int accessFlagId;

    @Column(name = "accessFlagName")
    private String accessFlagName;

    public AccessFlag() {

    }

    public AccessFlag(String accessFlagName) {
        this.accessFlagName = accessFlagName;
    }

    public int getAccessFlagId() {
        return accessFlagId;
    }

    public void setAccessFlagId(int accessFlagId) {
        this.accessFlagId = accessFlagId;
    }

    public String getAccessFlagName() {
        return accessFlagName;
    }

    public void setAccessFlagName(String accessFlagName) {
        this.accessFlagName = accessFlagName;
    }

    @Override
    public String toString() {
        return "AccessFlag{" +
                "accessFlagId=" + accessFlagId +
                ", accessFlagName='" + accessFlagName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessFlag that = (AccessFlag) o;
        return accessFlagId == that.accessFlagId &&
                Objects.equals(accessFlagName, that.accessFlagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessFlagId, accessFlagName);
    }
}