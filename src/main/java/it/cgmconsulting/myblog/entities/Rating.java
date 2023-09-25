package it.cgmconsulting.myblog.entities;

import it.cgmconsulting.myblog.entities.common.CreationUpdate;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
//nel momento in cui metto il voto non c è modo di sbagliare i
// valori perche il check(controllo) fa si che il rate sia da 1 a 5
public class Rating extends CreationUpdate {

    @EmbeddedId
    private RatingId ratingId;
    @Check (name = "validation_rate", constraints = "rate > 0 AND rate < 6")
    private byte rate; // voti vanno da 1(piu basso) a 5(piu alto)


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Rating rating = (Rating) o;
        return Objects.equals ( ratingId, rating.ratingId );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( ratingId );
    }
}
