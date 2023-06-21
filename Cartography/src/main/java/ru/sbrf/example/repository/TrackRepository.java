package ru.sbrf.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbrf.example.domain.Group;
import ru.sbrf.example.domain.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
