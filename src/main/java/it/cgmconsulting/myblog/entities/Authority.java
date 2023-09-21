package it.cgmconsulting.myblog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "oakokakoak") qualora volessimo chiamare diveramente dalla classe la tabella (@Table)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private byte id;
    @Column(length = 30, nullable = false, unique = true)
    private String authorityName;
    private boolean visible = true;
    public Authority(String authorityName){
        this.authorityName = authorityName;
    }


}
