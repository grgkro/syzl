package de.stuttgart.syzl.repository;

import de.stuttgart.syzl.entity.Movie;
import de.stuttgart.syzl.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {
    Series findById(String id);
}
