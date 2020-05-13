package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.Production;
import ru.dankovtsev.smartcity.model.SmartHome;
import ru.dankovtsev.smartcity.model.SmartHomeArray;
import ru.dankovtsev.smartcity.model.SmartHomeAvg;
import ru.dankovtsev.smartcity.repository.SmartHomeRepository;
import ru.dankovtsev.smartcity.service.SmartHomeService;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<SmartHomeArray> smartHomePeriod(LocalDateTime from, LocalDateTime to){
        List<SmartHome> smartHomes = smartHomeRepository.getSmartHomeForDate(from,to);
        List<SmartHomeArray> smartHomeArrays = new ArrayList<>();
        for (SmartHome smartHome : smartHomes) {
            SmartHomeArray smartHomeArray = new SmartHomeArray();
            smartHomeArray.setTime(smartHome.getTime());
            smartHomeArray.setTemperatureIn(Double.parseDouble(smartHome.getClimateControl().getTemperatureIn()));
            smartHomeArray.setTemperatureOut(Double.parseDouble(smartHome.getClimateControl().getTemperatureOut()));
            smartHomeArrays.add(smartHomeArray);
        }
        return smartHomeArrays;
    }

    public List<SmartHome> smartHomeFindAll(){
        return smartHomeRepository.findAll();
    }

    public SmartHomeAvg smartHomeAvg(LocalDateTime from, LocalDateTime to){
        List<SmartHome> smartHomes = smartHomeRepository.getSmartHomeForDate(from,to);
        double sumTempInCC = 0;
        double avgTempInCC = 0;
        long iti = 0;
        double sumTempOutCC = 0;
        double avgTempOutCC = 0;
        long ito = 0;
        long firstE = 0;
        long secondE = 0;
        long statusL = 0;
        long countPersonS = 0;
        long countSuccessPerson = 0;
        for (SmartHome smartHome : smartHomes) {
            if (smartHome.getClimateControl().getTemperatureIn()!=null){
                sumTempInCC += Double.parseDouble(smartHome.getClimateControl().getTemperatureIn());
                iti++;
            }
            if (smartHome.getClimateControl().getTemperatureOut()!=null){
                sumTempOutCC += Double.parseDouble(smartHome.getClimateControl().getTemperatureOut());
                ito++;
            }
            if (smartHome.getElevator().getPlace_arrival().equals("first"))
                firstE++;
            else secondE++;
            if (smartHome.getLighting().getSystem_status().equals("on")) statusL++;
            if (!smartHome.getSecurity().getId_personal().equals("unknown")) countPersonS++;
            if (smartHome.getSecurity().getDoor_status().equals("on")) countSuccessPerson++;
        }
        if (iti!=0) avgTempInCC= sumTempInCC/iti;
        if (ito!=0) avgTempOutCC = sumTempOutCC/ito;
        DecimalFormat df = new DecimalFormat("#,##");
        avgTempInCC = Double.parseDouble(df.format(avgTempInCC));
        avgTempOutCC = Double.parseDouble(df.format(avgTempOutCC));
        SmartHomeAvg smartHomeAvg = new SmartHomeAvg(avgTempInCC,avgTempOutCC,firstE,secondE,statusL,countPersonS,
                countSuccessPerson, smartHomes.size());
        return smartHomeAvg;
    }
}
