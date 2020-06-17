package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Transport;
import ru.dankovtsev.smartcity.model.TransportAvg;
import ru.dankovtsev.smartcity.repository.TransportRepository;
import ru.dankovtsev.smartcity.service.TransportService;

import java.text.DecimalFormat;
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
            if (responseEntity!=null) {
                DecimalFormat df = new DecimalFormat("#,##");
                Transport transport = new Transport();
                transport.setId(responseEntity.getBody().getId());
                transport.setTime(responseEntity.getBody().getTime());
                transport.setStatus(responseEntity.getBody().getStatus());
                transport.setTypeCargo(responseEntity.getBody().getTypeCargo());
                transport.setX(Double.parseDouble(df.format(responseEntity.getBody().getX())));
                transport.setY(Double.parseDouble(df.format(responseEntity.getBody().getY())));
                return transport;
            }
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

    public TransportAvg transportAvg(LocalDateTime from, LocalDateTime to) {
        int g1=0;
        int g2=0;
        int g3=0;
        int g4=0;
        int g5=0;
        int g6=0;
        int g7=0;
        int g8=0;
        int g9=0;
        int g10=0;
        int gOther=0;

        List<Transport> transportList = transportRepository.getTransportForDate(from,to);
        for (Transport transport : transportList) {
            switch (transport.getTypeCargo()){
                case "1.0": {g1++; break;}
                case "2.0": {g2++; break;}
                case "3.0": {g3++; break;}
                case "4.0": {g4++; break;}
                case "5.0": {g5++; break;}
                case "6.0": {g6++; break;}
                case "7.0": {g7++; break;}
                case "8.0": {g8++; break;}
                case "9.0": {g9++; break;}
                case "0.0": {g10++; break;}
                default: gOther++;break;
            }
        }
        TransportAvg transportAvg = new TransportAvg(g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,gOther, transportList.size());
        return transportAvg;
    }
}
