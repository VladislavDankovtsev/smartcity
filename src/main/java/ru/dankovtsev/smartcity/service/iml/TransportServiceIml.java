package ru.dankovtsev.smartcity.service.iml;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Transport;
import ru.dankovtsev.smartcity.service.TransportService;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.URL_TRANSPORT_ONLINE;

@Service
public class TransportServiceIml implements TransportService {
    @Override
    public Transport online() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Transport> responseEntity = restTemplate.getForEntity(URL_TRANSPORT_ONLINE,
                Transport.class);
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }
}
