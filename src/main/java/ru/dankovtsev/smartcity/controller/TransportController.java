package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.model.Transport;
import ru.dankovtsev.smartcity.repository.TransportRepository;
import ru.dankovtsev.smartcity.service.iml.TransportServiceIml;

import java.util.List;

@RestController
@RequestMapping("/smartcity")
public class TransportController {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private TransportServiceIml transportServiceIml;

    @RequestMapping(path = "/transport", method = RequestMethod.GET)
    public List<Transport> getAgricultureList(){
        List<Transport> transportList = transportRepository.findAll();
        return transportList;
    }

    @RequestMapping(path = "/transport/online", method = RequestMethod.GET)
    public Transport getTransportOnline(){
        return transportServiceIml.online();
    }
}
