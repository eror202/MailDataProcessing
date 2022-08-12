package ru.smirnov.MailDataProcessingApp.controller;

import feign.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.Converter;
import ru.smirnov.MailDataProcessingApp.dto.PostOfficeDTO;
import ru.smirnov.MailDataProcessingApp.response.PostOfficeResponse;
import ru.smirnov.MailDataProcessingApp.services.PostOfficeService;

@RestController
@RequestMapping("postOffice")
@AllArgsConstructor
public class PostOfficeController {
    private final Converter converter;
    private final PostOfficeService postOfficeService;
    @Tag(name = "Список всех почтовых отделений", description = "Получение списка почтовых отделений из бд")
    @GetMapping
    public PostOfficeResponse getAllPostOffice(){
        return converter.converterToPostOfficeDTO();
    }
    @Tag(name = "Новое почтовое отделение", description = "Сохранение почтового отделения в бд")
    @PostMapping("/savePostOffice")
    public ResponseEntity<HttpStatus> savePostOffice(@RequestBody PostOfficeDTO postOfficeDTO){
        postOfficeService.savePostOffice(converter.converterToPostOffice(postOfficeDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Обновление почтового отделения", description = "Изменение данных почтового отделения по уникальному индексу")
    @PutMapping("/{index}")
    public ResponseEntity<HttpStatus> updatePostOffice(@RequestBody PostOfficeDTO postOfficeDTO,
                                                       @PathVariable int index){
        postOfficeService.updatePostOffice(index,converter.converterToPostOffice(postOfficeDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
