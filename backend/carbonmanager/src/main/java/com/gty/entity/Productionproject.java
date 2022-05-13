package com.gty.entity;

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
    public class Productionproject implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("ProductCode")
      private String ProductCode;

    @TableField("ProductName")
    private String ProductName;

    @TableField("Cost")
    private Double Cost;

    @TableField("CarbonEmission")
    private Double CarbonEmission;

    @TableField("Yield")
    private Double Yield;

    @TableField("Profit")
    private Double Profit;

    @TableField("ProductManager")
    private String ProductManager;


}
