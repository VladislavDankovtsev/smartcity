package ru.dankovtsev.smartcity.service;

import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.model.SmartHomeArray;

import java.time.LocalDateTime;
import java.util.List;

public interface SmartHomeService {
    SmartHome online();
    List<SmartHomeArray> smartHomePeriod(LocalDateTime from, LocalDateTime to);
    List<SmartHome> smartHomeFindAll();
}
