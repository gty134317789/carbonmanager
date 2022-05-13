package com.gty.vo;


import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductionVO {
    private String ProductNum;

    private String CompanyCode;

    private String ProductName;

    private LocalDate BeginDate;

    private LocalDate EndDate;

    private Double Cost;

    private Double CarbonEmission;

    private Double Yield;

    private String Notes;

}
