package it.cgmconsulting.myblog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Reason {

    @EmbeddedId
    private ReasonId reasonId;

    private LocalDate endDate;

    private int severity; // gravità -> numero di giorni di ban associati alla reason

    public Reason(ReasonId reasonId, int severity) {
        this.reasonId = reasonId;
        this.severity = severity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reason reason = (Reason) o;
        return Objects.equals(reasonId, reason.reasonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reasonId);
    }
}
