package it.cgmconsulting.myblog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ReasonId implements Serializable {

    @Column(length = 50 , nullable = false)
    private String reason;

    @Column(nullable = false)
    private LocalDate startDate;
}
