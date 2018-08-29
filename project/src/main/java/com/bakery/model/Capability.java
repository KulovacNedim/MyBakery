package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "capability")
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capabilityId")
    private int capabilityId;

    @Column(name = "capabilityName")
    private String capabilityName;

    @Column(name = "path")
    private String path;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "capability_subcapabilities", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "capabilityId"))
    private List<SubCapability> subCapabilities = new ArrayList<>();

    public Capability() {

    }

    public Capability(String capabilityName, String path) {
        this.capabilityName = capabilityName;
        this.path = path;
    }

    public int getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(int capabilityId) {
        this.capabilityId = capabilityId;
    }

    public String getCapabilityName() {
        return capabilityName;
    }

    public void setCapabilityName(String capabilityName) {
        this.capabilityName = capabilityName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SubCapability> getSubCapabilities() {
        return subCapabilities;
    }

    public void setSubCapabilities(List<SubCapability> subCapabilities) {
        this.subCapabilities = subCapabilities;
    }

    @Override
    public String toString() {
        return "Capability{" +
                "capabilityId=" + capabilityId +
                ", capabilityName='" + capabilityName + '\'' +
                ", path='" + path + '\'' +
                ", subCapabilities=" + subCapabilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capability that = (Capability) o;
        return capabilityId == that.capabilityId &&
                Objects.equals(capabilityName, that.capabilityName) &&
                Objects.equals(path, that.path) &&
                Objects.equals(subCapabilities, that.subCapabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capabilityId, capabilityName, path, subCapabilities);
    }
}