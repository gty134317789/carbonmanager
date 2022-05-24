package com.gty.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDate;

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
    public class Manager implements Serializable {

    private static final long serialVersionUID=1L;


    @TableId("managerid")
    @JsonProperty(value = "managerid")
    private String  managerid;

    @TableField("managername")
    @JsonProperty(value = "managername")
    private String managername;

    @TableField("managerdepartment")
    @JsonProperty(value = "managerdepartment")
    private String managerdepartment;

    @TableField("managerphone")
    @JsonProperty(value = "managerphone")
    private String managerphone;

    @TableField("managerfunds")
    @JsonProperty(value = "managerfundse")
    private Double managerfunds;


}
