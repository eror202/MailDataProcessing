package ru.smirnov.MailDataProcessingApp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.smirnov.MailDataProcessingApp.dto.TypesOfPostDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TypesOfPostResponse {
    private List<TypesOfPostDTO> typesOfPostDTOList;

}
