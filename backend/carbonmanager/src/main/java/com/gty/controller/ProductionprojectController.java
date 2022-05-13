package com.gty.controller;


import com.gty.service.ProductionprojectService;
import com.gty.entity.Productionproject;
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
@RequestMapping("/productionproject")
public class ProductionprojectController {
    @Autowired
    private ProductionprojectService productionprojectService;


    @GetMapping("/list")
    public List<Productionproject> list(){
        return this.productionprojectService.list();
    }
}

