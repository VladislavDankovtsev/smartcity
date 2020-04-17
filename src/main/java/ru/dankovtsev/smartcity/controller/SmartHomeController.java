package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.repository.SmartHomeRepository;
import ru.dankovtsev.smartcity.service.iml.SmartHomeServiceIml;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/smartcity/smarthome")
public class SmartHomeController {

    @Autowired
    private SmartHomeRepository smartHomeRepository;
    @Autowired
    private SmartHomeServiceIml smartHomeServiceIml;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<SmartHome> getAgricultureListHistory(){
        if(smartHomeServiceIml.smartHomeFindAll()!=null)
         return smartHomeServiceIml.smartHomeFindAll();
        else return null;
    }
    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public SmartHome getSmartHomeOnline(){
        SmartHome smartHome = smartHomeServiceIml.online();
        return smartHome;
    }

    @RequestMapping(path = "/history", method = RequestMethod.GET)
    public List<SmartHome> getAgricultureListHistory(
            @RequestParam(name="dateFrom")String dateFrom,
            @RequestParam(name="dateTo")String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(dateTo, formatter);
        System.out.println("production: "+from+"  :  "+to);
        List<SmartHome> smartHomeList = smartHomeServiceIml.smartHomePeriod(from,to);
        return smartHomeList;
    }
}
