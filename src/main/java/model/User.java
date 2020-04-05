package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    public User() {}
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public User(String name, String password) {
        this.name = name;
        this.surname = password;
    }

    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.surname = password;
    }

}
