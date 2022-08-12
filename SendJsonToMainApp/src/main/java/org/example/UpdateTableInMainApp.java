package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


public class UpdateTableInMainApp {
    public static void main(String[] args) {
        final int index = 222222;
        final String address = "Москва измененный";
        final String name = "Смирнов измененный";
        final int identification = 3;

        updateReceiver(index,address,name,identification);
    }
    public static void updateReceiver(int index, String address, String name, int identification){
        final String url = "http://localhost:8091/receiver/"+identification;
        Map<String,Object> jsonData = new HashMap<>();

        jsonData.put("index", index);
        jsonData.put("address", address);
        jsonData.put("name", name);
        jsonData.put("isDelivered",false);
        jsonData.put("identification", identification);

        makePostRequestWithJSONData(url,jsonData);
    }
    private static void makePostRequestWithJSONData(String url, Map<String, Object> jsonData) {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);

        try {
            restTemplate.put(url, request, String.class);

            System.out.println("Получатель зарегестрирован");
        } catch (HttpClientErrorException e) {
            System.out.println("ОШИБКА!");
            System.out.println(e.getMessage());
        }
    }
}
