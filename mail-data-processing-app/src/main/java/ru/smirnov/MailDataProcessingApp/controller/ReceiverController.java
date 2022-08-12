package ru.smirnov.MailDataProcessingApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.Converter;
import ru.smirnov.MailDataProcessingApp.dto.ReceiverDTO;
import ru.smirnov.MailDataProcessingApp.response.ReceiverResponse;
import ru.smirnov.MailDataProcessingApp.services.ReceiverService;

@RestController
@AllArgsConstructor
@RequestMapping("receiver")
public class ReceiverController {
    private final ReceiverService receiverService;
    private final Converter converter;

    @GetMapping
    @Tag(name = "Список всех получателей", description = "получить список всех получателей посылок")
    public ReceiverResponse getAllReceivers(){
        return converter.converterToReceiverDTO();
    }

    @PostMapping("/registration")
    @Tag(name = "Сохранение получателя", description = "Сохранить получателя в базу данных")
    public ResponseEntity<HttpStatus> saveReceiver(@RequestBody ReceiverDTO receiverDTO,
                                                       BindingResult bindingResult){
        receiverService.saveReceiver(converter.converterToReceiver(receiverDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Обновление пользователя", description = "Обновление пользователя по его уникальному идентификатору")
    @PutMapping("/{identification}")
    public ResponseEntity<HttpStatus> updateReceiver(@PathVariable int identification,
                                                     @RequestBody ReceiverDTO receiverDTO){
        receiverService.updateReceiver(identification,converter.converterToReceiver(receiverDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @Tag(name = "Отметка о доставке", description = "Посылка пользователю доставлена(отметка по идентификатору пользователя)")
    @PutMapping("/{identification}/delivered")
    public ResponseEntity<HttpStatus> updateReceiver(@PathVariable int identification){
        receiverService.delivered(identification);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
