package ru.dankovtsev.smartcity.service;

import ru.dankovtsev.smartcity.model.Production;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductionService {
    Production online();
    List<Production> productionsPeriod(LocalDateTime from, LocalDateTime to);
    List<Production> productionFindAll();
}
