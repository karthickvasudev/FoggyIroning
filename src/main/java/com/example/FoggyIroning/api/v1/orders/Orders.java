package com.example.FoggyIroning.api.v1.orders;

import com.example.FoggyIroning.api.v1.orderlines.OrderLines;
import com.example.FoggyIroning.api.v1.orders.constants.ORDERSTATUS;
import com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @GenericGenerator(
            name = "order_seq",
            strategy = "com.example.FoggyIroning.sequencegenerator.CustomSequenceGenerator",
            parameters = {
                    @Parameter(name = CustomSequenceGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomSequenceGenerator.PREFIX, value = "ORD-"),
                    @Parameter(name = CustomSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id;
    private String customerId;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime startedDate;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime completedDate;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime expectedDeliveryDate;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime deliveredDate;
    private Integer count;
    private Double amount;
    @Enumerated(value = EnumType.STRING)
    private ORDERSTATUS status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "id")
    private List<OrderLines> orderLines;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime createOn;
    private String createUserName;
    private String createUserEmail;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssa")
    private LocalDateTime lastUpdatedOn;
    private String lastUpdatedUserName;
    private String lastUpdatedEmail;
}
