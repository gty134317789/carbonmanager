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
    public class Manager implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("ManagerID")
      private String ManagerID;

    @TableField("ManagerName")
    private String ManagerName;

    @TableField("ManagerDepartment")
    private String ManagerDepartment;

    @TableField("ManagerPhone")
    private String ManagerPhone;

    @TableField("ManagerFunds")
    private Double ManagerFunds;


}
