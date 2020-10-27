package de.stuttgart.syzl.repository;

import de.stuttgart.syzl.entity.YouTubeTrailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YouTubeTrailerRepository extends JpaRepository<YouTubeTrailer, Integer> {
    YouTubeTrailer findBySourceId(String sourceId);
}
