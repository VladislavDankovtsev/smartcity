package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.other.UrlSmartCityModule;
import ru.dankovtsev.smartcity.service.AgricultureService;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.*;

@Service
public class AgricultureServiceIml implements AgricultureService {

    @Override
    public Agriculture online() {
        //HttpEntity<Agriculture> entity = new HttpEntity<Agriculture>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Agriculture> responseEntity = restTemplate.getForEntity(URL_AGRICULTURE_ONLINE,
                Agriculture.class);
        System.out.println(responseEntity.getBody().toString());

        return responseEntity.getBody();
    }
}
