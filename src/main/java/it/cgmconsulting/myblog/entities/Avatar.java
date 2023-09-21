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
    @Column(nullable = false, columnDefinition = "BLOB") //columnDefinition = non di uso comune , casi eccezionali come questo, dove l annotazione Lob crea un tyniblob e non un blob
    private byte[] data;

    public Avatar(String filename, String filetype, byte[] data) {
        this.filename = filename;
        this.filetype = filetype;
        this.data = data;
    }
}
