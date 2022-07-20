package com.example.FoggyIroning.api.v1.products;

import com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "Product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @GenericGenerator(
            name = "product_seq",
            strategy = "com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator",
            parameters = {
                    @Parameter(name = CustomSequenceGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomSequenceGenerator.PREFIX, value = "PRD-"),
                    @Parameter(name = CustomSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Boolean active;
    private String createdUserName;
    private String createdUserEmail;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss a")
    private LocalDateTime createdOn;
    private String lastUpdatedUserName;
    private String lastUpdatedUserEmail;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss a")
    private LocalDateTime lastUpdatedOn;
}
