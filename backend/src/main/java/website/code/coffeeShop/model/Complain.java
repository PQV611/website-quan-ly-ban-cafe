package website.code.coffeeShop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private int cid;

    @Column(name = "userId")
    private int userId;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "title")
    private String title;

    @Column(name = "complain")
    private String complainUser;

    @Column(name = "respon")
    private String respon;

    @Column(name = "status")
    private int status;
}
