package it.cgmconsulting.myblog.entities;

import it.cgmconsulting.myblog.entities.common.CreationUpdate;
import it.cgmconsulting.myblog.entities.common.ReportingStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Reporting extends CreationUpdate {

    @EmbeddedId
    private ReportingId reportingId;

    @ManyToOne
    @JoinColumns (
            {@JoinColumn(name = "reason", referencedColumnName = "reason", nullable = false),
            @JoinColumn(name = "start_date", referencedColumnName = "startDate", nullable = false)}
    )
    private Reason reason;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 18)
    private ReportingStatus status = ReportingStatus.OPEN;

    private String note;

    public Reporting(ReportingId reportingId, Reason reason, User user) {
        this.reportingId = reportingId;
        this.reason = reason;
        this.user = user;
    }


}
