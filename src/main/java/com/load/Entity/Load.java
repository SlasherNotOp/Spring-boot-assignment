package com.load.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Load {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loadId;

    private String loadingPoint;

    private String unloadingPoint;

    private String productType;

    private String truckType;

    private int noOfTrucks;

    private int weight;

    private String optional;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    private String shipperId;




}
