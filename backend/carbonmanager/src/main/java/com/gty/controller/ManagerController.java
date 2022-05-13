package com.gty.controller;


import com.gty.entity.Company;
import com.gty.service.ManagerService;
import com.gty.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GTY
 * @since 2022-05-12
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;


    @GetMapping("/List")
    public List<Manager> list(){
        return this.managerService.list();
    }
}

