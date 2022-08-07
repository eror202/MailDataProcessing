package ru.smirnov.MailDataProcessingApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.smirnov.MailDataProcessingApp.dto.ReceiverDTO;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ReceiverResponse {
    private List<ReceiverDTO> receiverDTOList;
}
