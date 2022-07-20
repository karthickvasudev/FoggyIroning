package com.example.FoggyIroning.api.v1.orderlines;

import com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "OrderLines")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLines {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderlines_seq")
    @GenericGenerator(
            name = "orderlines_seq",
            strategy = "com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator",
            parameters = {
                    @Parameter(name = CustomSequenceGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomSequenceGenerator.PREFIX, value = "OL-"),
                    @Parameter(name = CustomSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;
    private String productId;
    private String productName;
    private Integer count;
    private Double price;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss a")
    private LocalDateTime createdOn;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss a")
    private LocalDateTime lastUpdatedOn;
}
