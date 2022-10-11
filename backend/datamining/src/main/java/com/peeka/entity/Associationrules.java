package com.peeka.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author PEEKA
 * @since 2022-06-24
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Associationrules implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String productone;

    private String producttwo;

    private String productthree;

    private String productfour;



}
