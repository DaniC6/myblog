package it.cgmconsulting.myblog.entities;

import it.cgmconsulting.myblog.entities.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "user_")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User extends CreationUpdate {

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authorities", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities; //rappresenta la tabella di relazione


    public User(String email, String username, String password, String bio) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.bio = bio;
    }
}


//FetchType (tutte le relazioni hanno un attributo che si chiama fetch che configurabile come tipologia eager o lazy)
// tutte le to many sono di tipo lazy
// tutte quelle to one sono di tipo eager
// EAGER (INGORDO) riporta l unico valore che riusciamo ad estrarre e riporta tutti i dati della foreign key
// LAZY