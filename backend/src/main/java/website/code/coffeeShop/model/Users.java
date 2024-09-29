package website.code.coffeeShop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private int pid;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String pass;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "status")
    private int status;

    public Users() {}

    public Users(int pid, String fullname, String dob, String email, String phone, String address, String avatar, String username, String pass, int role_id, int status) {
        this.pid = pid;
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.username = username;
        this.pass = pass;
        this.role_id = role_id;
        this.status = status;
    }
}
