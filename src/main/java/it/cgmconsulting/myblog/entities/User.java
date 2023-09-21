package it.cgmconsulting.myblog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(length = 20, unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private boolean enabled = false;
    private String bio;

    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    public User(String email, String username, String password, String bio) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
    }
}
