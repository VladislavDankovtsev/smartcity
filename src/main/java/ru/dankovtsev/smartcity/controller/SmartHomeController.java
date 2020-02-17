package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.model.Server;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.repository.SmartHomeRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/smartcity")
public class SmartHomeController {

    @Autowired
    private SmartHomeRepository smartHomeRepository;

    @RequestMapping(path = "/smarthome", method = RequestMethod.GET)
    public List<SmartHome> getAgricultureListHistory(){

        List<SmartHome> smartHomeList = smartHomeRepository.findAll();
        return smartHomeList;
    }
}
