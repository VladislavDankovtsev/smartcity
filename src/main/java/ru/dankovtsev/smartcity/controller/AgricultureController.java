package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.service.iml.AgricultureServiceIml;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/smartcity/agricalture")
public class AgricultureController {

    @Autowired
    private AgricultureServiceIml agricultureServiceIml;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Agriculture> getAgricultureList(){
        List<Agriculture> agricultureList = agricultureServiceIml.agricultureFindAll();
        return agricultureList;
    }

    @RequestMapping(path = "/history", method = RequestMethod.GET)
    public List<Agriculture> getAgricultureListHistory(
            @RequestParam(name="dateFrom")String dateFrom,
            @RequestParam(name="dateTo")String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(dateTo, formatter);
        System.out.println("agriculture: "+from+"  :  "+to);
        List<Agriculture> agricultureList = agricultureServiceIml.agriculturePeriod(from,to);
        return agricultureList;
    }

    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public Agriculture getAgricultureOnline(){
        Agriculture agriculture = agricultureServiceIml.online();
        return agriculture;
    }

}
