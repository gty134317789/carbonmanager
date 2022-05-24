package com.gty.vo;

import lombok.Data;

import java.util.List;

@Data
public class CompanyPageVO {
    private List<CompanyVO> data;
    private Long total;
}
