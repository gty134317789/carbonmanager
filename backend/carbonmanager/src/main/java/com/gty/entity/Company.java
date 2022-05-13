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
    public class Company implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId("CompanyCode")
      private String CompanyCode;

    @TableField("CompanyManager")
    private String CompanyManager;

    @TableField("CompanyAddress")
    private String CompanyAddress;

    @TableField("CompanyIndustry")
    private String CompanyIndustry;

    @TableField("CompanyPhone")
    private String CompanyPhone;

    @TableField("IsUpToStandard")
    private String IsUpToStandard;


}
