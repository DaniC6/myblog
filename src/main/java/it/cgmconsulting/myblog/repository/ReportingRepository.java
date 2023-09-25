package it.cgmconsulting.myblog.repository;

import it.cgmconsulting.myblog.entities.Reporting;
import it.cgmconsulting.myblog.entities.ReportingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingRepository extends JpaRepository<Reporting, ReportingId> {
}
