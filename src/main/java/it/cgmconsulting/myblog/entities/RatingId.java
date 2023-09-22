package it.cgmconsulting.myblog.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable; //trasforma gli oggetti i array di byte in modo da poter essere trasferiti altrove

@Embeddable // si usa per PK composite o quando la PK è anche una FK
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@EqualsAndHashCode
public class RatingId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
