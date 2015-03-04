package com.rizomm.carpooling.model;

import javax.persistence.*;

/**
 * Created by anthonycallaert on 28/02/15.
 */
@Entity
@Table(name = "user_roles", schema = "", catalog = "carpooling")
public class UserRole {
    private int userRoleId;
    private String role;
    private User user;

    @Id
    @Column(name = "user_role_id", nullable = false, insertable = true, updatable = true)
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "ROLE", nullable = false, insertable = true, updatable = true, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userRoleId != userRole.userRoleId) return false;
        if (role != null ? !role.equals(userRole.role) : userRole.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public User getUsersByUsername() {
        return user;
    }

    public void setUsersByUsername(User user) {
        this.user = user;
    }
}
