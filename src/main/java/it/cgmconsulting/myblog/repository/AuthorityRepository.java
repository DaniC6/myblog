package it.cgmconsulting.myblog.repository;

import it.cgmconsulting.myblog.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Byte> {


}
