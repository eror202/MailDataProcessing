package ru.smirnov.MailDataProcessingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.smirnov.MailDataProcessingApp.models.PostOffice;
import ru.smirnov.MailDataProcessingApp.models.Receiver;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPathDTO {

    private PostOfficeDTO postOfficeName;

    private Receiver receiverIdentification;
}
