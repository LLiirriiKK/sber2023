package ru.sbrf.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbrf.example.domain.Album;
import ru.sbrf.example.domain.Group;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
