package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class SendJsonToMainApp {
    public static void main(String[] args) {
        final int index = 333333;
        final String address = "Москва";
        final String name = "Смирнов";
        final int identification = 3;

    registerRecipient(index,address,name,identification);

        final String type = "PACKAGE";
        registerTypeOfPost(type,identification);

        final int postOfficeIndex = 123321;
        final String postOfficeName = "У Никиты в очке";
        final String addressPostOffice = "Серпухов";
       registerPostOffice(postOfficeIndex,postOfficeName,addressPostOffice);
       registerPostPath(postOfficeName,identification, postOfficeIndex,addressPostOffice);
    }

    public static void registerRecipient(int index, String address, String name, int identification){
final String url = "http://localhost:8091/receiver/registration";
        Map<String,Object> jsonData = new HashMap<>();

jsonData.put("index", index);
jsonData.put("address", address);
jsonData.put("name", name);
jsonData.put("isDelivered",false);
jsonData.put("identification", identification);

makePostRequestWithJSONData(url,jsonData);
    }

    public static void registerTypeOfPost(String type, int identification){
        final String url = "http://localhost:8091/typesOfPost/registration";
        Map<String,Object> jsonData = new HashMap<>();
        jsonData.put("type",type);
        Map<String,Object> mapToMap = new HashMap<>();
        mapToMap.put("identification", identification);
        jsonData.put("receiverIdentification", mapToMap);
        makePostRequestWithJSONData(url,jsonData);
    }

    public static void registerPostOffice(int postOfficeIndex, String postOfficeName, String addressPostOffice){
        final String url = "http://localhost:8091/postOffice/savePostOffice";
        Map<String,Object> jsonData = new HashMap<>();
        jsonData.put("index", postOfficeIndex);
        jsonData.put("name", postOfficeName);
        jsonData.put("address",addressPostOffice);
        makePostRequestWithJSONData(url,jsonData);
    }

    public static void registerPostPath(String postOfficeName, int identification
            , int postOfficeIndex, String addressPostOffice){
        final String url = "http://localhost:8091/postPath/save";
        Map<String,Object> jsonData = new HashMap<>();
        Map<String,Object> mapToMap = new HashMap<>();
        Map<String,Object> mapToMap2 = new HashMap<>();
        mapToMap.put("name",postOfficeName);
        mapToMap.put("index",postOfficeIndex);
        mapToMap.put("address", addressPostOffice);
        jsonData.put("postOfficeName",mapToMap);
        mapToMap2.put("identification", identification);
        jsonData.put("receiverIdentification",mapToMap2);
        makePostRequestWithJSONData(url,jsonData);
    }
    private static void makePostRequestWithJSONData(String url, Map<String, Object> jsonData) {
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);

        try {
            restTemplate.postForObject(url, request, String.class);

            System.out.println("Получатель зарегестрирован");
        } catch (HttpClientErrorException e) {
            System.out.println("ОШИБКА!");
            System.out.println(e.getMessage());
        }
    }
}