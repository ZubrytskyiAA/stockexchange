package ua.bu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String loginName;
    private String role;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
//    @JoinColumn(name = "role_id")
//    private List<User> users = new ArrayList<>();


    public int getId() {
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
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

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
//                ", users=" + users +
                '}';
    }
}
