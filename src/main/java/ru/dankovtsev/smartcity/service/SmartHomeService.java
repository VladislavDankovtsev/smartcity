package ru.dankovtsev.smartcity.service;

import ru.dankovtsev.smartcity.model.SmartHome;

import java.time.LocalDateTime;
import java.util.List;

public interface SmartHomeService {
    SmartHome online();
    List<SmartHome> smartHomePeriod(LocalDateTime from, LocalDateTime to);
    List<SmartHome> smartHomeFindAll();
}
