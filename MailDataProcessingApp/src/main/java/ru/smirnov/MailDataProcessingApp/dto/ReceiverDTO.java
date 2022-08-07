package ru.smirnov.MailDataProcessingApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverDTO {
    //@JsonProperty("index")
    private int index;

    //@JsonProperty("address")
    private String address;

    //@JsonProperty("name")
    private String name;

    //@JsonProperty("isDelivered")
    private boolean isDelivered;

    //@JsonProperty("identification")
    private int identification;
}
