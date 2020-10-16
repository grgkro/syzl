package de.stuttgart.syzl.repository;

import de.stuttgart.syzl.entity.Series;
import de.stuttgart.syzl.entity.StarShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarShortRepository extends JpaRepository<StarShort, Integer> {
    StarShort findById(String id);
}
