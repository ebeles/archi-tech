package com.example.javaweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    private String name;

    private String location;

    private String description;

    private Date date;

    private int categoryid;

    private int clientid;

    private int statusid;




    @ManyToOne
    @JoinColumn(name="categoryid", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="clientid", insertable = false, updatable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name="statusid", insertable = false, updatable = false)
    private Status status;


}
