package de.stuttgart.syzl.repository;

import de.stuttgart.syzl.entity.NewMovieIMDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewMovieIMDBRepository extends JpaRepository<NewMovieIMDB, Integer> {
    NewMovieIMDB findById(String id);
}
