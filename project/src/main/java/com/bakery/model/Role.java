package com.bakery.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "protected")
    private boolean isProtected;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<User> users = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "capabilities_roles", joinColumns = @JoinColumn(name = "capability_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Capability> roleCapabilities = new ArrayList<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, boolean isProtected) {
        this.name = name;
        this.isProtected = isProtected;
    }

    public Role(String name, List<User> users, List<Capability> capabilities) {
        this.name = name;
        this.users = users;
        this.roleCapabilities = capabilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Capability> getRoleCapabilities() {
        return roleCapabilities;
    }

    public void setRoleCapabilities(List<Capability> roleCapabilities) {
        this.roleCapabilities = roleCapabilities;
    }

    public boolean isProtected() {
        return isProtected;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isProtected=" + isProtected +
//                ", users=" + users +
                ", roleCapabilities=" + roleCapabilities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return isProtected == role.isProtected &&
                Objects.equals(id, role.id) &&
                Objects.equals(name, role.name) &&
                Objects.equals(users, role.users) &&
                Objects.equals(roleCapabilities, role.roleCapabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isProtected, users, roleCapabilities);
    }
}