package ua.bu.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @SuppressWarnings(value = "unchecked")
    private long id;

    @Column(name = "type", nullable = false, length = 1)
    private String type;

    @Column(name = "status", nullable = false, length = 2)
    private int status;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "qty", nullable = false)
    private long qty;

    @Column(name = "volume", nullable = false)
    private double volume;

    @Column(name = "trade_moment", nullable = false)
    private Timestamp tradeMoment;

    @Column(name = "init_action", nullable = false, length = 1)
    private String initAction;

    @Column(name = "conf_action", nullable = false, length = 1)
    private String confAction;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Issue.class)
    @JoinColumn(name = "issue_id")
    private Issue issue;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}
            , targetEntity = User.class)
    @JoinColumn(name = "user_init_id")
    private User userInit;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}
            , targetEntity = User.class)
    @JoinColumn(name = "user_conf_id")
    private User userConf;


    public Trade() {
    }

    public User getUserInit() {
        return userInit;
    }

    public void setUserInit(User userInit) {
        this.userInit = userInit;
    }

    public User getUserConf() {
        return userConf;
    }

    public void setUserConf(User userConf) {
        this.userConf = userConf;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Timestamp getTradeMoment() {
        return tradeMoment;
    }

    public void setTradeMoment(Timestamp tradeMoment) {
        this.tradeMoment = tradeMoment;
    }

    public String getInitAction() {
        return initAction;
    }

    public void setInitAction(String initAction) {
        this.initAction = initAction;
    }

    public String getConfAction() {
        return confAction;
    }

    public void setConfAction(String confAction) {
        this.confAction = confAction;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }


    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", qty=" + qty +
                ", volume=" + volume +
                ", tradeMoment=" + tradeMoment +
                ", initAction='" + initAction + '\'' +
                ", confAction='" + confAction + '\'' +
                ", issue=" + issue +
                ", userInit=" + userInit +
                ", userConf=" + userConf +
                '}';
    }
}
