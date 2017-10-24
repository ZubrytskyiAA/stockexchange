package ua.bu.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String loginName;
    private String role;

    public Role() {
    }

    public Role(String loginName, String role) {
        this.loginName = loginName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
