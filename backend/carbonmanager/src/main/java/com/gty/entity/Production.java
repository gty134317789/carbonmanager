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

    @TableId("productNum")
    @JsonProperty(value = "productNum")
    private String  productNum;

    @TableField("companyCode")
    @JsonProperty(value = "companyCode")
    private String companyCode;

    @TableField("productName")
    @JsonProperty(value = "productName")
    private String productName;

    @TableField("beginDate")
    @JsonProperty(value = "beginDate")
    private LocalDate beginDate;

    @TableField("endDate")
    @JsonProperty(value = "endDate")
    private LocalDate endDate;

    @TableField("cost")
    @JsonProperty(value = "cost")
    private Double cost;

    @TableField("carbonEmission")
    @JsonProperty(value = "carbonEmission")
    private Double carbonEmission;

    @TableField("yield")
    @JsonProperty(value = "yield")
    private Double yield;

    @TableField("notes")
    @JsonProperty(value = "notes")
    private String notes;




}
