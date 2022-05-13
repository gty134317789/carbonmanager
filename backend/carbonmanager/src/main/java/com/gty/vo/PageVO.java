package com.gty.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO {
    private List<ProductionVO> data;
    private Long total;
}
