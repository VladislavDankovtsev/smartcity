package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Transport;
import ru.dankovtsev.smartcity.model.TransportAvg;
import ru.dankovtsev.smartcity.service.iml.TransportServiceIml;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/smartcity/transport")
public class TransportController {

    @Autowired
    private TransportServiceIml transportServiceIml;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Transport> getAgricultureList(){
        List<Transport> transportList = transportServiceIml.transportFindAll();
        return transportList;
    }

    @RequestMapping(path = "/online", method = RequestMethod.GET)
    public Transport getTransportOnline() throws Exception {
        if (transportServiceIml.online()!=null)
            return transportServiceIml.online();
        else
            return null;
    }

    @RequestMapping(path = "/history", method = RequestMethod.GET)
    public List<Transport> getTransportListHistory(
            @RequestParam(name="dateFrom")String dateFrom,
            @RequestParam(name="dateTo")String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(dateTo, formatter);
        System.out.println("transport: "+from+"  :  "+to);
        List<Transport> transportList = transportServiceIml.transportPeriod(from,to);
        return transportList;
    }

    @RequestMapping(path = "/history/avg", method = RequestMethod.GET)
    public TransportAvg getTransportAvg(
            @RequestParam(name="dateFrom")String dateFrom,
            @RequestParam(name="dateTo")String dateTo){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime from = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(dateTo, formatter);
        return transportServiceIml.transportAvg(from,to);
    }

}
