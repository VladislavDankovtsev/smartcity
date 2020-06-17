package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.SmartHomeSecurity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface SmartHomeSecurityRepository extends JpaRepository<SmartHomeSecurity, UUID> {
    @Query("select s from SmartHomeSecurity s where s.time between :fromD and :toD")
    List<SmartHomeSecurity> getSmartHomeSecurityForDate(@Param("fromD") LocalDateTime fromD, @Param("toD") LocalDateTime toD);

}
