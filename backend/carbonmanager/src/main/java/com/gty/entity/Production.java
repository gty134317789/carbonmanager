package com.gty.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
@Data

  @EqualsAndHashCode(callSuper = false)

    public class Production implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ProductNum")
    @JsonProperty(value = "ProductNum")
    private String ProductNum;

    @TableField("CompanyCode")
    @JsonProperty(value = "CompanyCode")
    private String CompanyCode;

    @TableField("ProductName")
    @JsonProperty(value = "ProductName")
    private String ProductName;

    @TableField("BeginDate")
    @JsonProperty(value = "BeginDate")
    private LocalDate BeginDate;

    @TableField("EndDate")
    @JsonProperty(value = "EndDate")
    private LocalDate EndDate;

    @TableField("Cost")
    @JsonProperty(value = "Cost")
    private Double Cost;

    @TableField("CarbonEmission")
    @JsonProperty(value = "CarbonEmission")
    private Double CarbonEmission;

    @TableField("Yield")
    @JsonProperty(value = "Yield")
    private Double Yield;

    @TableField("Notes")
    @JsonProperty(value = "Notes")
    private String Notes;




}
