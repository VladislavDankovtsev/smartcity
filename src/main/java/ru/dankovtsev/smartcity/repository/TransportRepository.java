package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.Transport;

import java.util.UUID;

@Repository
public interface TransportRepository extends JpaRepository<Transport, UUID> {
}
