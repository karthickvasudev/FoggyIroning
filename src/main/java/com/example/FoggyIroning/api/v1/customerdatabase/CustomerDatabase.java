package com.example.FoggyIroning.api.v1.customerdatabase;

import com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "CustomerDatabase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @GenericGenerator(
            name = "customer_seq",
            strategy = "com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator",
            parameters = {
                    @Parameter(name = CustomSequenceGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomSequenceGenerator.PREFIX, value = "C-"),
                    @Parameter(name = CustomSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String pinCode;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss a")
    private LocalDateTime createOn;
    private String createUserName;
    private String createUserEmail;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss aa")
    private LocalDateTime lastUpdatedOn;
    private String lastUpdatedUserName;
    private String lastUpdatedEmail;
}
