package com.peeka.vo;

import lombok.Data;

import java.util.List;

@Data
public class clusterpagevo {
    private List<clustervo> data;
    private Long total;
}
