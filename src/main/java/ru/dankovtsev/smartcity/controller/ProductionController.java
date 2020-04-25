package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.model.ProductionAvg;
import ru.dankovtsev.smartcity.service.iml.ProductionServiceIml;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/smartcity/production")
public class ProductionController {

    @Autowired
    private ProductionServiceIml productionServiceIml;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Production> getProductionList(){
        List<Production> productionList = productionServiceIml.productionFindAll();
        return productionList;
    }

    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public Production getProductionOnline(){
        if (productionServiceIml.online()!=null)
            return productionServiceIml.online();
        else
            return null;
    }

    @RequestMapping(path = "/history", method = RequestMethod.GET)
    public List<Production> getAgricultureListHistory(
            @RequestParam(name="dateFrom")String dateFrom,
            @RequestParam(name="dateTo")String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(dateTo, formatter);
        System.out.println("production: "+from+"  :  "+to);
        List<Production> productionList = productionServiceIml.productionsPeriod(from,to);
        return productionList;
    }

    @RequestMapping(path = "/history/avg", method = RequestMethod.GET)
    public ProductionAvg getAgricultureAvg(
            @RequestParam(name="dateFrom")String dateFrom,
            @RequestParam(name="dateTo")String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(dateTo, formatter);
        System.out.println("production: "+from+"  :  "+to);
        return productionServiceIml.productionAvg(from,to);
    }



}
