package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "capabilities")
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capatability_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "capabilities_subcapabilities", joinColumns = @JoinColumn(name = "subcapatibility_id"),
            inverseJoinColumns = @JoinColumn(name = "capatability_id"))
    private List<SubCapability> subCapabilities = new ArrayList<>();

    public Capability() {

    }

    public Capability(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", subCapabilities=" + subCapabilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capability that = (Capability) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(path, that.path) &&
                Objects.equals(subCapabilities, that.subCapabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, path, subCapabilities);
    }
}