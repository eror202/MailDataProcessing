package ru.smirnov.MailDataProcessingApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types_of_post")
public class TypesOfPost implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "receiver_identification", referencedColumnName = "identification")
    private Receiver receiverIdentification;

}
