package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.model.Transport;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransportRepository extends JpaRepository<Transport, UUID> {
    @Query("select s from Transport s where s.time between :fromD and :toD")
    List<Transport> getTransportForDate(@Param("fromD") LocalDateTime fromD, @Param("toD") LocalDateTime toD);
}
