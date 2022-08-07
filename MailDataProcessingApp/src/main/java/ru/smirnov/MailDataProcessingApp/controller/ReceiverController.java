package ru.smirnov.MailDataProcessingApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smirnov.MailDataProcessingApp.converter.ConverterAndDBLogic;
import ru.smirnov.MailDataProcessingApp.dto.ReceiverDTO;
import ru.smirnov.MailDataProcessingApp.response.ReceiverResponse;
import ru.smirnov.MailDataProcessingApp.services.ReceiverService;

@RestController
@AllArgsConstructor
@RequestMapping("receiver")
public class ReceiverController {
    private final ReceiverService receiverService;
    private final ConverterAndDBLogic converterAndDBLogic;

    @GetMapping
    public ReceiverResponse getAllReceivers(){
        return converterAndDBLogic.converterToReceiverDTOAndResponse();
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> saveReceiver(@RequestBody ReceiverDTO receiverDTO,
                                                       BindingResult bindingResult){
        converterAndDBLogic.converterToReceiverAndSave(receiverDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
