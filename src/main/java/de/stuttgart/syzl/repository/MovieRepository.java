package de.stuttgart.syzl.repository;

import de.stuttgart.syzl.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findById(Long id);
    Movie findBySourceId(String SourceId);
}
