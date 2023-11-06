package it.cgmconsulting.myblog.entities;

import it.cgmconsulting.myblog.entities.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post extends CreationUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)// a un post possono essere associati n commenti, la mappatura dipende da post su comment,
                                                                                  // cascade qualsiasi operazione faccio su post si puo ripercuotere sulla lista dei commenti
                                                                                  // orphan se cancelli un post cancelli tutti i commenti legati a quel post
    //abbiamo la doppia relazione perche su hibernate se non dico di avere la lista d commenti associata nel momento in cui istanzio il post non avrei commenti a disposizione

    private Set<Comment> comments = new HashSet<> ();// nelle to many conviene avere sempre un set ( perche non è possibile avere duplicati,con list genera un numero d quesry maggiore)
                                                    // set ottimale rispetto alla lista

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)// i contenuti han logiche di busines, ogni post deve contenere almeno 3 content almeno 1 header 1 footer e tanti elemnti content in mezzo (sezioni, paragrafi) es.giallo zafferano
    private List<Content> contents = new ArrayList<>();


    private LocalDateTime publicationDate; // se null o posteriore alla data attuale il post non è visibile


    public Post(User author, Category category) {
        this.author = author;
        this.category = category;

    }

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setPost(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id );
    }
}
