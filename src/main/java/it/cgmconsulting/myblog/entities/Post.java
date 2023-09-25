package it.cgmconsulting.myblog.entities;

import it.cgmconsulting.myblog.entities.common.CreationUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Post extends CreationUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)// a un post possono essere associati n commenti, la mappatura dipende da post su comment,
                                                                                  // cascade qualsiasi operazione faccio su post si puo ripercuotere sulla lista dei commenti
                                                                                  // orphan se cancelli un post cancelli tutti i commenti legati a quel post
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Content> contents = new ArrayList<>();


    private LocalDateTime publicationDate; // se null o posteriore alla data attuale il post non è visibile


    public void addComment(Comment comment){
        comments.add(comment);
        comment.setPost(this);
    }


    private double average;

}
