package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.model.Production;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ProductionRepository extends JpaRepository<Production, UUID> {
    @Query("select s from Production s where s.time between :fromD and :toD")
    List<Production> getProductionForDate(@Param("fromD") LocalDateTime fromD, @Param("toD") LocalDateTime toD);
}
