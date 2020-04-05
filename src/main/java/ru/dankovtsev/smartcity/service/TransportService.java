package ru.dankovtsev.smartcity.service;

import ru.dankovtsev.smartcity.model.Transport;

import java.time.LocalDateTime;
import java.util.List;

public interface TransportService {
    Transport online();
    List<Transport> transportPeriod(LocalDateTime from, LocalDateTime to);
    List<Transport> transportFindAll();
}
