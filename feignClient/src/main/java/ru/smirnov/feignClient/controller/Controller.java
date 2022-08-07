package ru.smirnov.feignClient.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smirnov.feignClient.client.FeignClient;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("testFeign")
public class Controller {
    private final FeignClient feignClient;

    @GetMapping
    public ResponseEntity<Map<String,Object>> getReceivers(){
        return ResponseEntity.ok(feignClient.getReceivers().getBody());
    }
}
