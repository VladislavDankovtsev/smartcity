package ru.dankovtsev.smartcity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dankovtsev.smartcity.model.CheckConnection;
import ru.dankovtsev.smartcity.model.Server;
import ru.dankovtsev.smartcity.repository.ServerRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.dankovtsev.smartcity.other.UrlSmartCityModule.*;

@Service
@Configuration
@EnableScheduling
public class ConnectionServerConfig {

    private List<Server> listServer = new ArrayList<>();
    @Autowired
    private ServerRepository serverRepository;

    @Scheduled(fixedDelay = 5000)
    public void check(){
        //serverRepository.deleteAll();
        List<Server> checkServer = new ArrayList<>();
        String checkAgriculture = checkAgriculture();
        Server s1 = new Server((long) 1,URL_AGRICULTURE_CHECK,"Сельское хозяйство",checkAgriculture);
        checkServer.add(s1);
        //serverRepository.save(s1);
        String checkSmartHome = checkSmartHome();
        Server s2 = new Server((long) 2,URL_SMART_HOME_CHECK,"Умный дом",checkSmartHome);
        checkServer.add(s2);
        //serverRepository.save(s2);
        String chechProduction = checkProduction();
        Server s3 = new Server((long) 3,URL_PRODUCTION_CHECK,"Производство",chechProduction);
        checkServer.add(s3);
        //serverRepository.save(s3);
        String checkTransport = checkTransport();
        Server s4 = new Server((long) 4,URL_TRANSPORT_CHECK,"Транспорт",checkTransport);
        checkServer.add(s4);
        //serverRepository.save(s4);
        listServer.clear();
        for (Server server : checkServer) {
            listServer.add(server);
        }
        checkServer.clear();
    }


    public String checkAgriculture(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CheckConnection> responseEntity = restTemplate.getForEntity(URL_AGRICULTURE_CHECK,
                CheckConnection.class);
            System.out.println(responseEntity.getBody().getCheck());
            if(responseEntity.getBody().getCheck().equals("work")){
                return "on";
            }else return "off";
        }
        catch (Exception e){
            return "off";
        }
    }

    public String checkTransport(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CheckConnection> responseEntity = restTemplate.getForEntity(URL_TRANSPORT_CHECK,
                    CheckConnection.class);
            System.out.println(responseEntity.getBody().getCheck());
            if(responseEntity.getBody().getCheck().equals("work")){
                return "on";
            }else return "off";
        }
        catch (Exception e){
            return "off";
        }
    }
    public String checkSmartHome(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CheckConnection> responseEntity = restTemplate.getForEntity(URL_SMART_HOME_CHECK,
                    CheckConnection.class);
            System.out.println(responseEntity.getBody().getCheck());
            if(responseEntity.getBody().getCheck().equals("work")){
                return "on";
            }else return "off";
        }
        catch (Exception e){
            return "off";
        }
    }
    public String checkProduction(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CheckConnection> responseEntity = restTemplate.getForEntity(URL_PRODUCTION_CHECK,
                    CheckConnection.class);
            System.out.println(responseEntity.getBody().getCheck());
            if(responseEntity.getBody().getCheck().equals("work")){
                return "on";
            }else return "off";
        }
        catch (Exception e){
            return "off";
        }
    }

    public List<Server> getListServer(){

        return this.listServer;
    }

}
