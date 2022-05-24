package com.gty.entity;

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
    public class Company implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("companyCode")
    @JsonProperty(value = "companyCode")
    private String companyCode;

    @TableField("companyManager")
    @JsonProperty(value = "companyManager")
    private String companyManager;

    @TableField("companyAddress")
    @JsonProperty(value = "companyAddress")
    private String companyAddress;

    @TableField("companyIndustry")
    @JsonProperty(value = "companyIndustry")
    private String companyIndustry;

    @TableField("companyPhone")
    @JsonProperty(value = "companyPhone")
    private String companyPhone;

    @TableField("isUpToStandard")
    @JsonProperty(value = "isUpToStandard")
    private String isUpToStandard;


}
