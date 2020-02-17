package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dankovtsev.smartcity.model.Production;

import java.util.UUID;

public interface ProductionRepository extends JpaRepository<Production, UUID> {
}
