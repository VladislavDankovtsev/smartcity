package ru.dankovtsev.smartcity.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.*;
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

    public AgricultureAvg agricultureHistoryAvg(LocalDateTime from, LocalDateTime to){
        Agriculture agriculture = new Agriculture();
        SoilMoisture soilMoisture = new SoilMoisture();
        TemperatureAndHumidity temperatureAndHumidity = new TemperatureAndHumidity();
        double avgHumiditySoilMoisture = 0;
        double sumAvgHumiditySoilMoisture = 0;
        int countWaterSoilMoisture=0;
        double avgHumidityTemperatureAndHumidity=0;
        double sumAvgHumidityTemperatureAndHumidity=0;
        double avgTemperatureTemperatureAndHumidity=0;
        double sumAvgTemperatureTemperatureAndHumidity=0;
        int countFanTemperatureAndHumidity=0;
        int countHeatingElementTemperatureAndHumidity=0;
        int ism=0;
        int ihth=0;
        int itth=0;
        List<Agriculture> agricultureList = agriculureRepository.getAgrigultureForDate(from,to);
        for (Agriculture agr : agricultureList) {
            if(agr.getSoilMoisture().getHumidity()!=null) {
                sumAvgHumiditySoilMoisture += Double.parseDouble(agr.getSoilMoisture().getHumidity());
                ism++;
            }
            if(agr.getSoilMoisture().getWater()) countWaterSoilMoisture++;

            if(agr.getTemperatureAndHumidity().getHumidity()!=null) {
                sumAvgHumidityTemperatureAndHumidity += Double.parseDouble(agr.getTemperatureAndHumidity().getHumidity());
                ihth++;
            }
            if(agr.getTemperatureAndHumidity().getTemperature()!=null) {
                sumAvgTemperatureTemperatureAndHumidity += Double.parseDouble(agr.getTemperatureAndHumidity().getTemperature());
                itth++;
            }
            if (agr.getTemperatureAndHumidity().getFan()) countFanTemperatureAndHumidity++;
            if (agr.getTemperatureAndHumidity().getHeatingElement()) countHeatingElementTemperatureAndHumidity++;
        }
        if (ism!=0) avgHumiditySoilMoisture = sumAvgHumiditySoilMoisture/ism;
        if (ihth!=0) avgHumidityTemperatureAndHumidity = sumAvgHumidityTemperatureAndHumidity/ihth;
        if (itth!=0) avgTemperatureTemperatureAndHumidity = sumAvgTemperatureTemperatureAndHumidity/itth;
        AgricultureAvg agricultureAvg = new AgricultureAvg();
        agricultureAvg.setAvgHumiditySM(avgHumiditySoilMoisture);
        agricultureAvg.setAvgHumidityTH(avgHumidityTemperatureAndHumidity);
        agricultureAvg.setAvgTemperatureTH(avgTemperatureTemperatureAndHumidity);
        agricultureAvg.setCountFanTH(countFanTemperatureAndHumidity);
        agricultureAvg.setCountWaterSM(countWaterSoilMoisture);
        agricultureAvg.setCountHeatingElementTH(countHeatingElementTemperatureAndHumidity);
        return agricultureAvg;
    }


}
