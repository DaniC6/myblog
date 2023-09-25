package it.cgmconsulting.myblog.repository;

import it.cgmconsulting.myblog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}
