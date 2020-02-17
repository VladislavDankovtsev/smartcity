package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dankovtsev.smartcity.model.SmartHome;

import java.util.UUID;

public interface SmartHomeRepository extends JpaRepository<SmartHome, UUID> {
}
