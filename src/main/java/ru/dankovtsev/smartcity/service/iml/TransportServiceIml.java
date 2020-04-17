package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.model.Transport;
import ru.dankovtsev.smartcity.repository.TransportRepository;
import ru.dankovtsev.smartcity.service.TransportService;

import java.time.LocalDateTime;
import java.util.List;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.URL_TRANSPORT_ONLINE;

@Service
public class TransportServiceIml implements TransportService {

    @Autowired
    private TransportRepository transportRepository;
    @Override
    public Transport online() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Transport> responseEntity = restTemplate.getForEntity(URL_TRANSPORT_ONLINE,
                    Transport.class);
            if (responseEntity!=null)
                return responseEntity.getBody();
            else
                return null;
        }
        catch (Exception e){
            return  null;
        }

        //System.out.println(responseEntity.getBody().toString());


    }

    public List<Transport> transportPeriod(LocalDateTime from, LocalDateTime to){
        return transportRepository.getTransportForDate(from,to);
    }

    public List<Transport> transportFindAll(){
        return transportRepository.findAll();
    }

}
