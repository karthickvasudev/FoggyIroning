package com.example.FoggyIroning.api.v1.products.modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProductModal {
    private String productName;
    private Integer quantity;
    private Double price;
    private Boolean active;
    private String createdUserName;
    private String createdUserEmail;
    private LocalDateTime createdOn;
    private String lastUpdatedUserName;
    private String lastUpdatedUserEmail;
    private LocalDateTime lastUpdatedOn;
}
