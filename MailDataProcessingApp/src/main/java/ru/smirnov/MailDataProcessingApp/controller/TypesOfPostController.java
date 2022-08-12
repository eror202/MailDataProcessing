package ru.smirnov.MailDataProcessingApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.Converter;
import ru.smirnov.MailDataProcessingApp.dto.ReceiverDTO;
import ru.smirnov.MailDataProcessingApp.dto.TypesOfPostDTO;
import ru.smirnov.MailDataProcessingApp.models.TypesOfPost;
import ru.smirnov.MailDataProcessingApp.response.TypesOfPostResponse;
import ru.smirnov.MailDataProcessingApp.services.TypesOfPostService;


@RestController
@RequestMapping("typesOfPost")
@AllArgsConstructor
public class TypesOfPostController {
    private final Converter converter;
    private final TypesOfPostService typesOfPostService;

    @GetMapping
    @Tag(name = "Список посылок", description = "Получение списка всех посылок")
    public TypesOfPostResponse getAllTypesOfPost(){
        return converter.converterToTypesOfPostDTO();
    }
    @PostMapping("/registration")
    @Tag(name = "Регистрация посылки", description = "Внесение новой посылке получателю в базу данных")
    public ResponseEntity<HttpStatus> saveTypesOfPost(@RequestBody TypesOfPostDTO typesOfPostDTO,
                                                      BindingResult bindingResult){
        typesOfPostService.saveTypeOfPost(converter.converterToTypesOfPost(typesOfPostDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Изменение посылки", description = "Изменения типа посылки по уникальному идентификатору получателя")
    @PutMapping("/update/{identification}")
    public ResponseEntity<HttpStatus> updateTypeOfPost(@PathVariable int identification,
                                                       @RequestBody TypesOfPostDTO typesOfPostDTO){
        typesOfPostService.updateTypeOfPost(identification,converter.converterToTypesOfPost(typesOfPostDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Посылка", description = "Поиск посылки по уникальному идентификатору получателя")
    @GetMapping("/{identification}")
    public TypesOfPostDTO getReceiverByIdentification(@PathVariable int identification){
        return converter.converterToTypesOfPostDTO(typesOfPostService.findOne(identification));
    }
}
