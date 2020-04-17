package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.repository.SmartHomeRepository;
import ru.dankovtsev.smartcity.service.SmartHomeService;

import java.time.LocalDateTime;
import java.util.List;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.URL_SMART_HOME_ONLINE;

@Service
public class SmartHomeServiceIml implements SmartHomeService {

    @Autowired
    private SmartHomeRepository smartHomeRepository;

    @Override
    public SmartHome online() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<SmartHome> responseEntity = restTemplate.getForEntity(URL_SMART_HOME_ONLINE,
                    SmartHome.class);
            if(responseEntity.getBody()!=null)
                return responseEntity.getBody();
            else return null;
        }catch (Exception e){
            return null;
        }

    }

    public List<SmartHome> smartHomePeriod(LocalDateTime from, LocalDateTime to){
        return smartHomeRepository.getSmartHomeForDate(from,to);
    }

    public List<SmartHome> smartHomeFindAll(){
        return smartHomeRepository.findAll();
    }
}
