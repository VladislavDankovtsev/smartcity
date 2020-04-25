package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.model.ProductionAvg;
import ru.dankovtsev.smartcity.repository.ProductionRepository;
import ru.dankovtsev.smartcity.service.ProductionService;

import java.time.LocalDateTime;
import java.util.List;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.URL_PRODUCTION_ONLINE;

@Service
public class ProductionServiceIml implements ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    @Override
    public Production online() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Production> responseEntity = restTemplate.getForEntity(URL_PRODUCTION_ONLINE,
                    Production.class);
            if (responseEntity!=null)
                return responseEntity.getBody();
            else
                return null;
        }catch (Exception  e){
            return null;
        }
    }

    public List<Production> productionsPeriod(LocalDateTime from, LocalDateTime to){
        return productionRepository.getProductionForDate(from,to);
    }

    public List<Production> productionFindAll(){
        return productionRepository.findAll();
    }

    public ProductionAvg productionAvg(LocalDateTime from, LocalDateTime to){
        long count=0;
        List<Production> productionList = productionRepository.getProductionForDate(from,to);
        for (Production production : productionList) {
            if((production.getManipulator1()==5)&&(production.getManipulator2()==1)) count++;
        }
        ProductionAvg productionAvg = new ProductionAvg();
        productionAvg.setCount(count);
        return productionAvg;
    }
}
