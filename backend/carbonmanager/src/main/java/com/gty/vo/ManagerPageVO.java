package com.gty.vo;

import lombok.Data;

import java.util.List;

@Data
public class ManagerPageVO {

    private List<ManagerVO> data;

    private Long total;
}
