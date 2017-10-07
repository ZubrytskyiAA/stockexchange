package ua.bu.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "loginName")})

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "loginName", unique = true, nullable = false, length = 20)
    private String loginName;
    @Column(name = "password", nullable = false)

    private String password;
    @Column(name = "fio", nullable = false)
    private String fio;
    @Column(name = "email")

    private String email;
    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "active", nullable = false)
    private boolean active = true;


    public User() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", active=" + active +
                '}';
    }
}
