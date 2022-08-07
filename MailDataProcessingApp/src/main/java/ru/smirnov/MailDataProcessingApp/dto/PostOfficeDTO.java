package ru.smirnov.MailDataProcessingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostOfficeDTO {
    private int index;

    private String name;

    private String address;
}
