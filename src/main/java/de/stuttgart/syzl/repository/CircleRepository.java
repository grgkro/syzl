package de.stuttgart.syzl.repository;

import de.stuttgart.syzl.entity.Circle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircleRepository extends JpaRepository<Circle, Integer> {
}
