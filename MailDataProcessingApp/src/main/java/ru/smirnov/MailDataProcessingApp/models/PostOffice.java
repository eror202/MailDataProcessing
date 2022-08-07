package ru.smirnov.MailDataProcessingApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_office")
@Getter
@Setter
@NoArgsConstructor
public class PostOffice implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "index")
    private int index;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
