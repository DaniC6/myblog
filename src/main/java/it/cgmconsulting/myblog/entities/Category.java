package it.cgmconsulting.myblog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private byte id;
    @Column(nullable = false, unique = true, length = 30)
    private String category_name;
    private boolean visible = true;

    public Category(String category_name) {
        this.category_name = category_name;
    }
}
