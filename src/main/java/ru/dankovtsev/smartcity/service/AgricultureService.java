package ru.dankovtsev.smartcity.service;

import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.model.AgricultureArray;

import java.time.LocalDateTime;
import java.util.List;

public interface AgricultureService {
    Agriculture online();
    List<AgricultureArray> agriculturePeriod(LocalDateTime from, LocalDateTime to);
    List<Agriculture> agricultureFindAll();

}
