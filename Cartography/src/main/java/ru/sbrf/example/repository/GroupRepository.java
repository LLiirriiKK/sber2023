package ru.sbrf.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbrf.example.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
