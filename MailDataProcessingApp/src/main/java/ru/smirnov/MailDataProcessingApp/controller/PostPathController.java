package ru.smirnov.MailDataProcessingApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.ConverterAndDBLogic;
import ru.smirnov.MailDataProcessingApp.dto.PostPathDTO;
import ru.smirnov.MailDataProcessingApp.response.PostPathResponse;

@RestController
@RequestMapping("postPath")
@AllArgsConstructor
public class PostPathController {
    private final ConverterAndDBLogic converterAndDBLogic;
    @GetMapping
    public PostPathResponse getAllPostPath(){
        return converterAndDBLogic.converterToPostPathAndResponse();
    }
    @PostMapping("save")
    public ResponseEntity<HttpStatus> savePostPath(@RequestBody PostPathDTO postPathDTO,
                                                   BindingResult bindingResult){
        converterAndDBLogic.converterToPostPathAndSave(postPathDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
