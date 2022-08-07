package ru.smirnov.MailDataProcessingApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.smirnov.MailDataProcessingApp.dto.PostPathDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostPathResponse {
    private List<PostPathDTO> postPathDTOList;
}
