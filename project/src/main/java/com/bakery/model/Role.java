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

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<User> users = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "accessflag_role", joinColumns = @JoinColumn(name = "accessFlagId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<AccessFlag> roleFlags = new ArrayList<>();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, List<User> users, List<AccessFlag> roleFlags) {
        this.roleName = roleName;
        this.users = users;
        this.roleFlags = roleFlags;
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

    public List<AccessFlag> getRoleFlags() {
        return roleFlags;
    }

    public void setRoleFlags(List<AccessFlag> roleFlags) {
        this.roleFlags = roleFlags;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                ", roleFlags=" + roleFlags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(users, role.users) &&
                Objects.equals(roleFlags, role.roleFlags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, users, roleFlags);
    }
}
