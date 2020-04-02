package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Server;
import ru.dankovtsev.smartcity.repository.ServerRepository;
import ru.dankovtsev.smartcity.service.ConnectionServerConfig;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/smartcity")
public class ServerController {

    @Autowired
    private ConnectionServerConfig connectionServerConfig;
    @Autowired
    private ServerRepository serverRepository;
    @RequestMapping(path = "/status", method = RequestMethod.GET)
    public List<Server> getstatuserver(){
        System.out.println("check");
        //List<Server> servers = serverRepository.findAll();
        return connectionServerConfig.getListServer();
    }
}
