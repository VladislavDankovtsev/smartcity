package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.repository.AgriculureService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/smartcity")
public class AgricultureController {
    @Autowired
    private AgriculureService agriculureService;

    @RequestMapping(path = "/agricalture", method = RequestMethod.GET)
    public List<Agriculture> getAgricultureList(){
        List<Agriculture> agricultureList = agriculureService.findAll();
        return agricultureList;
    }

    @RequestMapping(path = "/agricalturehistory", method = RequestMethod.GET)
    public List<Agriculture> getAgricultureListHistory(@RequestParam(name="dateFrom") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateFrom,
                                                @RequestParam(name="dateTo") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateTo){

        List<Agriculture> agricultureList = agriculureService.findAll();
        return agricultureList;
    }

}
