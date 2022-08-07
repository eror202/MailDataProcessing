package ru.smirnov.MailDataProcessingApp.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "RECEIVER")
@Getter
@Setter
@NoArgsConstructor
public class Receiver implements Serializable {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "INDEX")
    @NotNull
    private int index;

    @Column(name = "ADDRESS")
    @NotNull
    private String address;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "IS_DELIVERED")

    private boolean isDelivered;

    @Column(name = "TIME_OF_DELIVERED")
    private String timeOfDelivered;

    @Column(name = "IDENTIFICATION")
    private int identification;
}
