package it.cgmconsulting.myblog.repository;

import it.cgmconsulting.myblog.entities.Rating;
import it.cgmconsulting.myblog.entities.RatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingId> {
}
