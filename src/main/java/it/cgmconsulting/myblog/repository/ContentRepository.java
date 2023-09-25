package it.cgmconsulting.myblog.repository;

import it.cgmconsulting.myblog.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content,Integer> {
}
