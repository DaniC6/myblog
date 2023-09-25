package it.cgmconsulting.myblog.repository;

import it.cgmconsulting.myblog.entities.Reason;
import it.cgmconsulting.myblog.entities.ReasonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, ReasonId> {
}
