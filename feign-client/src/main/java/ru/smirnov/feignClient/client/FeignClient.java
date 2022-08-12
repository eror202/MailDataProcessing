package ru.smirnov.feignClient.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@org.springframework.cloud.openfeign.FeignClient(name = "data",url = "http://localhost:8090/receiver")
public interface FeignClient {
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Map<String,Object>> getReceivers();
}
