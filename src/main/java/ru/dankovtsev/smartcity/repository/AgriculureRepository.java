package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.Agriculture;

import java.util.UUID;

@Repository
public interface AgriculureRepository extends JpaRepository<Agriculture, UUID> {
}
