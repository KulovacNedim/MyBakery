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
    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "protected")
    private boolean isProtected;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<User> users = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "capability_role", joinColumns = @JoinColumn(name = "capabilityId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Capability> roleCapabilities = new ArrayList<>();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, boolean isProtected) {
        this.roleName = roleName;
        this.isProtected = isProtected;
    }

    public Role(String roleName, List<User> users, List<Capability> capabilities) {
        this.roleName = roleName;
        this.users = users;
        this.roleCapabilities = capabilities;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
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
                Objects.equals(roleId, role.roleId) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(users, role.users) &&
                Objects.equals(roleCapabilities, role.roleCapabilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, isProtected, users, roleCapabilities);
    }
}