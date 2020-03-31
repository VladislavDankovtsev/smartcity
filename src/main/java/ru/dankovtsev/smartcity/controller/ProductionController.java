package ru.dankovtsev.smartcity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.repository.ProductionRepository;
import ru.dankovtsev.smartcity.service.iml.ProductionServiceIml;

import java.util.List;

@RestController
@RequestMapping("/smartcity")
public class ProductionController {
    @Autowired
    private ProductionRepository productionRepository;
    @Autowired
    private ProductionServiceIml productionServiceIml;

    @RequestMapping(path = "/production", method = RequestMethod.GET)
    public List<Production> getProductionList(){
        List<Production> productionList = productionRepository.findAll();
        return productionList;
    }

    @RequestMapping(path = "/production/online", method = RequestMethod.GET)
    public Production getProductionOnline(){
        return productionServiceIml.online();
    }

}
