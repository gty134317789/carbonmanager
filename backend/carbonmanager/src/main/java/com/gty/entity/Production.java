package com.gty.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
    private String ProductNum;

    @TableField("CompanyCode")
    private String CompanyCode;

    @TableField("ProductName")
    private String ProductName;

    @TableField("BeginDate")
    private LocalDate BeginDate;

    @TableField("EndDate")
    private LocalDate EndDate;

    @TableField("Cost")
    private Double Cost;

    @TableField("CarbonEmission")
    private Double CarbonEmission;

    @TableField("Yield")
    private Double Yield;

    @TableField("Notes")
    private String Notes;


}
