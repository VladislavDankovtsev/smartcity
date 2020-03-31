package ru.dankovtsev.smartcity.service.iml;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.service.ProductionService;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.URL_PRODUCTION_ONLINE;

@Service
public class ProductionServiceIml implements ProductionService {

    @Override
    public Production online() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Production> responseEntity = restTemplate.getForEntity(URL_PRODUCTION_ONLINE,
                Production.class);
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }
}
