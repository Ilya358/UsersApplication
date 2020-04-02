package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private long id;
    private String name;
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
