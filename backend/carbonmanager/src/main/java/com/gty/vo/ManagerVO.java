package com.gty.vo;

import lombok.Data;

@Data
public class ManagerVO extends CompanyVO {

    private String managerid;

    private String managername;

    private String managerdepartment;

    private String managerphone;

    private Double managerfunds;

}
