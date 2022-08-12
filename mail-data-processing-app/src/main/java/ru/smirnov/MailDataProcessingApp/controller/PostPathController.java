package ru.smirnov.MailDataProcessingApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.Converter;
import ru.smirnov.MailDataProcessingApp.dto.PostPathDTO;
import ru.smirnov.MailDataProcessingApp.dto.ReceiverDTO;
import ru.smirnov.MailDataProcessingApp.models.PostPath;
import ru.smirnov.MailDataProcessingApp.response.PostPathResponse;
import ru.smirnov.MailDataProcessingApp.services.PostPathService;

@RestController
@RequestMapping("postPath")
@AllArgsConstructor
public class PostPathController {
    private final Converter converter;
    private final PostPathService postPathService;

    @GetMapping
    @Tag(name = "Список всех путей", description = "Получение списка всех путей из бд")
    public PostPathResponse getAllPostPath() {
        return converter.converterToPostPath();
    }

    @PostMapping("/save")
    @Tag(name = "Сохранение пути", description = "Сохранение пути посылки в бд")
    public ResponseEntity<HttpStatus> savePostPath(@RequestBody PostPathDTO postPathDTO,
                                                   BindingResult bindingResult) {
        postPathService.savePostPath(converter.converterToPostPath(postPathDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Прибытие в почтовое отделение", description = "Временная отметка в бд")
    @PutMapping("/{identification}/arrivalToPostOffice")
    public ResponseEntity<HttpStatus> arrivalToPostOffice(@PathVariable("identification") int identification) {
        postPathService.updatePostPathArrivalToPostOffice(identification);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Отправка из почтового отделения", description = "Временная отметка в бд")
    @PutMapping("/{identification}/departureFromPostOffice")
    public ResponseEntity<HttpStatus> departureFromPostOffice(@PathVariable("identification") int identification) {
        postPathService.updatePostPathDepartureFromPostOffice(identification);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Изменение почтового отделения", description = "Изменение почтового отделения на новое")
    @PutMapping("/{identification}/changePostOffice")
    public ResponseEntity<HttpStatus> changePostOffice(@PathVariable int identification,
                                                       @RequestBody PostPathDTO postPathDTO) {
        postPathService.changePostOffice(identification, converter.converterToPostPath(postPathDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
