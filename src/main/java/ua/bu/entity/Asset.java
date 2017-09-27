package ua.bu.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "free", nullable = false)
    private double free;

    @Column(name = "blocked", nullable = false)
    private double blocked;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Issue.class)
    @JoinColumn(name = "issue_id")
    private Issue issueId;


    public Asset() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFree() {
        return free;
    }

    public void setFree(double free) {
        this.free = free;
    }

    public double getBlocked() {
        return blocked;
    }

    public void setBlocked(double blocked) {
        this.blocked = blocked;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Issue getIssueId() {
        return issueId;
    }

    public void setIssueId(Issue issueId) {
        this.issueId = issueId;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", free=" + free +
                ", blocked=" + blocked +
                ", userId=" + userId +
                ", issueId=" + issueId +
                '}';
    }
}
