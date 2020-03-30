package ru.dankovtsev.smartcity.service.iml;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.service.SmartHomeService;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.URL_SMART_HOME_ONLINE;

@Service
public class SmartHomeServiceIml implements SmartHomeService {

    @Override
    public SmartHome online() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SmartHome> responseEntity = restTemplate.getForEntity(URL_SMART_HOME_ONLINE,
                SmartHome.class);
        System.out.println(responseEntity.getBody().toString());

        return responseEntity.getBody();
    }
}
