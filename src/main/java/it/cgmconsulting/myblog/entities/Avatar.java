package it.cgmconsulting.myblog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    @Column(nullable = false)
    private String filename;
    @Column(length = 50, nullable = false)
    private String filetype;
    @Lob
    @Column(nullable = false, columnDefinition = "BLOB")
    private byte[] data;

    public Avatar(String filename, String filetype, byte[] data) {
        this.filename = filename;
        this.filetype = filetype;
        this.data = data;
    }
}
