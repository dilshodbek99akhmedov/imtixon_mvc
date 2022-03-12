package uz.pdp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String username, String password, String phoneNumber, Role role) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}



