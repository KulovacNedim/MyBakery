package com.bakery.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<User> users;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "role_x_accessflag", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "accessFlagId")})
    private List<AccessFlag> accessFlags;


    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(String role, List<AccessFlag> accessFlags) {
        this.role = role;
        this.accessFlags = accessFlags;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<AccessFlag> getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(List<AccessFlag> accessFlags) {
        this.accessFlags = accessFlags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(getRoleId(), role1.getRoleId()) &&
                Objects.equals(getRole(), role1.getRole()) &&
                Objects.equals(getUsers(), role1.getUsers()) &&
                Objects.equals(getAccessFlags(), role1.getAccessFlags());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoleId(), getRole(), getUsers(), getAccessFlags());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                '}';
    }
}
