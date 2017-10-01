package ua.bu.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "quote")
public class Quote implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @Column(name = "type", nullable = false , length = 1)
    private String type;

    @Column(name = "create_moment", nullable = false)
    private Timestamp createMoment;

    @Column(name = "price", nullable = false )
    private double price;

    @Column(name = "qty", nullable = false )
    private long qty;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id" , nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Issue.class)
    @JoinColumn(name = "issue_id" , nullable = false)
    private Issue issueId;


    public Quote() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreateMoment() {
        return createMoment;
    }

    public void setCreateMoment(Timestamp createMoment) {
        this.createMoment = createMoment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
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
        return "Quote{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", createMoment=" + createMoment +
                ", price=" + price +
                ", qty=" + qty +
                ", userId=" + userId +
                ", issueId=" + issueId +
                '}';
    }
}
