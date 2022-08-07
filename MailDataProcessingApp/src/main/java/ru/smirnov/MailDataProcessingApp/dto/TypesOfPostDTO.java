package ru.smirnov.MailDataProcessingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.smirnov.MailDataProcessingApp.models.Receiver;

@Getter
@Setter
@AllArgsConstructor
public class TypesOfPostDTO {
    private String type;

    private Receiver recipientIdentification;
}
