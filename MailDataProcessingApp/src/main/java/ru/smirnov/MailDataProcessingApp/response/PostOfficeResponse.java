package ru.smirnov.MailDataProcessingApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.smirnov.MailDataProcessingApp.dto.PostOfficeDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostOfficeResponse {
    private List<PostOfficeDTO> postOfficeDTOList;
}
