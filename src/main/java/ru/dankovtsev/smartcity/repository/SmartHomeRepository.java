package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.model.SmartHome;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface SmartHomeRepository extends JpaRepository<SmartHome, UUID> {
    @Query("select s from SmartHome s where s.time between :fromD and :toD")
    List<SmartHome> getSmartHomeForDate(@Param("fromD") LocalDateTime fromD, @Param("toD") LocalDateTime toD);
}
