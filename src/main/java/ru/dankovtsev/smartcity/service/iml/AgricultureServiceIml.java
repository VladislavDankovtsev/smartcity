package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Agriculture;
import ru.dankovtsev.smartcity.model.CheckConnection;
import ru.dankovtsev.smartcity.other.UrlSmartCityModule;
import ru.dankovtsev.smartcity.repository.AgriculureRepository;
import ru.dankovtsev.smartcity.service.AgricultureService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.*;

@Service
public class AgricultureServiceIml implements AgricultureService {

    @Autowired
    private AgriculureRepository agriculureRepository;

    @Override
    public Agriculture online() {
        //HttpEntity<Agriculture> entity = new HttpEntity<Agriculture>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Agriculture> responseEntity = restTemplate.getForEntity(URL_AGRICULTURE_ONLINE,
                    Agriculture.class);
            if (responseEntity.getBody()!=null)
                return responseEntity.getBody();
            else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Agriculture> agriculturePeriod(LocalDateTime from, LocalDateTime to){
        return agriculureRepository.getAgrigultureForDate(from,to);
    }

    public List<Agriculture> agricultureFindAll(){
        return agriculureRepository.findAll();
    }


}
