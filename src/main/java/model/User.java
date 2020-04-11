package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
@Table(name = "users")
public class User {

    public User() {}
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role")
    private String role;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "surname")
    private String surname;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String role, String name, String password, String surname) {
        this.role = role;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }

    public User(long id, String role, String name, String password, String surname) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.password = password;
        this.surname = surname;
    }

}
