package ru.smirnov.MailDataProcessingApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.ConverterAndDBLogic;
import ru.smirnov.MailDataProcessingApp.dto.PostOfficeDTO;
import ru.smirnov.MailDataProcessingApp.response.PostOfficeResponse;

@RestController
@RequestMapping("postOffice")
@AllArgsConstructor
public class PostOfficeController {
    private final ConverterAndDBLogic converterAndDBLogic;

    @GetMapping
    public PostOfficeResponse getAllPostOffice(){
        return converterAndDBLogic.converterToPostOfficeDTOAndResponse();
    }

    @PostMapping("/savePostOffice")
    public ResponseEntity<HttpStatus> savePostOffice(@RequestBody PostOfficeDTO postOfficeDTO){
        converterAndDBLogic.converterToPostOfficeAndSave(postOfficeDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
