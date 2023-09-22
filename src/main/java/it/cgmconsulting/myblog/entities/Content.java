package it.cgmconsulting.myblog.entities;

import it.cgmconsulting.myblog.entities.common.ContentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String title;
    @Column(nullable = false, length = 10000)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    private ContentType type;

    private byte prg; // progressivo per ordinamento di content tipo C

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " post_id", nullable = false)
    private Post post;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "content_images", joinColumns = {@JoinColumn(name = "content_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id")})
    private Set<Image> images; //rappresenta la tabella di relazione

    public Content(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
