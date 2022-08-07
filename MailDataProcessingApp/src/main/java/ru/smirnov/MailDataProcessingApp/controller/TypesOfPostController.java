package ru.smirnov.MailDataProcessingApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.ConverterAndDBLogic;
import ru.smirnov.MailDataProcessingApp.dto.TypesOfPostDTO;
import ru.smirnov.MailDataProcessingApp.response.TypesOfPostResponse;
import ru.smirnov.MailDataProcessingApp.services.TypesOfPostService;


@RestController
@RequestMapping("typesOfPost")
@AllArgsConstructor
public class TypesOfPostController {
    private final ConverterAndDBLogic converterAndDBLogic;
    private final TypesOfPostService typesOfPostService;

    @GetMapping
    public TypesOfPostResponse getAllTypesOfPost(){
        return converterAndDBLogic.converterToTypesOfPostDTOAndResponse();
    }
    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> saveTypesOfPost(@RequestBody TypesOfPostDTO typesOfPostDTO,
                                                      BindingResult bindingResult){
        converterAndDBLogic.converterToTypesOfPostAndSave(typesOfPostDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
